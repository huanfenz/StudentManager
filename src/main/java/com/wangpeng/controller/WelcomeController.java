package com.wangpeng.controller;

import com.wangpeng.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("welcome")
public class WelcomeController {

    @Autowired
    WelcomeService service;

    /**
     * 管理员获取首页数量
     * @return {
     * 	"studentCount": 学生数量,
     * 	"managerCount": 管理员数量,
     * 	"openCourseCount": 开课数量,
     * 	"teacherCount": 教师数量,
     * 	"approvalCount": 未处理的审批数量
     * }
     * @response {
     * 	"studentCount": 15,
     * 	"managerCount": 6,
     * 	"openCourseCount": 14,
     * 	"teacherCount": 14,
     * 	"approvalCount": 3
     * }
     */
    @RequestMapping("getAllCount.do")
    public Map<String, Integer> getAllCount() {
        Map<String, Integer> map = service.getAllCount();
        return map;
    }

    /**
     * 学生获取首页数量
     * @param sid 学生id
     * @return
     */
    @RequestMapping("student/getAllCountByStudent.do")
    public Map<String, Integer> getAllCountByStudent(Integer sid) {
        Map<String, Integer> map = service.getAllCountByStudent(sid);
        return map;
    }

    @RequestMapping("teacher/getAllCountByTeacher.do")
    public Map<String, Integer> getAllCountByTeacher(Integer tid) {
        Map<String, Integer> map = service.getAllCountByTeacher(tid);
        return map;
    }

}
