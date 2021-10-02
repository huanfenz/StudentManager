package com.wangpeng.service;

import com.wangpeng.pojo.CourseGrade;
import com.wangpeng.pojo.Major;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface CourseGradeService {

    CourseGrade findScoreByOidAndSid(int oid, int sid);

    int saveCourseGrade(CourseGrade courseGrade);
}
