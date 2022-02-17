package com.wangpeng.controller;

import com.wangpeng.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
     * @return 数量信息
     */
    @GetMapping("getAllCount.do")
    public Map<String, Integer> getAllCount() {
        Map<String, Integer> map = service.getAllCount();
        return map;
    }

    /**
     * 学生获取首页数量
     * @param sid 学生id
     * @return 数量信息
     */
    @GetMapping("student/getAllCountByStudent.do")
    public Map<String, Integer> getAllCountByStudent(Integer sid) {
        Map<String, Integer> map = service.getAllCountByStudent(sid);
        return map;
    }

    /**
     * 教师获取首页数量
     * @param tid 教师id
     * @return 数量信息
     */
    @GetMapping("teacher/getAllCountByTeacher.do")
    public Map<String, Integer> getAllCountByTeacher(Integer tid) {
        Map<String, Integer> map = service.getAllCountByTeacher(tid);
        return map;
    }

}
