package com.wangpeng.service;

import com.wangpeng.pojo.OpenCourse;
import com.wangpeng.pojo.OpenCourseAndScore;

import java.util.List;
import java.util.Map;

public interface OpenCourseService {

    /**
     * 找所有的开课
     * @return
     */
    List<OpenCourse> findAllOpenCourses();

    /**
     * 分页找所有开课
     * @param page
     * @param size
     * @return
     */
    List<OpenCourse> findOpenCoursesByPage(int page, int size);

    /**
     * 获取开课总数
     * @return
     */
    int getOpenCoursesCount();

    /**
     * 删除指定开课
     * @param openCourses
     * @return 删除成功的数量
     */
    int deleteOpenCourses(List<OpenCourse> openCourses);

    /**
     * 添加一个开课
     * @param openCourse
     */
    int addOpenCourse(OpenCourse openCourse);

    /**
     * 修改一个开课
     * @param openCourse
     * @return
     */
    int updateOpenCourse(OpenCourse openCourse);

    /**
     * 搜索开课
     * @param page
     * @param size
     * @param searchParam
     */
    List<OpenCourse> searchOpenCourses(Integer page, Integer size, Map<String, Object> searchParam);

    /**
     * 获取搜索的数量
     * @param searchParam
     * @return
     */
    int getSearchCount(Map<String, Object> searchParam);

    /**
     * 教师
     * @param tid
     * @return
     */
    int getOpenCoursesCountByTeacher(int tid);

    List<OpenCourse> findOpenCoursesByPageByTeacher(Integer page, Integer size, Integer tid);

    /**
     * 学生查询开课
     * @param sid
     * @return
     */
    List<OpenCourseAndScore> findOpenCoursesByStudent(Integer sid);
}
