package com.example.baseframe.myspringboot.domain;

/**
 * @author 01378803
 * @date 2018/11/2 14:43
 * Description  :
 */
public class ResultData {
    /**
     * 返回提示信息
     */
    private String msg;
    /**
     * 返回code代码
     */
    private Integer code;
    /**
     * 返回内容
     */
    private Object data;
    /**
     * 返回状态
     */
    private String status = "ok";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
