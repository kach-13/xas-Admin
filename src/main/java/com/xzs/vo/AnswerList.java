package com.xzs.vo;

import com.xzs.pojo.TexamPaperAnswer;

import java.util.List;

public class AnswerList {
    private Integer totall;

    public Integer getTotall() {
        return totall;
    }

    public void setTotall(Integer totall) {
        this.totall = totall;
    }

    private List<TexamPaperAnswer> list;

    public List<TexamPaperAnswer> getList() {
        return list;
    }

    public void setList(List<TexamPaperAnswer> list) {
        this.list = list;
    }
}
