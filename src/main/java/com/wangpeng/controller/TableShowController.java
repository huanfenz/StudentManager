package com.wangpeng.controller;

import com.wangpeng.service.TableShowService;
import com.wangpeng.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/tableShow")
public class TableShowController {

    @Autowired
    TableShowService service;

    /**
     * 获取课程表
     * @param json 搜索参数的json
     *             {"cid":班级id,"weekno":第几周}
     * @return 课程表的数组
     */
    @RequestMapping({"queryTable.do", "student/queryTable.do"})
    public String[][] queryTable(String json) {
        //获得搜索的参数
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        String year = (String) searchParam.get("year");
        String term = (String) searchParam.get("term");
        int cid = Integer.parseInt((String) searchParam.get("cid"));
        int weekno = Integer.parseInt((String) searchParam.get("weekno"));
        String[][] table = service.findTable(year, term, cid, weekno);
        return table;
    }

}
