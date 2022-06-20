package com.wangpeng.utils;

import java.util.HashMap;

/**
 * @Author: 王鹏
 * @Date: 2022/06/19/14:21
 * @Description:
 */
public class UploadResult extends BaseResult {

    /**
     * 成功
     * @param src 图片地址
     * @return
     */
    public static UploadResult success(String src, String fileName) {
        UploadResult result = new UploadResult();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(new HashMap<String, String>() {
            {
                put("src", src);
                put("fileName", fileName);
            }
        });
        return result;
    }

}
