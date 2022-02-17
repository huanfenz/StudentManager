package com.wangpeng.controller;

import com.wangpeng.pojo.Major;
import com.wangpeng.service.MajorService;
import com.wangpeng.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/major")
public class MajorController {

    @Autowired
    MajorService service;

    /**
     * 查询专业
     * @param page  当前页码
     * @param limit 每页大小
     * @return 专业信息
     */
    @RequestMapping("queryMajors.do")
    public Map<String,Object> queryMajors(Integer page, Integer limit){
        //获取专业数量
        int count = service.getMajorsCount();
        //获取数据
        List<Major> majors = service.findMajorsByPage(page,limit);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", majors);

        return res;
    }

    /**
     * 查询所有专业
     * @return 专业信息
     */
    @RequestMapping("queryAllMajors.do")
    public List<Major> queryAllMajors(){
        return service.findAllMajors();
    }

    /**
     * 删除专业
     * @param json 专业对象的json
     * @return 成功行数
     */
    @RequestMapping("deleteMajors.do")
    public Integer deleteMajors(String json){
        if(json.charAt(0) != '[') json = '[' + json + ']';  //如果不是数组形式，变成数组形式
        List<Major> majors = JsonUtil.parseList(json, Major.class);
        return service.deleteMajors(majors);
    }

    /**
     * 添加一个专业
     * @param json 专业对象的json
     * @return 成功标志1
     */
    @RequestMapping("addMajor.do")
    public Integer addMajor(String json){
        Major major = JsonUtil.parseObject(json, Major.class);
        return service.addMajor(major);
    }

    /**
     * 修改一个专业
     * @param json 专业对象的json
     * @return 成功标志1
     */
    @RequestMapping("updateMajor.do")
    public Integer updateMajor(String json){
        Major major = JsonUtil.parseObject(json, Major.class);
        return service.updateMajor(major);
    }

    /**
     * 获取专业总数
     * @return 专业总数
     */
    @RequestMapping("getAmount.do")
    public Integer getAmount() {
        return service.getMajorsCount();
    }

    /**
     * 搜索专业
     * @param page 当前页码
     * @param limit 每页大小
     * @param json 搜索参数的json
     *             {"mname": 专业名, "mdept": 学院名}
     * @return 专业信息
     */
    @RequestMapping("searchMajors.do")
    public Map<String,Object> searchMajors(Integer page, Integer limit, String json){
        //获得搜索的参数
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        //获取查询个数
        int count = service.getSearchCount(searchParam);
        //查询数据
        List<Major> majors = service.searchMajors(page, limit, searchParam);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", majors);
        return res;
    }

}
