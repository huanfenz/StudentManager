package com.wangpeng.service.impl;

import com.wangpeng.dao.ClazzDao;
import com.wangpeng.dao.TeacherDao;
import com.wangpeng.pojo.Teacher;
import com.wangpeng.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    ClazzDao clazzDao;

    @Override
    public List<Teacher> findTeachersByPage(int page, int size) {
        int begin = (page - 1) * size;
        return teacherDao.selectTeachersByLimit(begin, size);
    }

    @Override
    public int getTeachersCount() {
        return teacherDao.getTeachersCount();
    }

    @Override
    public int deleteTeachers(List<Teacher> teachers) {
        return teacherDao.deleteTeachers(teachers);
    }

    @Override
    public int addTeacher(Teacher teacher) {
        return teacherDao.insertTeacher(teacher);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherDao.updateTeacher(teacher);
    }

    @Override
    public List<Teacher> searchTeachers(Integer page, Integer size, Map<String, Object> searchParam) {
        int begin = (page - 1) * size;
        //在搜索的基础上添加2个参数
        Map<String,Object> map = searchParam;
        map.put("begin", begin);
        map.put("size", size);
        List<Teacher> teachers = teacherDao.searchTeachersByLimit(map);
        return teachers;
    }

    @Override
    public int getSearchCount(Map<String, Object> searchParam) {
        return teacherDao.getSearchCount(searchParam);
    }

    @Override
    public List<Teacher> findAllTeachers() {
        return teacherDao.selectTeachers();
    }

    @Override
    public Teacher findTeacher(int tid) {
        return teacherDao.selectTeacher(tid);
    }
}
