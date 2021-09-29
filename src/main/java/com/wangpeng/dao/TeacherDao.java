package com.wangpeng.dao;

import com.wangpeng.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TeacherDao {
    /**
     * 添加老师
     * @param teacher
     * @return
     */
    int insertTeacher(Teacher teacher);

    /**
     * 删除老师
     * @param list
     * @return
     */
    int deleteTeachers(List<Teacher> list);

    /**
     * 修改老师
     * @param teacher
     * @return
     */
    int updateTeacher(Teacher teacher);

    /**
     * 根据id查教师
     * @param tid
     * @return
     */
    Teacher selectTeacher(int tid);

    /**
     * 分页查询老师
     * @param begin 起始索引，从0开始
     * @param size  每页大小
     * @return
     */
    List<Teacher> selectTeachersByLimit(@Param("begin") int begin, @Param("size")int size);

    /**
     * 获取老师数量
     * @return
     */
    int getTeachersCount();

    /**
     * 分页搜索老师
     * @param map 4个参数，begin,size,tname,tnum
     * @return
     */
    List<Teacher> searchTeachersByLimit(Map<String,Object> map);

    /**
     * 获取搜索的数量
     * @param map 2个参数，tname,tnum
     * @return
     */
    int getSearchCount(Map<String,Object> map);

    /**
     * 检查登录
     * @param map 2个参数，username和password
     * @return
     */
    Teacher checkByUsernameAndPassword(Map<String,Object> map);

    List<Teacher> selectTeachers();
}
