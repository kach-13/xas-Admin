package com.xzs.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Index {//主页
    private String examPaperCount ;//试卷总数
    private String questionCount;//题目总数
    private String doExamPaperCount;//总答卷数
    private String doQuestionCount;//总题目数
    private List<String> mothDayUserActionValue;//活跃度（曲线图）

    public String getExamPaperCount() {
        return examPaperCount;
    }

    public void setExamPaperCount(String examPaperCount) {
        this.examPaperCount = examPaperCount;
    }

    public String getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(String questionCount) {
        this.questionCount = questionCount;
    }

    public String getDoExamPaperCount() {
        return doExamPaperCount;
    }

    public void setDoExamPaperCount(String doExamPaperCount) {
        this.doExamPaperCount = doExamPaperCount;
    }

    public String getDoQuestionCount() {
        return doQuestionCount;
    }

    public void setDoQuestionCount(String doQuestionCount) {
        this.doQuestionCount = doQuestionCount;
    }

    public List<String> getMothDayUserActionValue() {
        return mothDayUserActionValue;
    }

    public void setMothDayUserActionValue(List<String> mothDayUserActionValue) {
        this.mothDayUserActionValue = mothDayUserActionValue;
    }

    public List<String> getMothDayDoExamQuestionValue() {
        return mothDayDoExamQuestionValue;
    }

    public void setMothDayDoExamQuestionValue(List<String> mothDayDoExamQuestionValue) {
        this.mothDayDoExamQuestionValue = mothDayDoExamQuestionValue;
    }

    public List<String> getMothDayText() {
        return mothDayText;
    }

    public void setMothDayText(List<String> mothDayText) {
        this.mothDayText = mothDayText;
    }

    private List<String> mothDayDoExamQuestionValue;//月做数（曲线图）
    private List<String> mothDayText;//本月天数（曲线图）
}
