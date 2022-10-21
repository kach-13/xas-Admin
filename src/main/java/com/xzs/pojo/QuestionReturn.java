package com.xzs.pojo;

import java.util.List;

public class QuestionReturn {
   private Integer id;  //题目id
   private Integer  questionType;
   private Integer subjectId;
   private String title;
   private List<re> items;
   private Integer gradeLevel;
   private String analyze;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<re> getItems() {
        return items;
    }

    public void setItems(List<re> items) {
        this.items = items;
    }

    public Integer getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(Integer gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public String getAnalyze() {
        return analyze;
    }

    public void setAnalyze(String analyze) {
        this.analyze = analyze;
    }

    public String getCorrectArray() {
        return correctArray;
    }

    public void setCorrectArray(String correctArray) {
        this.correctArray = correctArray;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getDifficult() {
        return difficult;
    }

    public void setDifficult(Integer difficult) {
        this.difficult = difficult;
    }

    public Object getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(Object itemOrder) {
        this.itemOrder = itemOrder;
    }

    private String correctArray;
   private String correct;
   private String score;
   private Integer difficult;
   private Object itemOrder;

   public class re {
        Integer id ;

       public Integer getId() {
           return id;
       }

       public void setId(Integer id) {
           this.id = id;
       }

       public String getPrefix() {
           return prefix;
       }

       public void setPrefix(String prefix) {
           this.prefix = prefix;
       }

       public String getContent() {
           return content;
       }

       public void setContent(String content) {
           this.content = content;
       }

       String prefix;
        String content;
   }
}

