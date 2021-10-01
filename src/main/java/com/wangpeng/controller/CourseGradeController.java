package com.wangpeng.controller;

import com.wangpeng.pojo.CourseGrade;
import com.wangpeng.pojo.Major;
import com.wangpeng.service.CourseGradeService;
import com.wangpeng.service.MajorService;
import com.wangpeng.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/courseGrade")
public class CourseGradeController {

    @Autowired
    CourseGradeService service;

    @RequestMapping("queryScoresByOid.do")
    @ResponseBody
    public List<CourseGrade> queryScoresByOid(Integer oid){
        List<CourseGrade> courseGrades = service.findScoresByOid(oid);
        return courseGrades;
    }

    /*public int */

}
