package com.wangpeng.controller;

import com.wangpeng.pojo.Room;
import com.wangpeng.service.RoomService;
import com.wangpeng.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService service;

    /**
     * 查询班级
     * @param page  当前页码
     * @param limit 每页大小
     * @return 数据
     */
    @RequestMapping("queryRooms.do")
    public Map<String,Object> queryRooms(Integer page, Integer limit){
        //获取班级数量
        int count = service.getRoomsCount();
        //获取数据
        List<Room> rooms = service.findRoomsByPage(page,limit);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", rooms);

        return res;
    }

    /**
     * 查询所有班级
     * @return
     */
    @RequestMapping({"queryAllRooms.do", "teacher/queryAllRooms.do"})
    public List<Room> queryAllRooms(){
        return service.findAllRooms();
    }

    /**
     * 删除班级
     * @param json
     * @return 返回成功的行数
     */
    @RequestMapping("deleteRooms.do")
    public Integer deleteRooms(String json){
        if(json.charAt(0) != '[') json = '[' + json + ']';  //如果不是数组形式，变成数组形式
        List<Room> rooms = JsonUtil.parseList(json, Room.class);
        return service.deleteRooms(rooms);
    }

    /**
     * 添加一个班级
     * @param json
     * @return 成功标志1
     */
    @RequestMapping("addRoom.do")
    public Integer addRoom(String json){
        Room room = JsonUtil.parseObject(json, Room.class);
        return service.addRoom(room);
    }

    /**
     * 修改一个班级
     * @param json
     * @return 成功标志1
     */
    @RequestMapping("updateRoom.do")
    public Integer updateRoom(String json){
        Room room = JsonUtil.parseObject(json, Room.class);
        return service.updateRoom(room);
    }

    /**
     * 获取班级总数
     * @return
     * @throws IOException
     */
    @RequestMapping("getAmount.do")
    public Integer getAmount() {
        return service.getRoomsCount();
    }

    @RequestMapping("searchRooms.do")
    public Map<String,Object> searchRooms(Integer page, Integer limit, String json){
        //获得搜索的参数
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        //获取查询个数
        int count = service.getSearchCount(searchParam);
        //查询数据
        List<Room> rooms = service.searchRooms(page, limit, searchParam);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", rooms);
        return res;
    }

}
