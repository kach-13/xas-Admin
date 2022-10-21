package com.xzs.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)

@AllArgsConstructor
public class SysResult {
    private Integer status ;
    private String msg ;
    private Object data ;
    public SysResult(){}

    public SysResult(int code, String msg, Object data) {
        this.status = code;
        this.msg = msg ;
        this.data = data;
    }
    public static SysResult fail(){
        return new SysResult(201,"失败",null);
    }
    public static SysResult fail(Object data){
        return new SysResult(201,"失败",data);
    }
    public static SysResult success(){
        return new SysResult(200,"成功",null);
    }
    public static SysResult success(Object data){
        return new SysResult(200,"成功",data);
    }
    public static SysResult success(String msg , Object data){
        return new SysResult(200,msg,data);
    }
}
