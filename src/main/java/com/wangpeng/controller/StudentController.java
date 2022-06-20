package com.wangpeng.controller;

import com.wangpeng.pojo.CourseGrade;
import com.wangpeng.pojo.Student;
import com.wangpeng.pojo.Teacher;
import com.wangpeng.service.CourseGradeService;
import com.wangpeng.service.StudentService;
import com.wangpeng.utils.JsonUtil;
import com.wangpeng.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService service;
    @Autowired
    CourseGradeService courseGradeService;

    /**
     * 查询所有学生
     * @param page  当前页码
     * @param limit 每页大小
     * @return 学生信息
     */
    @RequestMapping("queryStudents.do")
    public PageResult queryStudents(Integer page, Integer limit){
        //获取学生数量
        int count = service.getStudentsCount();
        //获取学生信息
        List<Student> students = service.findStudentsByPage(page,limit);
        //返回结果
        return PageResult.success(count, students);
    }

    /**
     * 查询学生
     * @return 学生信息
     */
    @RequestMapping({"queryStudent.do", "teacher/queryStudent.do"})
    public Student queryStudent(Integer sid){
        //获取学生信息
        Student student = service.findStudentBySid(sid);
        return student;
    }

    /**
     * 查询所有学生（教师权限）
     * @param page  当前页码
     * @param limit 每页大小
     * @return 学生信息
     */
    @RequestMapping("teacher/queryStudentsByTeacher.do")
    public PageResult queryStudentsByTeacher(Integer page, Integer limit, HttpServletRequest req){
        //获取当前账号信息
        Teacher loginTeacher =  (Teacher) req.getSession().getAttribute("loginObj");

        //获取学生数量
        int count = service.getStudentsCountByTeacher(loginTeacher.getTid());
        //获取学生信息
        List<Student> students = service.findStudentsByPageByTeacher(page,limit,loginTeacher.getTid());
        //返回结果
        return PageResult.success(count, students);
    }

    /**
     * 通过oid查询所有学生
     */
    @RequestMapping({"queryStudentsByOid.do", "teacher/queryStudentsByOid.do"})
    public List<Map<String,Object>> queryStudentsByOid(int oid){
        //获取学生学生信息
        List<Student> students = service.findStudentsByOid(oid);

        List<Map<String,Object>> res = new ArrayList<>();

        for(Student student : students) {
            Map<String,Object> map = new HashMap<>();
            map.put("sid", student.getSid());
            map.put("snum", student.getSnum());
            map.put("sname",student.getSname());
            CourseGrade courseGrade = courseGradeService.findScoreByOidAndSid(oid, student.getSid());
            if(courseGrade == null) map.put("score", null);
            else map.put("score", courseGrade.getScore());

            res.add(map);
        }

        return res;
    }

    /**
     * 删除学生
     * @param json 学生对象的json
     * @return 成功行数
     */
    @RequestMapping("deleteStudents.do")
    public Integer deleteStudents(String json){
        if(json.charAt(0) != '[') json = '[' + json + ']';  //如果不是数组形式，变成数组形式
        List<Student> students = JsonUtil.parseList(json, Student.class);
        return service.deleteStudents(students);
    }

    /**
     * 添加一个学生
     * @param json 学生对象的json
     * @return 成功标志1
     */
    @RequestMapping("addStudent.do")
    public Integer addStudent(String json){
        Student student = JsonUtil.parseObject(json, Student.class);
        return service.addStudent(student);
    }

    /**
     * 修改一个学生
     * @param json 学生对象的json
     * @return 成功标志1
     */
    @RequestMapping("updateStudent.do")
    public Integer updateStudent(String json){
        Student student = JsonUtil.parseObject(json, Student.class);
        return service.updateStudent(student);
    }

    /**
     * 获取学生总数
     * @return 学生总数
     */
    @RequestMapping("getAmount.do")
    public Integer getAmount() {
        return service.getStudentsCount();
    }

    /**
     * 搜索学生
     * @param page 当前页码
     * @param limit 每页大小
     * @param json 搜索参数的json
     *             {"sname":学生姓名,"snum":学号,"cid":班级id}
     * @return 学生信息
     */
    @RequestMapping("searchStudents.do")
    public PageResult searchStudents(Integer page, Integer limit, String json){
        //获得搜索的参数
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        //获取查询个数
        int count = service.getSearchCount(searchParam);
        //查询学生信息
        List<Student> students = service.searchStudents(page, limit, searchParam);
        //返回结果
        return PageResult.success(count, students);
    }

    /**
     * 教师搜索学生
     * @param page
     * @param limit
     * @param json
     * @param req
     * @return
     */
    @RequestMapping("teacher/searchStudentsByTeacher.do")
    public PageResult searchStudentsByTeacher(Integer page, Integer limit, String json, HttpServletRequest req){
        //获取当前账号信息
        Teacher loginTeacher =  (Teacher) req.getSession().getAttribute("loginObj");

        //获得搜索的参数
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        searchParam.put("tid", loginTeacher.getTid());

        //获取查询个数
        int count = service.getSearchCountByTeacher(searchParam);
        //查询学生信息
        List<Student> students = service.searchStudentsByTeacher(page, limit, searchParam);
        //返回结果
        return PageResult.success(count, students);
    }

    /**
     * 打印学生信息
     * @param req
     * @return
     */
    @RequestMapping("printStudentInformation.do")
    public Map<String, Object> printStudentInformation(HttpServletRequest req) {
        String url = service.print(req);

        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("url", url);

        return map;
    }
}
