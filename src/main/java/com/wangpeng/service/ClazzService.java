package com.wangpeng.service;

import com.wangpeng.pojo.Clazz;
import com.wangpeng.pojo.Clazz;
import com.wangpeng.pojo.Major;

import java.util.List;
import java.util.Map;

public interface ClazzService {

    List<Clazz> queryClazzs(int page, int size);

    int getAmount();

    /**
     * 删除指定班级
     * @param clazzs
     * @return 删除成功的数量
     */
    int deleteClazzs(List<Clazz> clazzs);

    /**
     * 添加一个班级
     * @param clazz
     */
    int addClazz(Clazz clazz);

    /**
     * 修改一个班级
     * @param clazz
     * @return
     */
    int updateClazz(Clazz clazz);

    /**
     * 搜索班级
     * @param page
     * @param size
     * @param searchParam
     */
    List<Clazz> searchClazzs(Integer page, Integer size, Map<String, Object> searchParam);

    /**
     * 获取搜索的数量
     * @param searchParam
     * @return
     */
    int getSearchCount(Map<String, Object> searchParam);

    List<Clazz> queryAllClazzs();
}
