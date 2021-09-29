package com.wangpeng.dao;

import com.wangpeng.pojo.CourseTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CourseTableDao {
    /**
     * 添加课表
     * @param courseTable
     * @return
     */
    int insertCourseTable(CourseTable courseTable);

    /**
     * 删除课表
     * @param courseTables
     * @return
     */
    int deleteCourseTables(List<CourseTable> courseTables);

    /**
     * 修改课表
     * @param courseTable
     * @return
     */
    int updateCourseTable(CourseTable courseTable);

    /**
     * 查询所有课表
     * @return
     */
    List<CourseTable> selectCourseTables();

    /**
     * 根据id查询课表
     * @param id
     * @return
     */
    CourseTable selectCourseTable(Integer id);

    /**
     * 分页查询课表
     * @param begin 起始索引，从0开始
     * @param size  每页大小
     * @return
     */
    List<CourseTable> selectCourseTablesByLimit(@Param("begin") int begin, @Param("size")int size);

    /**
     * 获取课表数量
     * @return
     */
    int getCourseTablesCount();

    /**
     * 根据oid分页查询课表
     * @return
     */
    List<CourseTable> selectCourseTablesByLimitByOid(@Param("begin") int begin, @Param("size") int size, @Param("oid") int oid);

    List<CourseTable> selectCourseTablesByCid(@Param("cid") int cid);
}
