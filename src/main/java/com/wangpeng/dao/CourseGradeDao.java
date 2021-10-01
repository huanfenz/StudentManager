package com.wangpeng.dao;

import com.wangpeng.pojo.CourseGrade;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CourseGradeDao {
    /**
     * 添加成绩
     * @param courseGrade
     * @return
     */
    int insertCourseGrade(CourseGrade courseGrade);

    /**
     * 删除成绩
     * @param courseGrades
     * @return
     */
    int deleteCourseGrades(List<CourseGrade> courseGrades);

    /**
     * 修改成绩
     * @param courseGrade
     * @return
     */
    int updateCourseGrade(CourseGrade courseGrade);

    /**
     * 查询所有成绩
     * @return
     */
    List<CourseGrade> selectCourseGrades();

    /**
     * 根据id查询成绩
     * @param id
     * @return
     */
    CourseGrade selectCourseGrade(Integer id);

    /**
     * 分页查询成绩
     * @param begin 起始索引，从0开始
     * @param size  每页大小
     * @return
     */
    List<CourseGrade> selectCourseGradesByLimit(@Param("begin") int begin, @Param("size")int size);

    /**
     * 获取成绩数量
     * @return
     */
    int getCourseGradesCount();

    /**
     * 分页搜索成绩
     * @param map 4个参数，begin,size,mname,mdept
     * @return
     */
    List<CourseGrade> searchCourseGradesByLimit(Map<String,Object> map);

    /**
     * 获取搜索的数量
     * @param map 2个参数，mname,mdept
     * @return
     */
    int getSearchCount(Map<String,Object> map);

    List<CourseGrade> selectScoresByOid(Integer oid);
}
