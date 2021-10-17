package com.wangpeng.controller;

import com.wangpeng.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("welcome")
public class WelcomeController {

    @Autowired
    WelcomeService service;

    @RequestMapping("getAllCount.do")
    @ResponseBody
    public Map<String, Integer> getAllCount() {
        Map<String, Integer> map = service.getAllCount();
        return map;
    }

    @RequestMapping("getAllCountByStudent.do")
    @ResponseBody
    public Map<String, Integer> getAllCountByStudent(Integer sid) {
        Map<String, Integer> map = service.getAllCountByStudent(sid);
        return map;
    }

    @RequestMapping("getAllCountByTeacher.do")
    @ResponseBody
    public Map<String, Integer> getAllCountByTeacher(Integer tid) {
        Map<String, Integer> map = service.getAllCountByTeacher(tid);
        return map;
    }

}
