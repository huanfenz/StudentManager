package com.wangpeng.service.impl;

import com.wangpeng.dao.*;
import com.wangpeng.pojo.*;
import com.wangpeng.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WelcomeServiceImpl implements WelcomeService {

    @Autowired
    StudentDao studentDao;
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    ManagerDao managerDao;
    @Autowired
    OpenCourseDao openCourseDao;
    @Autowired
    ApprovalDao approvalDao;

    @Override
    public Map<String, Integer> getAllCount() {
        Map<String,Integer> res = new HashMap<>();

        int studentCount = studentDao.getStudentsCount();
        int teacherCount = teacherDao.getTeachersCount();
        int managerCount = managerDao.getManagersCount();
        int openCourseCount = openCourseDao.getOpenCoursesCount();
        int approvalCount = approvalDao.getApprovalsCountUntreated();

        res.put("studentCount",studentCount);
        res.put("teacherCount",teacherCount);
        res.put("managerCount",managerCount);
        res.put("openCourseCount",openCourseCount);
        res.put("approvalCount",approvalCount);

        return res;
    }

    @Override
    public Map<String, Integer> getAllCountByStudent(Integer sid) {
        Map<String,Integer> res = new HashMap<>();
        int openCourseCount = openCourseDao.getOpenCoursesCountByStudent(sid);
        int approvalCount = approvalDao.getApprovalsCountBySid(sid);

        res.put("openCourseCount",openCourseCount);
        res.put("approvalCount",approvalCount);

        return res;
    }

    @Override
    public Map<String, Integer> getAllCountByTeacher(Integer tid) {
        Map<String,Integer> res = new HashMap<>();
        int studentCount = studentDao.getStudentsCountByTeacher(tid);
        int openCourseCount = openCourseDao.getOpenCoursesCountByTeacher(tid);

        res.put("studentCount", studentCount);
        res.put("openCourseCount",openCourseCount);

        return res;
    }
}
