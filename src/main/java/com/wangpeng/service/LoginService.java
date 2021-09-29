package com.wangpeng.service;

import com.wangpeng.pojo.Student;
import com.wangpeng.pojo.Teacher;
import com.wangpeng.pojo.Manager;

public interface LoginService {
    Manager managerLogin(String username, String password);

    Teacher teacherLogin(String username, String password);

    Student studentLogin(String username, String password);

    void setPassword(Manager manager, String password);
}
