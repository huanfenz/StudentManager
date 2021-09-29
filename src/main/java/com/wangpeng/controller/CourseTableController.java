package com.wangpeng.controller;

import com.wangpeng.pojo.CourseTable;
import com.wangpeng.service.CourseTableService;
import com.wangpeng.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/courseTable")
public class CourseTableController {

    @Autowired
    CourseTableService service;

    /**
     * 查询课表
     * @param page  当前页码
     * @param limit 每页大小
     * @return 数据
     */
    @RequestMapping("queryCourseTables.do")
    @ResponseBody
    public Map<String,Object> queryCourseTables(Integer page, Integer limit){
        //获取课表数量
        int count = service.getCourseTablesCount();
        //获取数据
        List<CourseTable> courseTables = service.findCourseTablesByPage(page,limit);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", courseTables);

        return res;
    }

    /**
     * 查询所有课表
     * @return
     */
    @RequestMapping("queryAllCourseTables.do")
    @ResponseBody
    public List<CourseTable> queryAllCourseTables(){
        return service.findAllCourseTables();
    }

    /**
     * 删除课表
     * @param json
     * @return 返回成功的行数
     */
    @RequestMapping("deleteCourseTables.do")
    @ResponseBody
    public Integer deleteCourseTables(String json){
        if(json.charAt(0) != '[') json = '[' + json + ']';  //如果不是数组形式，变成数组形式
        List<CourseTable> courseTables = JsonUtil.parseList(json, CourseTable.class);
        int res = service.deleteCourseTables(courseTables);
        return res;
    }

    /**
     * 添加一个课表
     * @param json
     * @return 成功标志1
     */
    @RequestMapping("addCourseTable.do")
    @ResponseBody
    public Integer addCourseTable(String json){
        CourseTable courseTable = JsonUtil.parseObject(json, CourseTable.class);
        return service.addCourseTable(courseTable);
    }

    /**
     * 修改一个课表
     * @param json
     * @return 成功标志1
     */
    @RequestMapping("updateCourseTable.do")
    @ResponseBody
    public Integer updateCourseTable(String json){
        CourseTable courseTable = JsonUtil.parseObject(json, CourseTable.class);
        return service.updateCourseTable(courseTable);
    }

    /**
     * 获取课表总数
     * @return
     * @throws IOException
     */
    @RequestMapping("getAmount.do")
    @ResponseBody
    public Integer getAmount() {
        return service.getCourseTablesCount();
    }

    /**
     * 查询课表根据oid
     * @param page  当前页码
     * @param limit 每页大小
     * @return 数据
     */
    @RequestMapping("queryCourseTablesByOid.do")
    @ResponseBody
    public Map<String,Object> queryCourseTablesByOid(Integer page, Integer limit, Integer oid){
        //获取数据
        List<CourseTable> courseTables = service.findCourseTablesByPageByOid(page,limit,oid);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", courseTables.size());
        res.put("data", courseTables);

        return res;
    }

}
