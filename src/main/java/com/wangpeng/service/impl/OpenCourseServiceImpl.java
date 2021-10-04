package com.wangpeng.service.impl;

import com.wangpeng.dao.ClazzDao;
import com.wangpeng.dao.CourseDao;
import com.wangpeng.dao.OpenCourseDao;
import com.wangpeng.dao.TeacherDao;
import com.wangpeng.pojo.*;
import com.wangpeng.service.OpenCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OpenCourseServiceImpl implements OpenCourseService {

    @Autowired
    OpenCourseDao openCourseDao;

    // 班级、教师、课程
    @Autowired
    ClazzDao clazzDao;
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    CourseDao courseDao;

    @Override
    public List<OpenCourse> findAllOpenCourses() {
        return openCourseDao.selectOpenCourses();
    }

    @Override
    public List<OpenCourse> findOpenCoursesByPage(int page, int size) {
        int begin = (page - 1) * size;
        List<OpenCourse> openCourses = openCourseDao.selectOpenCoursesByLimit(begin, size);
        List<OpenCourse> res = new ArrayList<>();
        //放入班级名、教师名、课程名信息
        for(OpenCourse openCourse : openCourses) {
            int cid = openCourse.getCid();
            Clazz clazz = clazzDao.selectClazz(cid);
            openCourse.setCname(clazz.getCname());

            int tid = openCourse.getTid();
            Teacher teacher = teacherDao.selectTeacher(tid);
            openCourse.setTname(teacher.getTname());

            int courseId = openCourse.getCourseId();
            Course course = courseDao.selectCourse(courseId);
            openCourse.setCourseName(course.getCourseName());

            res.add(openCourse);
        }
        return res;
    }

    @Override
    public int getOpenCoursesCount() {
        return openCourseDao.getOpenCoursesCount();
    }

    @Override
    public int deleteOpenCourses(List<OpenCourse> openCourses) {
        return openCourseDao.deleteOpenCourses(openCourses);
    }

    @Override
    public int addOpenCourse(OpenCourse openCourse) {
        return openCourseDao.insertOpenCourse(openCourse);
    }

    @Override
    public int updateOpenCourse(OpenCourse openCourse) {
        return openCourseDao.updateOpenCourse(openCourse);
    }

    @Override
    public List<OpenCourse> searchOpenCourses(Integer page, Integer size, Map<String, Object> searchParam) {
        int begin = (page - 1) * size;
        //在搜索的基础上添加2个参数
        Map<String,Object> map = searchParam;
        map.put("begin", begin);
        map.put("size", size);
        List<OpenCourse> openCourses = openCourseDao.searchOpenCoursesByLimit(map);
        List<OpenCourse> res = new ArrayList<>();
        //放入班级名、教师名、课程名信息
        for(OpenCourse openCourse : openCourses) {
            int cid = openCourse.getCid();
            Clazz clazz = clazzDao.selectClazz(cid);
            openCourse.setCname(clazz.getCname());

            int tid = openCourse.getTid();
            Teacher teacher = teacherDao.selectTeacher(tid);
            openCourse.setTname(teacher.getTname());

            int courseId = openCourse.getCourseId();
            Course course = courseDao.selectCourse(courseId);
            openCourse.setCourseName(course.getCourseName());

            res.add(openCourse);
        }
        return res;
    }

    @Override
    public int getSearchCount(Map<String, Object> searchParam) {
        return openCourseDao.getSearchCount(searchParam);
    }

    @Override
    public int getOpenCoursesCountByTeacher(int tid) {
        return openCourseDao.getOpenCoursesCountByTeacher(tid);
    }

    @Override
    public List<OpenCourse> findOpenCoursesByPageByTeacher(Integer page, Integer size, Integer tid) {
        int begin = (page - 1) * size;
        List<OpenCourse> openCourses = openCourseDao.selectOpenCoursesByLimitByTeacher(begin, size, tid);

        List<OpenCourse> res = new ArrayList<>();
        //放入班级名、教师名、课程名信息
        for(OpenCourse openCourse : openCourses) {
            int cid = openCourse.getCid();
            Clazz clazz = clazzDao.selectClazz(cid);
            openCourse.setCname(clazz.getCname());

            //int tid = openCourse.getTid();
            Teacher teacher = teacherDao.selectTeacher(tid);
            openCourse.setTname(teacher.getTname());

            int courseId = openCourse.getCourseId();
            Course course = courseDao.selectCourse(courseId);
            openCourse.setCourseName(course.getCourseName());

            res.add(openCourse);
        }
        return res;
    }

    @Override
    public List<OpenCourseAndScore> findOpenCoursesByStudent(Integer sid) {
        List<OpenCourseAndScore> openCourseAndScores = openCourseDao.selectOpenCoursesByStudent(sid);
        //添加信息
        List<OpenCourseAndScore> res = new ArrayList<>();
        //放入教师名、课程名信息
        for(OpenCourseAndScore openCourseAndScore : openCourseAndScores) {
            int tid = openCourseAndScore.getTid();
            Teacher teacher = teacherDao.selectTeacher(tid);
            openCourseAndScore.setTname(teacher.getTname());

            int courseId = openCourseAndScore.getCourseId();
            Course course = courseDao.selectCourse(courseId);
            openCourseAndScore.setCourseName(course.getCourseName());

            res.add(openCourseAndScore);
        }
        return res;
    }

}
