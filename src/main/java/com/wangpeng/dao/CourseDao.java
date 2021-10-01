package com.wangpeng.dao;

import com.wangpeng.pojo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CourseDao {
    /**
     * 添加课程
     * @param course
     * @return
     */
    int insertCourse(Course course);

    /**
     * 删除课程
     * @param courses
     * @return
     */
    int deleteCourses(List<Course> courses);

    /**
     * 修改课程
     * @param course
     * @return
     */
    int updateCourse(Course course);

    /**
     * 查询所有课程
     * @return
     */
    List<Course> selectCourses();

    /**
     * 根据id查询课程
     * @param id
     * @return
     */
    Course selectCourse(Integer id);

    /**
     * 分页查询课程
     * @param begin 起始索引，从0开始
     * @param size  每页大小
     * @return
     */
    List<Course> selectCoursesByLimit(@Param("begin") int begin, @Param("size")int size);

    /**
     * 获取课程数量
     * @return
     */
    int getCoursesCount();

    /**
     * 分页搜索课程
     * @param map 4个参数，begin,size,mname,mdept
     * @return
     */
    List<Course> searchCoursesByLimit(Map<String,Object> map);

    /**
     * 获取搜索的数量
     * @param map 2个参数，mname,mdept
     * @return
     */
    int getSearchCount(Map<String,Object> map);

    List<Course> selectCoursesByTeacher(int tid);
}
