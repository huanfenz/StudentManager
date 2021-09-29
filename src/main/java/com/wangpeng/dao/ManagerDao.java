package com.wangpeng.dao;

import com.wangpeng.pojo.Manager;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ManagerDao {
    /**
     * 添加用户
     * @param manager
     * @return
     */
    int insertManager(Manager manager);

    /**
     * 删除用户
     * @param managers
     * @return
     */
    int deleteManagers(List<Manager> managers);

    /**
     * 修改用户
     * @param manager
     * @return
     */
    int updateManager(Manager manager);

    /**
     * 查询所有用户
     * @return
     */
    List<Manager> selectManagers();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    Manager selectManager(Integer id);

    /**
     * 分页查询用户
     * @param begin 起始索引，从0开始
     * @param size  每页大小
     * @return
     */
    List<Manager> selectManagersByLimit(@Param("begin") int begin, @Param("size")int size);

    /**
     * 获取用户数量
     * @return
     */
    int getManagersCount();

    /**
     * 分页搜索用户
     * @param map 4个参数，begin,size,mname,mdept
     * @return
     */
    List<Manager> searchManagersByLimit(Map<String,Object> map);

    /**
     * 获取搜索的数量
     * @param map 2个参数，mname,mdept
     * @return
     */
    int getSearchCount(Map<String,Object> map);

    /**
     * 检查登录
     * @param map 2个参数，username和password
     * @return
     */
    Manager checkByUsernameAndPassword(Map<String,Object> map);

}
