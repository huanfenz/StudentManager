package com.wangpeng.service;

import com.wangpeng.pojo.Manager;

import java.util.List;
import java.util.Map;

public interface ManagerService {

    /**
     * 找所有的班级
     * @return
     */
    List<Manager> findAllManagers();

    /**
     * 分页找所有班级
     * @param page
     * @param size
     * @return
     */
    List<Manager> findManagersByPage(int page, int size);

    /**
     * 获取班级总数
     * @return
     */
    int getManagersCount();

    /**
     * 删除指定班级
     * @param users
     * @return 删除成功的数量
     */
    int deleteManagers(List<Manager> users);

    /**
     * 添加一个班级
     * @param user
     */
    int addManager(Manager user);

    /**
     * 修改一个班级
     * @param user
     * @return
     */
    int updateManager(Manager user);

    /**
     * 搜索班级
     * @param page
     * @param size
     * @param searchParam
     */
    List<Manager> searchManagers(Integer page, Integer size, Map<String, Object> searchParam);

    /**
     * 获取搜索的数量
     * @param searchParam
     * @return
     */
    int getSearchCount(Map<String, Object> searchParam);

}
