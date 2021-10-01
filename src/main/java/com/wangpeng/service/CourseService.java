package com.wangpeng.service;

import com.wangpeng.pojo.Course;

import java.util.List;
import java.util.Map;

public interface CourseService {

    /**
     * 找所有的课程
     * @return
     */
    List<Course> findAllCourses();

    /**
     * 分页找所有课程
     * @param page
     * @param size
     * @return
     */
    List<Course> findCoursesByPage(int page, int size);

    /**
     * 获取课程总数
     * @return
     */
    int getCoursesCount();

    /**
     * 删除指定课程
     * @param courses
     * @return 删除成功的数量
     */
    int deleteCourses(List<Course> courses);

    /**
     * 添加一个课程
     * @param course
     */
    int addCourse(Course course);

    /**
     * 修改一个课程
     * @param course
     * @return
     */
    int updateCourse(Course course);

    /**
     * 搜索课程
     * @param page
     * @param size
     * @param searchParam
     */
    List<Course> searchCourses(Integer page, Integer size, Map<String, Object> searchParam);

    /**
     * 获取搜索的数量
     * @param searchParam
     * @return
     */
    int getSearchCount(Map<String, Object> searchParam);

    List<Course> findAllCoursesByTeacher(int tid);
}
