package com.swy.model;

import com.swy.utils.ConstantUtil;

/**
 * 状态码和信息
 */
public class CommonModel {

    // code = 0 :请求成功，有数据返回  code = 1:请求成功，但无数据返回
    private int code;
    // msg
    private String msg;

    private Object data;

    public void setSuccess(){
        setCode(ConstantUtil.CODE_SUCCESS);
        setMsg(ConstantUtil.MSG_SUCCESS);
    }

    public void setFail(){
        setCode(ConstantUtil.CODE_FAIL);
        setMsg(ConstantUtil.MSG_FAIL);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
