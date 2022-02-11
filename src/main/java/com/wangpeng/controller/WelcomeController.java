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

    @RequestMapping("getAllCount.do")
    public Map<String, Integer> getAllCount() {
        Map<String, Integer> map = service.getAllCount();
        return map;
    }

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
