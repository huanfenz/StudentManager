package com.wangpeng.dao;

import com.wangpeng.pojo.CourseDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TableShowDao {

    //联合查询，将开课表、课程表表、班级表、教师表、教师表连接起来，筛选需要的信息
    List<CourseDetail> selectCourseDetail(@Param("cid")int cid);
}
