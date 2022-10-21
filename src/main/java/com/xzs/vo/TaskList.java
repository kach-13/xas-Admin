package com.xzs.vo;

import com.xzs.pojo.TaskExam;
import com.xzs.pojo.TaskExamCustomerAnswer;

import java.util.List;

public class TaskList {
    private Integer total;

    private  Integer pageNum;
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    private List<TaskExam> list ;

    public List<TaskExam> getList() {
        return list;
    }

    public void setList(List<TaskExam> list) {
        this.list = list;
    }
}
