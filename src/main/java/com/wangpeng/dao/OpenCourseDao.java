package com.wangpeng.dao;

import com.wangpeng.pojo.OpenCourse;
import com.wangpeng.pojo.OpenCourseAndScore;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OpenCourseDao {
    /**
     * 添加开课
     * @param openCourse
     * @return
     */
    int insertOpenCourse(OpenCourse openCourse);

    /**
     * 删除开课
     * @param openCourses
     * @return
     */
    int deleteOpenCourses(List<OpenCourse> openCourses);

    /**
     * 修改开课
     * @param openCourse
     * @return
     */
    int updateOpenCourse(OpenCourse openCourse);

    /**
     * 查询所有开课
     * @return
     */
    List<OpenCourse> selectOpenCourses();

    /**
     * 根据id查询开课
     * @param id
     * @return
     */
    OpenCourse selectOpenCourse(Integer id);

    /**
     * 分页查询开课
     * @param begin 起始索引，从0开始
     * @param size  每页大小
     * @return
     */
    List<OpenCourse> selectOpenCoursesByLimit(@Param("begin") int begin, @Param("size")int size);

    /**
     * 获取开课数量
     * @return
     */
    int getOpenCoursesCount();

    /**
     * 分页搜索开课
     * @param map 4个参数，begin,size,mname,mdept
     * @return
     */
    List<OpenCourse> searchOpenCoursesByLimit(Map<String,Object> map);

    /**
     * 获取搜索的数量
     * @param map 2个参数，mname,mdept
     * @return
     */
    int getSearchCount(Map<String,Object> map);

    int getOpenCoursesCountByTeacher(int tid);

    List<OpenCourse> selectOpenCoursesByLimitByTeacher(@Param("begin")int begin, @Param("size")Integer size, @Param("tid")Integer tid);

    /**
     * 查询学生的开课和成绩信息
     * @param sid
     * @return
     */
    List<OpenCourseAndScore> selectOpenCoursesByStudent(Integer sid);

    /**
     * 获取某学生的开课数量
     * @return
     */
    int getOpenCoursesCountByStudent(Integer sid);
}
