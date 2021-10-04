package com.wangpeng.controller;

import com.wangpeng.pojo.OpenCourse;
import com.wangpeng.pojo.OpenCourseAndScore;
import com.wangpeng.pojo.Student;
import com.wangpeng.pojo.Teacher;
import com.wangpeng.service.OpenCourseService;
import com.wangpeng.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/openCourse")
public class OpenCourseController {

    @Autowired
    OpenCourseService service;

    /**
     * 查询开课
     * @param page  当前页码
     * @param limit 每页大小
     * @return 数据
     */
    @RequestMapping("queryOpenCourses.do")
    @ResponseBody
    public Map<String,Object> queryOpenCourses(Integer page, Integer limit){
        //获取开课数量
        int count = service.getOpenCoursesCount();
        //获取数据
        List<OpenCourse> openCourses = service.findOpenCoursesByPage(page,limit);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", openCourses);

        return res;
    }

    /**
     * 查询开课(教师权限)
     * @param page  当前页码
     * @param limit 每页大小
     * @return 数据
     */
    @RequestMapping("queryOpenCoursesByTeacher.do")
    @ResponseBody
    public Map<String,Object> queryOpenCoursesByTeacher(Integer page, Integer limit, HttpServletRequest req){
        //获取当前账号信息
        Teacher loginTeacher =  (Teacher) req.getSession().getAttribute("loginObj");

        //获取开课数量
        int count = service.getOpenCoursesCountByTeacher(loginTeacher.getTid());
        //获取数据
        List<OpenCourse> openCourses = service.findOpenCoursesByPageByTeacher(page,limit,loginTeacher.getTid());
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", openCourses);

        return res;
    }

    /**
     * 查询(学生权限)
     * @return 数据
     */
    @RequestMapping("queryOpenCoursesByStudent.do")
    @ResponseBody
    public Map<String,Object> queryOpenCoursesByStudent(Integer oid, HttpServletRequest req){
        //获取当前账号信息
        Student loginStudent =  (Student) req.getSession().getAttribute("loginObj");
        //获得数据
        List<OpenCourseAndScore> openCourseAndScores = service.findOpenCoursesByStudent(loginStudent.getSid());
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", openCourseAndScores.size());
        res.put("data", openCourseAndScores);
        return res;
    }

    /**
     * 查询所有开课
     * @return
     */
    @RequestMapping("queryAllOpenCourses.do")
    @ResponseBody
    public List<OpenCourse> queryAllOpenCourses(){
        return service.findAllOpenCourses();
    }

    /**
     * 删除开课
     * @param json
     * @return 返回成功的行数
     */
    @RequestMapping("deleteOpenCourses.do")
    @ResponseBody
    public Integer deleteOpenCourses(String json){
        if(json.charAt(0) != '[') json = '[' + json + ']';  //如果不是数组形式，变成数组形式
        List<OpenCourse> openCourses = JsonUtil.parseList(json, OpenCourse.class);
        return service.deleteOpenCourses(openCourses);
    }

    /**
     * 添加一个开课
     * @param json
     * @return 成功标志1
     */
    @RequestMapping("addOpenCourse.do")
    @ResponseBody
    public Integer addOpenCourse(String json){
        OpenCourse openCourse = JsonUtil.parseObject(json, OpenCourse.class);
        return service.addOpenCourse(openCourse);
    }

    /**
     * 修改一个开课
     * @param json
     * @return 成功标志1
     */
    @RequestMapping("updateOpenCourse.do")
    @ResponseBody
    public Integer updateOpenCourse(String json){
        OpenCourse openCourse = JsonUtil.parseObject(json, OpenCourse.class);
        return service.updateOpenCourse(openCourse);
    }

    /**
     * 获取开课总数
     * @return
     * @throws IOException
     */
    @RequestMapping("getAmount.do")
    @ResponseBody
    public Integer getAmount() {
        return service.getOpenCoursesCount();
    }

    @RequestMapping("searchOpenCourses.do")
    @ResponseBody
    public Map<String,Object> searchOpenCourses(Integer page, Integer limit, String json){
        //获得搜索的参数
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        //获取查询个数
        int count = service.getSearchCount(searchParam);
        //查询数据
        List<OpenCourse> openCourses = service.searchOpenCourses(page, limit, searchParam);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", openCourses);
        return res;
    }

}
