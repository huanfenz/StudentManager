package com.wangpeng.service;

import com.wangpeng.pojo.CourseTable;

import java.util.List;
import java.util.Map;

public interface CourseTableService {

    /**
     * 找所有的课表
     * @return
     */
    List<CourseTable> findAllCourseTables();

    /**
     * 分页找所有课表
     * @param page
     * @param size
     * @return
     */
    List<CourseTable> findCourseTablesByPage(int page, int size);

    /**
     * 获取课表总数
     * @return
     */
    int getCourseTablesCount();

    /**
     * 删除指定课表
     * @param courseTables
     * @return 删除成功的数量
     */
    int deleteCourseTables(List<CourseTable> courseTables);

    /**
     * 添加一个课表
     * @param courseTable
     */
    int addCourseTable(CourseTable courseTable);

    /**
     * 修改一个课表
     * @param courseTable
     * @return
     */
    int updateCourseTable(CourseTable courseTable);

    /**
     * 分页找所有课表（根据oid）
     * @param page
     * @param size
     * @return
     */
    List<CourseTable> findCourseTablesByPageByOid(int page, int size, int oid);
}
