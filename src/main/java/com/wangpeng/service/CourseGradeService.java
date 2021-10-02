package com.wangpeng.service;

import com.wangpeng.pojo.CourseGrade;
import com.wangpeng.pojo.Major;

import java.util.List;
import java.util.Map;

public interface CourseGradeService {


    List<CourseGrade> findScoresByOid(Integer oid);

    CourseGrade findScoreByOidAndSid(int oid, int sid);
}
