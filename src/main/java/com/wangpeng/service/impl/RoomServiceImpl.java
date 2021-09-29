package com.wangpeng.service.impl;

import com.wangpeng.dao.RoomDao;
import com.wangpeng.pojo.Room;
import com.wangpeng.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomDao roomDao;

    @Override
    public List<Room> findAllRooms() {
        return roomDao.selectRooms();
    }

    @Override
    public List<Room> findRoomsByPage(int page, int size) {
        int begin = (page - 1) * size;
        return roomDao.selectRoomsByLimit(begin,size);
    }

    @Override
    public int getRoomsCount() {
        return roomDao.getRoomsCount();
    }

    @Override
    public int deleteRooms(List<Room> rooms) {
        return roomDao.deleteRooms(rooms);
    }

    @Override
    public int addRoom(Room room) {
        return roomDao.insertRoom(room);
    }

    @Override
    public int updateRoom(Room room) {
        return roomDao.updateRoom(room);
    }

    @Override
    public List<Room> searchRooms(Integer page, Integer size, Map<String, Object> searchParam) {
        int begin = (page - 1) * size;
        //在搜索的基础上添加2个参数
        Map<String,Object> map = searchParam;
        map.put("begin", begin);
        map.put("size", size);
        List<Room> rooms = roomDao.searchRoomsByLimit(map);
        return rooms;
    }

    @Override
    public int getSearchCount(Map<String, Object> searchParam) {
        return roomDao.getSearchCount(searchParam);
    }

}
