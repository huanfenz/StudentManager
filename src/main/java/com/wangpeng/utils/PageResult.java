package com.wangpeng.utils;

public class PageResult extends BaseResult {

    /**
     * 数量
     */
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
