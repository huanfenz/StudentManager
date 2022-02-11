package com.wangpeng.controller;

import com.wangpeng.pojo.ArrangeCourse;
import com.wangpeng.service.ArrangeCourseService;
import com.wangpeng.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/arrangeCourse")
public class ArrangeCourseController {

    @Autowired
    ArrangeCourseService service;

    /**
     * 查询课表
     * @param page  当前页码
     * @param limit 每页大小
     * @return 数据
     */
    @RequestMapping("queryArrangeCourses.do")
    public Map<String,Object> queryArrangeCourses(Integer page, Integer limit){
        //获取课表数量
        int count = service.getArrangeCoursesCount();
        //获取数据
        List<ArrangeCourse> arrangeCourses = service.findArrangeCoursesByPage(page,limit);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", arrangeCourses);

        return res;
    }

    /**
     * 查询所有课表
     * @return
     */
    @RequestMapping("queryAllArrangeCourses.do")
    public List<ArrangeCourse> queryAllArrangeCourses(){
        return service.findAllArrangeCourses();
    }

    /**
     * 删除课表
     * @param json
     * @return 返回成功的行数
     */
    @RequestMapping("deleteArrangeCourses.do")
    public Integer deleteArrangeCourses(String json){
        if(json.charAt(0) != '[') json = '[' + json + ']';  //如果不是数组形式，变成数组形式
        List<ArrangeCourse> arrangeCourses = JsonUtil.parseList(json, ArrangeCourse.class);
        int res = service.deleteArrangeCourses(arrangeCourses);
        return res;
    }

    /**
     * 添加一个课表
     * @param json
     * @return 成功标志1
     */
    @RequestMapping("addArrangeCourse.do")
    public Integer addArrangeCourse(String json){
        ArrangeCourse arrangeCourse = JsonUtil.parseObject(json, ArrangeCourse.class);
        return service.addArrangeCourse(arrangeCourse);
    }

    /**
     * 修改一个课表
     * @param json
     * @return 成功标志1
     */
    @RequestMapping("updateArrangeCourse.do")
    public Integer updateArrangeCourse(String json){
        ArrangeCourse arrangeCourse = JsonUtil.parseObject(json, ArrangeCourse.class);
        return service.updateArrangeCourse(arrangeCourse);
    }

    /**
     * 获取课表总数
     * @return
     * @throws IOException
     */
    @RequestMapping("getAmount.do")
    public Integer getAmount() {
        return service.getArrangeCoursesCount();
    }

    /**
     * 查询课表根据oid
     * @param page  当前页码
     * @param limit 每页大小
     * @return 数据
     */
    @RequestMapping({"queryArrangeCoursesByOid.do", "teacher/queryArrangeCoursesByOid.do"})
    public Map<String,Object> queryArrangeCoursesByOid(Integer page, Integer limit, Integer oid){
        //获取数据
        List<ArrangeCourse> arrangeCourses = service.findArrangeCoursesByPageByOid(page,limit,oid);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", arrangeCourses.size());
        res.put("data", arrangeCourses);

        return res;
    }

}
