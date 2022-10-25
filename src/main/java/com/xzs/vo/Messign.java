package com.xzs.vo;

import com.xzs.pojo.Tmessage;

import java.util.List;

public class Messign {
    private Integer totall;

    public Integer getTotall() {
        return totall;
    }

    public void setTotall(Integer totall) {
        this.totall = totall;
    }

    public List<Tmessage> getList() {
        return list;
    }

    public void setList(List<Tmessage> list) {
        this.list = list;
    }

    private List<Tmessage> list;
    private  Integer pageNum;
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
