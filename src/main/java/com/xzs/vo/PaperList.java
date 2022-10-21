package com.xzs.vo;

import com.xzs.pojo.TexamPaper;
import lombok.Data;

import java.util.List;

//返回试卷
@Data
public class PaperList {
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

    public List<TexamPaper> getList() {
        return list;
    }

    public void setList(List<TexamPaper> list) {
        this.list = list;
    }

    private List<TexamPaper> list;
}
