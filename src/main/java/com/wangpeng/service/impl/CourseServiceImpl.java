package com.wangpeng.service.impl;

import com.wangpeng.dao.CourseDao;
import com.wangpeng.pojo.Course;
import com.wangpeng.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao courseDao;

    @Override
    public List<Course> findAllCourses() {
        return courseDao.selectCourses();
    }

    @Override
    public List<Course> findCoursesByPage(int page, int size) {
        int begin = (page - 1) * size;
        return courseDao.selectCoursesByLimit(begin,size);
    }

    @Override
    public int getCoursesCount() {
        return courseDao.getCoursesCount();
    }

    @Override
    public int deleteCourses(List<Course> courses) {
        return courseDao.deleteCourses(courses);
    }

    @Override
    public int addCourse(Course course) {
        return courseDao.insertCourse(course);
    }

    @Override
    public int updateCourse(Course course) {
        return courseDao.updateCourse(course);
    }

    @Override
    public List<Course> searchCourses(Integer page, Integer size, Map<String, Object> searchParam) {
        //在搜索的基础上添加2个参数
        searchParam.put("begin", (page - 1) * size);
        searchParam.put("size", size);
        return courseDao.searchCoursesByLimit(searchParam);
    }

    @Override
    public int getSearchCount(Map<String, Object> searchParam) {
        return courseDao.getSearchCount(searchParam);
    }

    @Override
    public List<Course> findAllCoursesByTeacher(int tid) {
        return courseDao.selectCoursesByTeacher(tid);
    }

}
