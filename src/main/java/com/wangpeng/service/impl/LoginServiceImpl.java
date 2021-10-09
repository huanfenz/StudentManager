package com.wangpeng.service.impl;

import com.wangpeng.dao.ClazzDao;
import com.wangpeng.dao.StudentDao;
import com.wangpeng.dao.TeacherDao;
import com.wangpeng.dao.ManagerDao;
import com.wangpeng.pojo.Clazz;
import com.wangpeng.pojo.Student;
import com.wangpeng.pojo.Teacher;
import com.wangpeng.pojo.Manager;
import com.wangpeng.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    ManagerDao managerDao;
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    ClazzDao clazzDao;

    @Override
    public Manager managerLogin(String username, String password) {
        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        return managerDao.checkByUsernameAndPassword(map);
    }

    @Override
    public Teacher teacherLogin(String username, String password) {
        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        return teacherDao.checkByUsernameAndPassword(map);
    }

    @Override
    public Student studentLogin(String username, String password) {
        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        Student student = studentDao.checkByUsernameAndPassword(map);
        //添加班级名信息
        if(student != null) {
            int cid = student.getCid();
            Clazz clazz = clazzDao.selectClazz(cid);
            student.setCname(clazz.getCname());
        }
        return student;
    }

    @Override
    public void setPassword(Manager manager, String password) {
        manager.setPassword(password);
        managerDao.updateManager(manager);
    }
}
