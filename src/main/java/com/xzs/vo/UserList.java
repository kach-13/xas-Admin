package com.xzs.vo;

import com.xzs.pojo.TUser;

import java.util.ArrayList;
import java.util.List;

public class UserList {//返回分页后的用户列表
    private Integer total;

    private List<TUser> list;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<TUser> getList() {
        return list;
    }

    public void setList(List<TUser> list) {
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
