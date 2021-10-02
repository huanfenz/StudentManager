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
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/courseGrade")
public class CourseGradeController {

    @Autowired
    CourseGradeService service;

    @RequestMapping("saveScore.do")
    @ResponseBody
    public Integer saveScore(String json, Integer oid){
        Map<Integer, BigDecimal> paramMap = JsonUtil.parseMap(json,Integer.class,BigDecimal.class);
        //sid:score
        int res = 0;
        for(Map.Entry<Integer,BigDecimal> entry : paramMap.entrySet()) {
            Integer sid = entry.getKey();
            BigDecimal score = entry.getValue();

            if(score == null) continue;

            res += service.saveCourseGrade(new CourseGrade(null,oid,sid,score));
        }
        return res;
    }
}
