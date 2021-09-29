package com.wangpeng.dao;

import com.wangpeng.pojo.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoomDao {
    /**
     * 添加教室
     * @param room
     * @return
     */
    int insertRoom(Room room);

    /**
     * 删除教室
     * @param rooms
     * @return
     */
    int deleteRooms(List<Room> rooms);

    /**
     * 修改教室
     * @param room
     * @return
     */
    int updateRoom(Room room);

    /**
     * 查询所有教室
     * @return
     */
    List<Room> selectRooms();

    /**
     * 根据id查询教室
     * @param id
     * @return
     */
    Room selectRoom(Integer id);

    /**
     * 分页查询教室
     * @param begin 起始索引，从0开始
     * @param size  每页大小
     * @return
     */
    List<Room> selectRoomsByLimit(@Param("begin") int begin, @Param("size")int size);

    /**
     * 获取教室数量
     * @return
     */
    int getRoomsCount();

    /**
     * 分页搜索教室
     * @param map 4个参数，begin,size,mname,mdept
     * @return
     */
    List<Room> searchRoomsByLimit(Map<String,Object> map);

    /**
     * 获取搜索的数量
     * @param map 2个参数，mname,mdept
     * @return
     */
    int getSearchCount(Map<String,Object> map);
}
