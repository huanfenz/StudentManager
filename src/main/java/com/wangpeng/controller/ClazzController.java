package com.wangpeng.controller;

import com.wangpeng.pojo.Clazz;
import com.wangpeng.pojo.Teacher;
import com.wangpeng.service.ClazzService;
import com.wangpeng.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clazz")
public class ClazzController {

    @Autowired
    ClazzService service;

    /**
     * 查询班级
     * @param page 当前页码
     * @param limit 每页大小
     * @return 班级信息
     */
    @RequestMapping("queryClazzs.do")
    public Map<String,Object> queryClazzs(Integer page, Integer limit){
        //获取数量
        int count = service.getAmount();
        //获取数据
        List<Clazz> clazzs = service.queryClazzs(page, limit);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", clazzs);
        return res;
    }

    /**
     * 查询所有班级
     * @return 班级信息
     */
    @RequestMapping({"queryAllClazzs.do", "student/queryAllClazzs.do"})
    public List<Clazz> queryAllClazzs(){
        List<Clazz> clazzes = service.queryAllClazzs();
        return clazzes;
    }

    /**
     * 根据教师查询所有班级
     * @param req HttpServletRequest
     * @return
     */
    @RequestMapping("teacher/queryAllClazzsByTeacher.do")
    public List<Clazz> queryAllClazzsByTeacher(HttpServletRequest req){
        //获取当前账号信息
        Teacher loginTeacher =  (Teacher) req.getSession().getAttribute("loginObj");

        List<Clazz> clazzes = service.queryAllClazzsByTeacher(loginTeacher.getTid());
        return clazzes;
    }

    /**
     * 删除班级
     * @param json 班级对象的json
     * @return 成功行数
     */
    @RequestMapping("deleteClazzs.do")
    public Integer deleteClazzs(String json){
        if(json.charAt(0) != '[') json = '[' + json + ']';  //如果不是数组形式，变成数组形式
        List<Clazz> clazzs = JsonUtil.parseList(json, Clazz.class);
        int count = service.deleteClazzs(clazzs);   //得到删除成功的数量
        return count;
    }

    /**
     * 添加一个班级
     * @param json 班级对象的json
     * @return 成功标志1
     */
    @RequestMapping("addClazz.do")
    public Integer addClazz(String json){
        Clazz clazz = JsonUtil.parseObject(json, Clazz.class);
        int num = service.addClazz(clazz);
        return num;
    }

    /**
     * 修改一个班级
     * @param json 班级对象的json
     * @return 成功标志1
     */
    @RequestMapping("updateClazz.do")
    public Integer updateClazz(String json){
        Clazz clazz = JsonUtil.parseObject(json, Clazz.class);
        int num = service.updateClazz(clazz);
        return num;
    }

    /**
     * 获取班级总数
     * @return 班级总数
     */
    @RequestMapping("getAmount.do")
    public Integer getAmount() {
        int res = service.getAmount();
        return res;
    }

    /**
     * 搜索班级
     * @param page 当前页码
     * @param limit 每页大小
     * @param json 搜索参数的json
     *             {"cname": 班级名, "mid": 专业id}
     * @return 班级信息
     */
    @RequestMapping("searchClazzs.do")
    public Map<String,Object> searchClazzs(Integer page, Integer limit, String json){
        //获得搜索的参数
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        //获取查询个数
        int count = service.getSearchCount(searchParam);
        //查询数据
        List<Clazz> clazzes = service.searchClazzs(page, limit, searchParam);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", clazzes);
        return res;
    }
}
