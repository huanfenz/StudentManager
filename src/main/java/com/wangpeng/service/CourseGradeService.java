package com.wangpeng.service;

import com.wangpeng.pojo.CourseGrade;

public interface CourseGradeService {

    CourseGrade findScoreByOidAndSid(int oid, int sid);

    int saveCourseGrade(CourseGrade courseGrade);
}
