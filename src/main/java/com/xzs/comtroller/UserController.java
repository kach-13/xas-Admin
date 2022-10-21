package com.xzs.comtroller;

import com.xzs.mapper.TUserEventLogMapper;
import com.xzs.mapper.TUserMapper;
import com.xzs.pojo.TUser;
import com.xzs.pojo.TUserEventLog;
import com.xzs.pojo.TUserEventLogExample;
import com.xzs.pojo.TUserExample;
import com.xzs.vo.RestResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.KdcComm;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class UserController {
private TUserExample tUserExample = new TUserExample();
@Autowired
private TUserMapper tUserMapper;
@Autowired
private RedisTemplate<String,Object> redisTemplate;

private TUserEventLogExample tUserEventLogExample = new TUserEventLogExample();
@Autowired
private TUserEventLogMapper tUserEventLogMapper;
    @PostMapping(value="login")
    public RestResponse<TUser> login (@RequestBody TUser user , HttpSession session, HttpServletResponse response) throws UnsupportedEncodingException {

       String username =user.getUserName();
       String password = user.getPassword();
        tUserExample.clear();
        tUserExample.createCriteria().andUserNameEqualTo(username).andPasswordEqualTo(password);
        List<TUser> tUsers = tUserMapper.selectByExample(tUserExample);
        if(tUsers.size() != 0){//12小时
            if(tUsers.get(0).getStatus() == 2){
                return  RestResponse.fail(400,"当前账号被禁用");
            }

            Cookie cookie = new Cookie("UserID", tUsers.get(0).getId().toString());
            cookie.setMaxAge(3600);
            cookie.setPath("/");
            response.addCookie(cookie);
            redisTemplate.opsForValue().set(tUsers.get(0).getId().toString(),tUsers.get(0));//写到Redis缓存（未设置有效时间）

            //session.setMaxInactiveInterval(720*60);//设置Session有效时间  //多服务器之间用Cookie
           // session.setAttribute(tUsers.get(0).getId().toString(),tUsers.get(0));

            //登录成功将日志写入日志表
            TUserEventLog tUserEventLog = new TUserEventLog();
            tUserEventLog.setUserId(tUsers.get(0).getId());
            tUserEventLog.setUserName(tUsers.get(0).getUserName());
            tUserEventLog.setContent("登录系统");
            tUserEventLog.setRealName(tUsers.get(0).getRealName());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            tUserEventLog.setCreateTime(simpleDateFormat.format(new Date()));
            tUserEventLogMapper.insert(tUserEventLog);

            return RestResponse.ok(tUsers.get(0));
        }
        return RestResponse.fail(402,"用户名或密码错误");
    }
    @PostMapping(value = "logout")//退出登录
    public RestResponse<TUser> logOut (HttpSession session, HttpServletResponse response, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(int i = 0 ; i < cookies.length ; i ++){
            if(cookies[i].getName().equals("UserID")){//判断登录状态
                redisTemplate.delete(cookies[i].getValue());
                cookies[i].setValue(null);
                cookies[i].setPath("/");
                response.addCookie( cookies[i]);
                break;
            }
        }

        //sesion清除
//        TUser tUser = (TUser) session.getAttribute("Admin");
//            if (tUser != null){
//                redisTemplate.delete(tUser.getUserName());
//            }
        return RestResponse.ok();
    }


}
