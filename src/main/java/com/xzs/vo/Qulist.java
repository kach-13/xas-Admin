package com.xzs.vo;

import com.xzs.pojo.Tquestion;

import java.util.List;

public class Qulist {
    private Integer total;

    private List<Tquestion> list;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Tquestion> getList() {
        return list;
    }

    public void setList(List<Tquestion> list) {
        this.list = list;
    }

    private  Integer pageNum;
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
