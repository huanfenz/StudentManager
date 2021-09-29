package com.wangpeng.service;

import com.wangpeng.pojo.Major;

import java.util.List;
import java.util.Map;

public interface MajorService {

    /**
     * 找所有的专业
     * @return
     */
    List<Major> findAllMajors();

    /**
     * 分页找所有专业
     * @param page
     * @param size
     * @return
     */
    List<Major> findMajorsByPage(int page, int size);

    /**
     * 获取专业总数
     * @return
     */
    int getMajorsCount();

    /**
     * 删除指定专业
     * @param majors
     * @return 删除成功的数量
     */
    int deleteMajors(List<Major> majors);

    /**
     * 添加一个专业
     * @param major
     */
    int addMajor(Major major);

    /**
     * 修改一个专业
     * @param major
     * @return
     */
    int updateMajor(Major major);

    /**
     * 搜索专业
     * @param page
     * @param size
     * @param searchParam
     */
    List<Major> searchMajors(Integer page, Integer size, Map<String, Object> searchParam);

    /**
     * 获取搜索的数量
     * @param searchParam
     * @return
     */
    int getSearchCount(Map<String, Object> searchParam);

}
