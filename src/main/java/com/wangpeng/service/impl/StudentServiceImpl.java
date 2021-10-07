package com.wangpeng.service.impl;

import com.wangpeng.dao.ClazzDao;
import com.wangpeng.dao.StudentDao;
import com.wangpeng.pojo.Clazz;
import com.wangpeng.pojo.Student;
import com.wangpeng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    ClazzDao clazzDao;

    @Override
    public List<Student> findStudentsByPage(int page, int size) {
        int begin = (page - 1) * size;
        List<Student> students = studentDao.selectStudentsByLimit(begin, size);
        List<Student> res = new ArrayList<>();
        //放入班级名信息
        for(Student student : students) {
            int cid = student.getCid();
            Clazz clazz = clazzDao.selectClazz(cid);
            student.setCname(clazz.getCname());
            res.add(student);
        }
        return res;
    }

    @Override
    public int getStudentsCount() {
        return studentDao.getStudentsCount();
    }

    @Override
    public int deleteStudents(List<Student> students) {
        return studentDao.deleteStudents(students);
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public List<Student> searchStudents(Integer page, Integer size, Map<String, Object> searchParam) {
        int begin = (page - 1) * size;
        //在搜索的基础上添加2个参数
        Map<String,Object> map = searchParam;
        map.put("begin", begin);
        map.put("size", size);
        List<Student> students = studentDao.searchStudentsByLimit(map);
        List<Student> res = new ArrayList<>();
        //放入班级名信息
        for(Student student : students) {
            int cid = student.getCid();
            Clazz clazz = clazzDao.selectClazz(cid);
            student.setCname(clazz.getCname());
            res.add(student);
        }
        return res;
    }

    @Override
    public int getSearchCount(Map<String, Object> searchParam) {
        return studentDao.getSearchCount(searchParam);
    }

    @Override
    public int getStudentsCountByTeacher(int tid) {
        return studentDao.getStudentsCountByTeacher(tid);
    }

    @Override
    public List<Student> findStudentsByPageByTeacher(Integer page, Integer size, int tid) {
        int begin = (page - 1) * size;
        List<Student> students = studentDao.selectStudentsByLimitByTeacher(begin, size, tid);
        List<Student> res = new ArrayList<>();
        //放入班级名信息
        for(Student student : students) {
            int cid = student.getCid();
            Clazz clazz = clazzDao.selectClazz(cid);
            student.setCname(clazz.getCname());
            res.add(student);
        }
        return res;
    }

    @Override
    public List<Student> findStudentsByOid(int oid) {
        List<Student> students =  studentDao.selectStudentsByOid(oid);
        return students;
    }

    @Override
    public Student findStudentBySid(Integer sid) {
        Student student = studentDao.selectStudent(sid);
        //添加班级名信息
        int cid = student.getCid();
        Clazz clazz = clazzDao.selectClazz(cid);
        student.setCname(clazz.getCname());
        return student;
    }
}
