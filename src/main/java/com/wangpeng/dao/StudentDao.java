package com.wangpeng.dao;

import com.wangpeng.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    /**
     * 添加学生
     * @param student
     * @return
     */
    int insertStudent(Student student);

    /**
     * 删除学生
     * @param list
     * @return
     */
    int deleteStudents(List<Student> list);

    /**
     * 修改学生
     * @param student
     * @return
     */
    int updateStudent(Student student);

    /**
     * 根据id查询学生
     * @param sid
     * @return
     */
    Student selectStudent(int sid);

    /**
     * 分页查询学生
     * @param begin 起始索引，从0开始
     * @param size  每页大小
     * @return
     */
    List<Student> selectStudentsByLimit(@Param("begin") int begin, @Param("size")int size);

    /**
     * 获取学生数量
     * @return
     */
    int getStudentsCount();

    /**
     * 分页搜索学生
     * @param map 5个参数，begin,size,sname,snum,sclass
     * @return
     */
    List<Student> searchStudentsByLimit(Map<String,Object> map);

    /**
     * 获取搜索的数量
     * @param map 3个参数，sname,snum,sclass
     * @return
     */
    int getSearchCount(Map<String,Object> map);

    /**
     * 检查登录
     * @param map 2个参数，username和password
     * @return
     */
    Student checkByUsernameAndPassword(Map<String,Object> map);

    /**
     * 获得教师所教学生的数量
     * @return
     */
    int getStudentsCountByTeacher(int tid);


    List<Student> selectStudentsByLimitByTeacher(@Param("begin")int begin, @Param("size")int size, @Param("tid")int tid);

    List<Student> selectStudentsByOid(int oid);
}
