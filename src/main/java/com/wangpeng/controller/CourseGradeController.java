package com.wangpeng.controller;

import com.wangpeng.pojo.CourseGrade;
import com.wangpeng.service.CourseGradeService;
import com.wangpeng.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/courseGrade")
public class CourseGradeController {

    @Autowired
    CourseGradeService service;

    @RequestMapping({"saveScore.do", "teacher/saveScore.do"})
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
