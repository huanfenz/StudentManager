package com.wangpeng.service.impl;

import com.wangpeng.dao.StudentDao;
import com.wangpeng.dao.TeacherDao;
import com.wangpeng.dao.ManagerDao;
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
        return studentDao.checkByUsernameAndPassword(map);
    }

    @Override
    public void setPassword(Manager manager, String password) {
        manager.setPassword(password);
        managerDao.updateManager(manager);
    }
}
