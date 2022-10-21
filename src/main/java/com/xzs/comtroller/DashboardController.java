package com.xzs.comtroller;

import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.result.Row;
import com.xzs.mapper.*;
import com.xzs.pojo.*;
import com.xzs.vo.*;


import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
@RequestMapping("/api/admin/")
public class DashboardController {//主页
    private TexamPaperExample texamPaperExample = new TexamPaperExample();
    private  TaskExamExample taskExamExample = new TaskExamExample();
    @Autowired
    private TaskExamMapper taskExamMapper;
    @Autowired
    private TexamPaperMapper texamPaperMapper;

    private TUserExample tUserExample = new TUserExample();
    @Autowired
    private TUserMapper tUserMapper;

    private TUserEventLogExample tUserEventLogExample = new TUserEventLogExample();
    @Autowired
    private TUserEventLogMapper tUserEventLogMapper;

    private TSubjectExample tSubjectExample = new TSubjectExample();
    @Autowired
    private TSubjectMapper tSubjectMapper;

    private TquestionExample tQuestionExample = new TquestionExample();
    @Autowired
    private TquestionMapper tQuestionMapper;

    private TexamPaperAnswerExample texamPaperAnswerExample = new TexamPaperAnswerExample();
    @Autowired
    private TexamPaperAnswerMapper texamPaperAnswerMapper;
    @Autowired
    private RedisTemplate redisTemplate ;
    @Value(value = "${all.number:}")
    private Integer all ;//从注册中心读取数据
    @PostMapping("/dashboard/index")
    public RestResponse<Index> index (HttpServletRequest request){
        Index index = new Index();
        texamPaperExample.clear();
        Cookie[] cookies = request.getCookies();
        String UserID = null;//cookie里的用户ID
      //  TUser user = (TUser)request.getSession().getAttribute("Admin");
        TUser user = new TUser();
        for(int i = 0 ; i < cookies.length ; i ++){
            if(cookies[i].getName().equals("UserID")){//判断登录状态
                user =  (TUser) redisTemplate.opsForValue().get(cookies[i].getValue());
                if( null == user){
                    return RestResponse.fail(401,"登录超时");
                }
                break;
            }
        }
        //TUser tUser = JSONObject.parseObject(cookies[0].getValue(), TUser.class);


        List<TexamPaper> list =  texamPaperMapper.selectByExample(texamPaperExample);
        if(list.size() != 0){//查询所有书卷
            index.setExamPaperCount(String.valueOf(list.size()));
            Integer count = 0;
            for (int i = 0 ; i < list.size() ; i++){//计算总题目数
                count = count + list.get(i).getQuestionCount();
            }
            index.setQuestionCount(String.valueOf(count));
            index.setDoExamPaperCount(String.valueOf(10));

            index.setDoQuestionCount(String.valueOf(90));
            List<String> list2 = new ArrayList<>();
            list2.add("90");
            index.setMothDayUserActionValue(list2);
            index.setMothDayDoExamQuestionValue(list2);
            index.setMothDayText(list2);

        }
        return RestResponse.ok(index);
    }

    @PostMapping("/user/current")//获取当前用户信息
    public RestResponse<TUser> current(HttpServletRequest request){
        TUser user = (TUser)request.getSession().getAttribute("Admin");
        if(user == null ){//判断登录状态
            return RestResponse.fail(401,"登录超时");
        }
        tUserExample.clear();
        tUserExample.createCriteria().andIdEqualTo(user.getId());
        List<TUser> tUsers = tUserMapper.selectByExample(tUserExample);
        if(tUsers.size() == 0){
            return RestResponse.fail(401,"登录超时");
        }
        return RestResponse.ok(tUsers.get(0));
    }

    @PostMapping("/user/update")//修改当前用户信息
    public RestResponse<TUser> updata(@RequestBody TUser tUser){
        tUserExample.clear();
        int i = tUserMapper.updateByPrimaryKeySelective(tUser);
        if(i==1){
            return RestResponse.ok();
        }else{
            return RestResponse.fail(400,"更新失败");
        }
    }

    @PostMapping("/user/page/list")//查询用户列表
    public RestResponse getUser(@RequestBody Pager pager){
        Integer total = 0;
        tUserExample.clear();
        tUserExample.createCriteria().andRoleEqualTo(pager.getRole());
        List<TUser> totalList = tUserMapper.selectByExample(tUserExample);//查所有
        if(pager.getPageIndex() == null){//切换每页查几条时会不传开始页数
            pager.setPageIndex(1);
        }
        Integer index = (pager.getPageIndex()-1) * pager.getPageSize();//当前页数-1 * 每页条数
        if(pager.getUserName() != null && pager.getUserName() != "") {
            tUserExample.clear();
            tUserExample.createCriteria().andRoleEqualTo(pager.getRole()).andUserNameLike("%" + pager.getUserName() + "%" );
        }
        tUserExample.setLimit(pager.getPageSize());//查多少条数据
        tUserExample.setOffset(index);//从哪开始
        List<TUser> tUsers = tUserMapper.selectByExample(tUserExample);//分页结果
        if(tUsers.size() != 0){
            total=totalList.size();
            UserList userList = new UserList();
            userList.setTotal(total);//记录当前条数
            userList.setPageNum(pager.getPageIndex());
            userList.setList(tUsers);
            return RestResponse.ok(userList);
        }
        return null;
    }
    @PostMapping("/user/changeStatus/{id}")
    public RestResponse updataUserState(@PathVariable(name = "id") Integer id){
        tUserExample.clear();
        tUserExample.createCriteria().andIdEqualTo(id);
        int i =0;
        List<TUser> tUsers = tUserMapper.selectByExample(tUserExample);
        if(tUsers.get(0).getStatus() == 1){
            tUsers.get(0).setStatus(2);
            i = tUserMapper.updateByPrimaryKey(tUsers.get(0));
        }else if(tUsers.get(0).getStatus() == 2){
            tUsers.get(0).setStatus(1);
            i =  tUserMapper.updateByPrimaryKey(tUsers.get(0));
        }

        if(i == 1){
            return  RestResponse.ok();
        }else
        {
            return RestResponse.fail(400,"更新失败");
        }
    }

    @PostMapping("/user/select/{id}")
    public RestResponse<TUser> select (@PathVariable("id") String id){
        tUserExample.clear();
        tUserExample.createCriteria().andIdEqualTo(Integer.valueOf(id));
        List<TUser> tUsers = tUserMapper.selectByExample(tUserExample);
        if (tUsers.size() != 0){
            return RestResponse.ok(tUsers.get(0));
        }
        return  null;
    }
    @PostMapping("/user/edit")
    public RestResponse<TUser> updataUser(@RequestBody TUser tUser){//如果接收ID为null说明是新增用户
        tUserExample.clear();
        tUserExample.createCriteria().andUserNameEqualTo(tUser.getUserName());
        List<TUser> tUsers = tUserMapper.selectByExample(tUserExample);
        if (tUsers.size() >  1){
            return RestResponse.fail(402,"用户名已存在");
        }
        int i = 0;
        if(tUser.getId() == null){
            i = tUserMapper.insertSelective(tUser);
            if(i == 1){
                return  RestResponse.ok();
            }
        }else{
             i = tUserMapper.updateByPrimaryKey(tUser);
            if(i == 1){
                return  RestResponse.ok();
            }
        }
        return RestResponse.fail(402,"操作失败");
    }
    @PostMapping("user/event/page/list")
    public RestResponse getLog(@RequestBody Pager pager){
        tUserEventLogExample.clear();
        if(pager.getUserId() != null){
            tUserEventLogExample.createCriteria().andUserIdEqualTo(pager.getUserId());
        }
        tUserEventLogExample.setOrderByClause("create_time DESC");
        List<TUserEventLog> total = tUserEventLogMapper.selectByExample(tUserEventLogExample);
        //Integer index = (pager.getPageIndex()-1) * pager.getPageSize();//当前页数-1 * 每页条数
      // RowBounds rowBounds = new RowBounds(index,pager.getPageSize());
        List<TUserEventLog> tUserEventLogs = tUserEventLogMapper.selectByExample(tUserEventLogExample);
        LogList logList = new LogList();
        if(tUserEventLogs.size() != 0){
            logList.setTotall(total.size());
            logList.setPageNum(pager.getPageIndex());
            logList.setList(tUserEventLogs);
            return RestResponse.ok(logList);
        }
        return null;
    }

    @PostMapping("/user/delete/{id}")
    public RestResponse DeleteUser(@PathVariable("id") Integer id){
        tUserExample.clear();
        tUserExample.createCriteria().andIdEqualTo(id);
        int i = tUserMapper.deleteByExample(tUserExample);

            return RestResponse.ok();

    }

    @PostMapping("/exam/paper/page")
    public RestResponse getPaper(@RequestBody Pager pager){
        PaperList paperList = new PaperList();
        texamPaperExample.clear();
        TexamPaperExample.Criteria criteria = texamPaperExample.createCriteria();
        if(pager.getLevel() != null && !"".equals(pager.getLevel())){
            criteria.andGradeLevelEqualTo(pager.getLevel());
        }
        if(pager.getSubjectId() != null && !"".equals(pager.getSubjectId())){
            criteria.andSubjectIdEqualTo(pager.getSubjectId());
        }
        List<TexamPaper> texamPapers1 = texamPaperMapper.selectByExample(texamPaperExample);
        Integer index = ( pager.getPageIndex() -1 ) * pager.getPageSize();
        RowBounds rowBounds = new RowBounds(index, pager.getPageSize());
        List<TexamPaper> texamPapers = texamPaperMapper.selectByExampleWithRowbounds(texamPaperExample, rowBounds);
        if(texamPapers.size() != 0){
           // Integer total = texamPapers.size();
            paperList.setTotal(texamPapers1.size());
            paperList.setList(texamPapers);
            paperList.setPageNum(pager.getPageIndex());
            return RestResponse.ok(paperList);
        }
        return RestResponse.fail(501,"无数据");
    }

    @PostMapping("/education/subject/list")
    public RestResponse getSubJect(){
        tSubjectExample.clear();
        List<TSubject> tSubjects = tSubjectMapper.selectByExample(tSubjectExample);
        if(tSubjects.size() != 0){
            return RestResponse.ok(tSubjects);
        }
        return null;
    }
    @PostMapping("/exam/paper/select/{id}")
    public RestResponse getPaper(@PathVariable("id") Integer id){
        texamPaperExample.clear();
        TexamPaperExample.Criteria criteria = texamPaperExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<TexamPaper> texamPapers = texamPaperMapper.selectByExample(texamPaperExample);
        if(texamPapers.size() != 0){
            return RestResponse.ok(texamPapers.get(0));
        }
        return RestResponse.fail(501,"无数据");
    }
    @PostMapping("/exam/paper/edit")
    public RestResponse updataPaper (@RequestBody TexamPaper texamPaper,HttpServletRequest request){
        Map<String, String[]> parameterMap = request.getParameterMap();
        if(texamPaper != null){
            tSubjectExample.clear();
            tSubjectExample.createCriteria().andIdEqualTo(texamPaper.getSubjectId());
            List<TSubject> tSubjects = tSubjectMapper.selectByExample(tSubjectExample);
            if(tSubjects.size() != 0){
                texamPaper.setGradeLevel(tSubjects.get(0).getLevel());
            }
            texamPaperExample.clear();
            texamPaperMapper.updateByPrimaryKey(texamPaper);
            return RestResponse.ok();
        }
        return RestResponse.fail(501,"更新失败");
    }

    @PostMapping("/exam/paper/delete/{id}")
    public RestResponse deletePaper(@PathVariable("id")Integer id){
        texamPaperExample.clear();
        texamPaperExample.createCriteria().andIdEqualTo(id);
        int i = texamPaperMapper.deleteByExample(texamPaperExample);
        if(i == 1){
            //ApplicationContext context = new AnnotationConfigApplicationContext();
            return RestResponse.ok();
        }
        return RestResponse.fail(501,"失败");
    }

    //题目
    @Autowired
    TextContentMapper textContentMapper ;
    TextContentExample textContentExample = new TextContentExample();
    @PostMapping("/question/page")
    public RestResponse getQunstion(@RequestBody Pager pager){
        tQuestionExample.clear();
        Integer index = ( pager.getPageIndex() -1 ) * pager.getPageSize();
        RowBounds rowBounds = new RowBounds(index, pager.getPageSize());

        List<Tquestion> tQuestions = tQuestionMapper.selectByExampleWithRowbounds(tQuestionExample, rowBounds);

        List<TextContent> textContents = textContentMapper.selectByExampleWithBLOBs(textContentExample);//查处题干
        if(tQuestions.size() != 0){
            for(int i = 0 ; i< tQuestions.size() ; i++){
                for(int j = 0 ; j < textContents.size() ; j++){
                   if(tQuestions.get(i).getInfoTextContentId().equals(String.valueOf(textContents.get(j).getId()))){
                       tQuestions.get(i).setShortTitle(textContents.get(j).getContent());
                   }
                }
            }
            Qulist qulist = new Qulist();
            qulist.setTotal(tQuestions.size());
            qulist.setList(tQuestions);
            qulist.setPageNum(pager.getPageIndex());
            return RestResponse.ok(qulist);
        }
        return null;
    }

    @PostMapping("/question/select/{id}")
    public RestResponse getQunstion(@PathVariable("id") Integer id){
        tQuestionExample.clear();
        Tquestion tquestion = tQuestionMapper.selectByPrimaryKey(id);
        QuestionReturn questionReturn = new QuestionReturn();
        questionReturn.setId(tquestion.getId());
        questionReturn.setCorrect(tquestion.getCorrect());
        questionReturn.setSubjectId(tquestion.getSubjectId());
        questionReturn.setQuestionType(tquestion.getQuestionType());
        List<QuestionReturn.re> list = new ArrayList<>();
        questionReturn.setItems(list);

        return RestResponse.ok(questionReturn);
    }

    @PostMapping("/examPaperAnswer/page")
    public RestResponse getAnswer(@RequestBody Pager pager){
        texamPaperAnswerExample.clear();
        TexamPaperAnswerExample.Criteria criteria = texamPaperAnswerExample.createCriteria();
        if (pager.getSubjectId() != null){
            criteria.andSubjectIdEqualTo(pager.getSubjectId());
        }
        List<TexamPaperAnswer> texamPaperAnswers1 = texamPaperAnswerMapper.selectByExample(texamPaperAnswerExample);
        RowBounds rowBounds = new RowBounds((pager.getPageIndex() - 1) * pager.getPageSize() , pager.getPageSize());
        List<TexamPaperAnswer> texamPaperAnswers = texamPaperAnswerMapper.selectByExampleWithRowbounds(texamPaperAnswerExample, rowBounds);
        AnswerList answerList = new AnswerList();
        answerList.setTotall(texamPaperAnswers1.size());
        answerList.setList(texamPaperAnswers);
        return RestResponse.ok(answerList);
    }

   
    @PostMapping("/task/page")//任务查询
    public RestResponse getTask( @RequestBody Pager pager){
        taskExamExample.clear();
        TaskExamExample.Criteria criteria = taskExamExample.createCriteria();
        if(pager.getGradeLevel() != null){
            criteria.andGradeLevelEqualTo(pager.getGradeLevel());
        }
        List<TaskExam> taskExams1 = taskExamMapper.selectByExample(taskExamExample);//查总条数

        Integer index = (pager.getPageIndex() - 1) * pager.getPageSize();
        RowBounds bounds = new RowBounds(index,pager.getPageSize());
        List<TaskExam> taskExams = taskExamMapper.selectByExampleWithRowbounds(taskExamExample, bounds);//查分页的条数
        if (taskExams.size() != 0){
            TaskList taskList = new TaskList();
            taskList.setTotal(taskExams1.size());
            taskList.setList(taskExams);
            taskList.setPageNum(pager.getPageIndex());
            return RestResponse.ok(taskList);
        }
        return null;
    }

    @PostMapping("task/select/{id}")//查询任务编辑
    public  RestResponse selectdataTask(@PathVariable Integer id){
        TaskExam taskExam = taskExamMapper.selectByPrimaryKey(id);
        texamPaperExample.clear();
        //texamPaperExample.createCriteria().andTaskExamIdEqualTo(taskExam.getId());
        String[] split = String.valueOf(taskExam.getFrameTextContentId()).split(",");
        List ids = new ArrayList();
        if(!split[0].equals("null")){
            for(int i = 0 ; i < split.length ; i++){
                ids.add(Integer.valueOf(split[i]));
            }
            texamPaperExample.createCriteria().andIdIn(ids);
            List<TexamPaper> texamPapers = texamPaperMapper.selectByExample(texamPaperExample);
            taskExam.setPaperItems(texamPapers);
        }
        return RestResponse.ok(taskExam);
    }
    @PostMapping("/exam/paper/taskExamPage")
    public RestResponse TaskGetPager(@RequestBody Pager pager){//任务查询试卷
        PaperList paperList = new PaperList();
        texamPaperExample.clear();
        TexamPaperExample.Criteria criteria = texamPaperExample.createCriteria();
        if(pager.getLevel() != null && !"".equals(pager.getLevel())){
            criteria.andGradeLevelEqualTo(pager.getLevel());
        }
        if(pager.getSubjectId() != null && !"".equals(pager.getSubjectId())){
            criteria.andSubjectIdEqualTo(pager.getSubjectId());
        }
        //criteria.andTaskExamIdEqualTo(0);
        List<TexamPaper> texamPapers1 = texamPaperMapper.selectByExample(texamPaperExample);
        Integer index = ( pager.getPageIndex() -1 ) * pager.getPageSize();
        RowBounds rowBounds = new RowBounds(index, pager.getPageSize());
        List<TexamPaper> texamPapers = texamPaperMapper.selectByExampleWithRowbounds(texamPaperExample, rowBounds);
        if(texamPapers.size() != 0){
            // Integer total = texamPapers.size();
            paperList.setTotal(texamPapers1.size());
            paperList.setList(texamPapers);
            paperList.setPageNum(pager.getPageIndex());
            return RestResponse.ok(paperList);
        }
        return RestResponse.fail(501,"无数据");
    }
    //任务修改
    @PostMapping("task/edit")
    public RestResponse UpdataTask(@RequestBody TaskExam taskExam, HttpServletRequest request ){
        if(taskExam.getPaperItems().size() == 0 && taskExam.getPaperItems() != null){
            return RestResponse.fail(402,"请添加试卷");
        }
        if(taskExam.getPaperItems().size() != 0){
            String ids = "";
            for(int x = 0 ; x < taskExam.getPaperItems().size() ; x ++){
                ids =  ids + taskExam.getPaperItems().get(x).getId() + ",";
            }
            taskExam.setFrameTextContentId(ids);
        }
        TUser user =(TUser)request.getSession().getAttribute("Admin");
        if(user == null){//判断登录状态
            return RestResponse.fail(401,"未登录");
        }
        TUserEventLog tUserEventLog = new TUserEventLog();//日志对象
        tUserEventLog.setUserName(user.getUserName());
        tUserEventLog.setRealName(user.getRealName());
        tUserEventLog.setUserId(user.getId());
        texamPaperExample.clear();
        if(taskExam.getId() == null){//id为null说明是新增任务
            taskExam.setCreateUser(user.getId());
            taskExam.setCreateUserName(user.getUserName());
            taskExam.setCreateTime(new Date());
            int id = taskExamMapper.insertSelective(taskExam);

            if(id == 1){
                tUserEventLog.setContent("新增任务");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                tUserEventLog.setCreateTime(simpleDateFormat.format(new Date()));
                tUserEventLogMapper.insertSelective(tUserEventLog);
                return RestResponse.ok();
            }
        }
        texamPaperExample.clear();
        int i = taskExamMapper.updateByPrimaryKeySelective(taskExam);
        if (taskExam.getPaperItems().size() != 0){
            for(int j = 0 ; j < taskExam.getPaperItems().size() ; j ++){
                Integer id = taskExam.getPaperItems().get(j).getTaskExamId();
               // if(!taskExam.getId().equals(id)){//判断当前试卷集合内有没有于任务id相同的
                    taskExam.getPaperItems().get(j).setTaskExamId(taskExam.getId());
                    int i1 = texamPaperMapper.updateByPrimaryKey(taskExam.getPaperItems().get(j));
                    if(i1 == 1){
                        continue;
                    }else{
                        return RestResponse.fail(501,"试卷更新失败");
                    }
            }
        }
        if(i == 1){
            tUserEventLog.setContent("修改任务");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            tUserEventLog.setCreateTime(simpleDateFormat.format(new Date()));
            tUserEventLogMapper.insertSelective(tUserEventLog);
            return RestResponse.ok();
        }
        return RestResponse.fail(501,"任务更新失败");
    }


    @PostMapping("task/delete/{id}")
    public  RestResponse deleteTask(@PathVariable("id") Integer id , HttpServletRequest request){
        TUser user =(TUser)request.getSession().getAttribute("Admin");
        if(user == null){//判断登录状态
            return RestResponse.fail(401,"未登录");
        }
        int i = taskExamMapper.deleteByPrimaryKey(id);
        if (i == 1){
            TUserEventLog tUserEventLog = new TUserEventLog();//日志对象
            tUserEventLog.setUserName(user.getUserName());
            tUserEventLog.setRealName(user.getRealName());
            tUserEventLog.setUserId(user.getId());
            tUserEventLog.setContent("删除任务");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            tUserEventLog.setCreateTime(simpleDateFormat.format(new Date()));
            tUserEventLogMapper.insertSelective(tUserEventLog);
            return RestResponse.ok();
        }
        return RestResponse.fail(501,"删除失败");
    }
}
