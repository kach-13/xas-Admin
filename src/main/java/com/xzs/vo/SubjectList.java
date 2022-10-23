package com.xzs.vo;

import com.xzs.pojo.TSubject;
import com.xzs.pojo.TexamPaperAnswer;

import java.util.List;

public class SubjectList {
    private Integer totall;

    public Integer getTotall() {
        return totall;
    }

    public void setTotall(Integer totall) {
        this.totall = totall;
    }

    private List<TSubject> list;

    public List<TSubject> getList() {
        return list;
    }

    public void setList(List<TSubject> list) {
        this.list = list;
    }
}
