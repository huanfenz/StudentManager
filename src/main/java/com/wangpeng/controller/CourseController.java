package com.wangpeng.controller;

import com.wangpeng.pojo.Course;
import com.wangpeng.pojo.Teacher;
import com.wangpeng.service.CourseService;
import com.wangpeng.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService service;

    /**
     * 查询课程
     * @param page  当前页码
     * @param limit 每页大小
     * @return 课程信息
     */
    @RequestMapping("queryCourses.do")
    public Map<String,Object> queryCourses(Integer page, Integer limit){
        //获取课程数量
        int count = service.getCoursesCount();
        //获取数据
        List<Course> courses = service.findCoursesByPage(page,limit);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", courses);

        return res;
    }

    /**
     * 查询所有课程
     * @return 课程信息
     */
    @RequestMapping("queryAllCourses.do")
    public List<Course> queryAllCourses(){
        return service.findAllCourses();
    }

    /**
     * 查询所有课程
     * @return 课程信息
     */
    @RequestMapping("teacher/queryAllCoursesByTeacher.do")
    public List<Course> queryAllCoursesByTeacher(HttpServletRequest req){
        //获取当前账号信息
        Teacher loginTeacher =  (Teacher) req.getSession().getAttribute("loginObj");
        return service.findAllCoursesByTeacher(loginTeacher.getTid());
    }

    /**
     * 删除课程
     * @param json 课程对象的json
     * @return 成功行数
     */
    @RequestMapping("deleteCourses.do")
    public Integer deleteCourses(String json){
        if(json.charAt(0) != '[') json = '[' + json + ']';  //如果不是数组形式，变成数组形式
        List<Course> courses = JsonUtil.parseList(json, Course.class);
        return service.deleteCourses(courses);
    }

    /**
     * 添加一个课程
     * @param json 课程对象的json
     * @return 成功标志1
     */
    @RequestMapping("addCourse.do")
    public Integer addCourse(String json){
        Course course = JsonUtil.parseObject(json, Course.class);
        return service.addCourse(course);
    }

    /**
     * 修改一个课程
     * @param json 课程对象的json
     * @return 成功标志1
     */
    @RequestMapping("updateCourse.do")
    public Integer updateCourse(String json){
        Course course = JsonUtil.parseObject(json, Course.class);
        return service.updateCourse(course);
    }

    /**
     * 获取课程总数
     * @return 课程总数
     */
    @RequestMapping("getAmount.do")
    public Integer getAmount() {
        return service.getCoursesCount();
    }

    /**
     * 搜索课程
     * @param page 当前页码
     * @param limit 每页大小
     * @param json 搜索参数的json
     *             {{"courseName": 课程名}}
     * @return 课程信息
     */
    @RequestMapping("searchCourses.do")
    public Map<String,Object> searchCourses(Integer page, Integer limit, String json){
        //获得搜索的参数
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        //获取查询个数
        int count = service.getSearchCount(searchParam);
        //查询数据
        List<Course> courses = service.searchCourses(page, limit, searchParam);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", courses);
        return res;
    }

}
