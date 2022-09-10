package com.wangpeng.service;

public interface TableShowService {
    // 联合查询，将开课表、课程表表、班级表、教师表、教师表连接起来，筛选需要的信息
    List<CourseDetail> selectCourseDetail(@Param("year")String year, @Param("term")String term, @Param("cid")int cid);
}
