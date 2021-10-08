package com.wangpeng.dao;

import com.wangpeng.pojo.ArrangeCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArrangeCourseDao {
    /**
     * 添加课表
     * @param arrangeCourse
     * @return
     */
    int insertArrangeCourse(ArrangeCourse arrangeCourse);

    /**
     * 删除课表
     * @param arrangeCourses
     * @return
     */
    int deleteArrangeCourses(List<ArrangeCourse> arrangeCourses);

    /**
     * 修改课表
     * @param arrangeCourse
     * @return
     */
    int updateArrangeCourse(ArrangeCourse arrangeCourse);

    /**
     * 查询所有课表
     * @return
     */
    List<ArrangeCourse> selectArrangeCourses();

    /**
     * 根据id查询课表
     * @param id
     * @return
     */
    ArrangeCourse selectArrangeCourse(Integer id);

    /**
     * 分页查询课表
     * @param begin 起始索引，从0开始
     * @param size  每页大小
     * @return
     */
    List<ArrangeCourse> selectArrangeCoursesByLimit(@Param("begin") int begin, @Param("size")int size);

    /**
     * 获取课表数量
     * @return
     */
    int getArrangeCoursesCount();

    /**
     * 根据oid分页查询课表
     * @return
     */
    List<ArrangeCourse> selectArrangeCoursesByLimitByOid(@Param("begin") int begin, @Param("size") int size, @Param("oid") int oid);

    List<ArrangeCourse> selectArrangeCoursesByCid(@Param("cid") int cid);
}
