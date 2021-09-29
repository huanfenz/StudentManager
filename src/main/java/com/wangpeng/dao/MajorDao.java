package com.wangpeng.dao;

import com.wangpeng.pojo.Major;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MajorDao {
    /**
     * 添加专业
     * @param major
     * @return
     */
    int insertMajor(Major major);

    /**
     * 删除专业
     * @param majors
     * @return
     */
    int deleteMajors(List<Major> majors);

    /**
     * 修改专业
     * @param major
     * @return
     */
    int updateMajor(Major major);

    /**
     * 查询所有专业
     * @return
     */
    List<Major> selectMajors();

    /**
     * 根据id查询专业
     * @param id
     * @return
     */
    Major selectMajor(Integer id);

    /**
     * 分页查询专业
     * @param begin 起始索引，从0开始
     * @param size  每页大小
     * @return
     */
    List<Major> selectMajorsByLimit(@Param("begin") int begin, @Param("size")int size);

    /**
     * 获取专业数量
     * @return
     */
    int getMajorsCount();

    /**
     * 分页搜索专业
     * @param map 4个参数，begin,size,mname,mdept
     * @return
     */
    List<Major> searchMajorsByLimit(Map<String,Object> map);

    /**
     * 获取搜索的数量
     * @param map 2个参数，mname,mdept
     * @return
     */
    int getSearchCount(Map<String,Object> map);
}
