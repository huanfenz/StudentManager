package com.wangpeng.service;

import com.wangpeng.pojo.Room;

import java.util.List;
import java.util.Map;

public interface RoomService {

    /**
     * 找所有的教室
     * @return
     */
    List<Room> findAllRooms();

    /**
     * 分页找所有教室
     * @param page
     * @param size
     * @return
     */
    List<Room> findRoomsByPage(int page, int size);

    /**
     * 获取教室总数
     * @return
     */
    int getRoomsCount();

    /**
     * 删除指定教室
     * @param rooms
     * @return 删除成功的数量
     */
    int deleteRooms(List<Room> rooms);

    /**
     * 添加一个教室
     * @param room
     */
    int addRoom(Room room);

    /**
     * 修改一个教室
     * @param room
     * @return
     */
    int updateRoom(Room room);

    /**
     * 搜索教室
     * @param page
     * @param size
     * @param searchParam
     */
    List<Room> searchRooms(Integer page, Integer size, Map<String, Object> searchParam);

    /**
     * 获取搜索的数量
     * @param searchParam
     * @return
     */
    int getSearchCount(Map<String, Object> searchParam);

}
