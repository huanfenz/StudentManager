package com.wangpeng.utils;

public class PageResult {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息
     */
    private String msg;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 数据
     */
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 成功，count和data
     * @param count
     * @param data
     * @return
     */
    public static PageResult success(Integer count, Object data) {
        PageResult result = new PageResult();
        result.setCode(0);
        result.setMsg("成功");
        result.setCount(count);
        result.setData(data);
        return result;
    }
}
