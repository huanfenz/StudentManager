package com.wangpeng.service.impl;

import com.wangpeng.dao.CourseGradeDao;
import com.wangpeng.dao.StudentDao;
import com.wangpeng.pojo.Clazz;
import com.wangpeng.pojo.CourseGrade;
import com.wangpeng.pojo.Student;
import com.wangpeng.service.CourseGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseGradeServiceImpl implements CourseGradeService {

    @Autowired
    CourseGradeDao courseGradeDao;
    @Autowired
    StudentDao studentDao;

    @Override
    public List<CourseGrade> findScoresByOid(Integer oid) {
        List<CourseGrade> courseGrades = courseGradeDao.selectScoresByOid(oid);
        //添加学生姓名信息
        List<CourseGrade> res = new ArrayList<>();
        //放入班级名信息、学号信息
        for(CourseGrade courseGrade : courseGrades) {
            int sid = courseGrade.getSid();
            Student student = studentDao.selectStudent(sid);
            courseGrade.setSname(student.getSname());
            courseGrade.setSnum(student.getSnum());
            res.add(courseGrade);
        }
        return res;
    }
}
