package com.wangpeng.service.impl;

import com.wangpeng.dao.MajorDao;
import com.wangpeng.pojo.Major;
import com.wangpeng.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    MajorDao majorDao;

    @Override
    public List<Major> findAllMajors() {
        return majorDao.selectMajors();
    }

    @Override
    public List<Major> findMajorsByPage(int page, int size) {
        int begin = (page - 1) * size;
        return majorDao.selectMajorsByLimit(begin,size);
    }

    @Override
    public int getMajorsCount() {
        return majorDao.getMajorsCount();
    }

    @Override
    public int deleteMajors(List<Major> majors) {
        return majorDao.deleteMajors(majors);
    }

    @Override
    public int addMajor(Major major) {
        return majorDao.insertMajor(major);
    }

    @Override
    public int updateMajor(Major major) {
        return majorDao.updateMajor(major);
    }

    @Override
    public List<Major> searchMajors(Integer page, Integer size, Map<String, Object> searchParam) {
        int begin = (page - 1) * size;
        //在搜索的基础上添加2个参数
        Map<String,Object> map = searchParam;
        map.put("begin", begin);
        map.put("size", size);
        List<Major> majors = majorDao.searchMajorsByLimit(map);
        return majors;
    }

    @Override
    public int getSearchCount(Map<String, Object> searchParam) {
        return majorDao.getSearchCount(searchParam);
    }

}
