package com.xzs.vo;

import com.xzs.pojo.TUserEventLog;

import java.util.List;

public class LogList {
    private Integer totall;

    public Integer getTotall() {
        return totall;
    }

    public void setTotall(Integer totall) {
        this.totall = totall;
    }

    public List<TUserEventLog> getList() {
        return list;
    }

    public void setList(List<TUserEventLog> list) {
        this.list = list;
    }

    private List<TUserEventLog> list;
    private  Integer pageNum;
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
