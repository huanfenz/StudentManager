package com.wangpeng.controller;

import com.wangpeng.pojo.ArrangeCourse;
import com.wangpeng.service.ArrangeCourseService;
import com.wangpeng.utils.JsonUtil;
import com.wangpeng.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/arrangeCourse")
public class ArrangeCourseController {

    @Autowired
    ArrangeCourseService service;

    /**
     * 查询排课
     * @param page  当前页码
     * @param limit 每页大小
     * @return 排课信息
     */
    @RequestMapping("queryArrangeCourses.do")
    public PageResult queryArrangeCourses(Integer page, Integer limit){
        //获取排课数量
        int count = service.getArrangeCoursesCount();
        //获取数据
        List<ArrangeCourse> arrangeCourses = service.findArrangeCoursesByPage(page,limit);
        //返回结果
        return PageResult.success(count, arrangeCourses);
    }

    /**
     * 查询所有排课
     * @return 所有排课信息
     */
    @RequestMapping("queryAllArrangeCourses.do")
    public List<ArrangeCourse> queryAllArrangeCourses(){
        return service.findAllArrangeCourses();
    }

    /**
     * 删除排课
     * @param json 排课对象的json
     * @return 成功行数
     */
    @RequestMapping("deleteArrangeCourses.do")
    public Integer deleteArrangeCourses(String json){
        if(json.charAt(0) != '[') json = '[' + json + ']';  //如果不是数组形式，变成数组形式
        List<ArrangeCourse> arrangeCourses = JsonUtil.parseList(json, ArrangeCourse.class);
        return service.deleteArrangeCourses(arrangeCourses);
    }

    /**
     * 添加一个排课
     * @param json 排课对象的json
     * @return 成功标志1
     */
    @RequestMapping("addArrangeCourse.do")
    public Integer addArrangeCourse(String json){
        ArrangeCourse arrangeCourse = JsonUtil.parseObject(json, ArrangeCourse.class);
        return service.addArrangeCourse(arrangeCourse);
    }

    /**
     * 修改一个排课
     * @param json 排课对象的json
     * @return 成功标志1
     */
    @RequestMapping("updateArrangeCourse.do")
    public Integer updateArrangeCourse(String json){
        ArrangeCourse arrangeCourse = JsonUtil.parseObject(json, ArrangeCourse.class);
        return service.updateArrangeCourse(arrangeCourse);
    }

    /**
     * 获取排课总数
     * @return 排课总数
     */
    @RequestMapping("getAmount.do")
    public Integer getAmount() {
        return service.getArrangeCoursesCount();
    }

    /**
     * 根据oid查询排课
     * @param page  当前页码
     * @param limit 每页大小
     * @return 排课信息
     */
    @RequestMapping({"queryArrangeCoursesByOid.do", "teacher/queryArrangeCoursesByOid.do"})
    public PageResult queryArrangeCoursesByOid(Integer page, Integer limit, Integer oid){
        //获取数据
        List<ArrangeCourse> arrangeCourses = service.findArrangeCoursesByPageByOid(page,limit,oid);
        //返回结果
        return PageResult.success(arrangeCourses.size(), arrangeCourses);
    }

}
