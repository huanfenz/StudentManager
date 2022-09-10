package com.wangpeng.service;

import com.wangpeng.pojo.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface StudentService {

    /**
     * 分页找所有学生
     * @param page
     * @param size
     * @return
     */
    List<Student> findStudentsByPage(int page, int size);

    /**
     * 获取学生总数
     * @return
     */
    int getStudentsCount();

    /**
     * 删除指定学生
     * @param students
     * @return 删除成功的数量
     */
    int deleteStudents(List<Student> students);

    /**
     * 添加一个学生
     * @param student
     */
    int addStudent(Student student);

    /**
     * 修改一个学生
     * @param student
     * @return
     */
    int updateStudent(Student student);

    /**
     * 搜索学生
     * @param page
     * @param size
     * @param searchParam
     */
    List<Student> searchStudents(Integer page, Integer size, Map<String, Object> searchParam);

    /**
     * 教师搜索学生
     * @param page
     * @param size
     * @param searchParam
     * @return
     */
    List<Student> searchStudentsByTeacher(Integer page, Integer size, Map<String, Object> searchParam);

    /**
     * 获取搜索的数量
     * @param searchParam
     * @return
     */
    int getSearchCount(Map<String, Object> searchParam);

    /**
     * 教师获取搜索学生数量
     * @param searchParam
     * @return
     */
    int getSearchCountByTeacher(Map<String, Object> searchParam);

    /**
     * 教师获取学生数量
     * @param tid
     * @return 学生数量
     */
    int getStudentsCountByTeacher(int tid);

    /**
     * 教师分页查询学生
     * @param page
     * @param size
     * @param tid
     * @return
     */
    List<Student> findStudentsByPageByTeacher(Integer page, Integer size, int tid);

    /**
     * 通过oid查询学生
     * @param oid
     * @return
     */
    List<Student> findStudentsByOid(int oid);

    /**
     * 通过学生id寻找学生
     * @param sid
     * @return
     */
    Student findStudentBySid(Integer sid);

    /**
     * 导出信息
     * @param req
     * @return
     */
    String print(HttpServletRequest req);
}
