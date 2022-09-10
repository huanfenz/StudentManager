package com.wangpeng.dao;

import com.wangpeng.pojo.Clazz;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ClazzDao {
    /**
     * 添加班级
     * @param clazz
     * @return
     */
    int insertClazz(Clazz clazz);

    /**
     * 删除班级
     * @param clazzes
     * @return
     */
    int deleteClazzs(List<Clazz> clazzes);

    /**
     * 修改班级
     * @param clazz
     * @return
     */
    int updateClazz(Clazz clazz);

    /**
     * 查询所有班级
     * @return
     */
    List<Clazz> selectClazzs();

    /**
     * 通过教师查询所有班级
     */
    List<Clazz> getCLazzsByTeacher(int tid);

    /**
     * 查询班级
     * @param id
     * @return
     */
    Clazz selectClazz(int id);

    /**
     * 分页查询班级
     * @param begin 起始索引，从0开始
     * @param size  每页大小
     * @return
     */
    List<Clazz> selectClazzsByLimit(@Param("begin") int begin, @Param("size")int size);

    /**
     * 获取班级数量
     * @return
     */
    int getClazzsCount();

    /**
     * 分页搜索班级
     * @param map 4个参数，begin,size,mname,mdept
     * @return
     */
    List<Clazz> searchClazzsByLimit(Map<String,Object> map);

    /**
     * 获取搜索的数量
     * @param map 2个参数，mname,mdept
     * @return
     */
    int getSearchCount(Map<String,Object> map);

}
