package com.fubukianime.controller.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class R implements Serializable {

    private Integer code;


    private Boolean flag; //判定是否成功

    private Object data;  //数据

    private String msg; //错误信息

    public R(){}

    public R(Boolean flag){
        this.flag = flag;
    }

    public R(Boolean flag,Object data){
        this.flag = flag;
        this.data = data;
    }

    public R(Boolean flag,String msg){
        this.flag = flag;
        this.msg = msg;
    }

    public R(String msg){
        this.flag = false;
        this.msg = msg;
    }

    public static R success(Object object){
        R r = new R();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static R error(String msg){
        R r = new R();
        r.msg = msg;
        r.code = 0;
        return r;
    }
}
