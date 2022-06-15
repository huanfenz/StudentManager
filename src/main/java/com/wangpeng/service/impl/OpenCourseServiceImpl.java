package com.wangpeng.service.impl;

import com.wangpeng.dao.ClazzDao;
import com.wangpeng.dao.CourseDao;
import com.wangpeng.dao.OpenCourseDao;
import com.wangpeng.dao.TeacherDao;
import com.wangpeng.pojo.*;
import com.wangpeng.service.OpenCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 为开课列表添加信息
     * @param openCourses
     */
    private void addInfoForOpenCourses(List<OpenCourse> openCourses) {
        for(OpenCourse openCourse : openCourses) {
            Integer cid = openCourse.getCid();
            if (cid != null) {
                Clazz clazz = clazzDao.selectClazz(cid);
                if (clazz != null) {
                    openCourse.setCname(clazz.getCname());
                }
            }

            Integer tid = openCourse.getTid();
            if (tid != null) {
                Teacher teacher = teacherDao.selectTeacher(tid);
                if (teacher != null) {
                    openCourse.setTname(teacher.getTname());
                }
            }

            Integer courseId = openCourse.getCourseId();
            if (courseId != null) {
                Course course = courseDao.selectCourse(courseId);
                if (course != null) {
                    openCourse.setCourseName(course.getCourseName());
                }
            }
        }
    }

    @Override
    public List<OpenCourse> findOpenCoursesByPage(int page, int size) {
        int begin = (page - 1) * size;
        List<OpenCourse> openCourses = openCourseDao.selectOpenCoursesByLimit(begin, size);
        //放入班级名、教师名、课程名信息
        addInfoForOpenCourses(openCourses);
        return openCourses;
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
        //放入班级名、教师名、课程名信息
        addInfoForOpenCourses(openCourses);
        return openCourses;
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
        //放入班级名、教师名、课程名信息
        addInfoForOpenCourses(openCourses);
        return openCourses;
    }

    @Override
    public List<OpenCourseAndScore> findOpenCoursesByStudent(Integer sid) {
        List<OpenCourseAndScore> openCourseAndScores = openCourseDao.selectOpenCoursesByStudent(sid);
        //添加教师名、课程名信息
        for(OpenCourseAndScore openCourseAndScore : openCourseAndScores) {
            Integer tid = openCourseAndScore.getTid();
            if (tid != null) {
                Teacher teacher = teacherDao.selectTeacher(tid);
                openCourseAndScore.setTname(teacher.getTname());
            }

            Integer courseId = openCourseAndScore.getCourseId();
            if (courseId != null) {
                Course course = courseDao.selectCourse(courseId);
                openCourseAndScore.setCourseName(course.getCourseName());
            }
        }
        return openCourseAndScores;
    }

}
