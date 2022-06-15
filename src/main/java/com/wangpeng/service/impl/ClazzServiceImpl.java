package com.wangpeng.service.impl;

import com.wangpeng.dao.ClazzDao;
import com.wangpeng.dao.MajorDao;
import com.wangpeng.pojo.Clazz;
import com.wangpeng.pojo.Major;
import com.wangpeng.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    ClazzDao clazzDao;

    @Autowired
    MajorDao majorDao;

    /**
     * 为班级列表添加专业名
     * @param clazzes
     */
    private void addMajorNameForClazzes(List<Clazz> clazzes) {
        for(Clazz clazz : clazzes) {
            Integer mid = clazz.getMid();
            if (mid != null) {
                Major major = majorDao.selectMajor(mid);
                if (major != null) {
                    clazz.setMname(major.getMname());
                }
            }
        }
    }

    @Override
    public List<Clazz> queryClazzs(int page, int size) {
        int begin = (page - 1) * size;
        List<Clazz> clazzes = clazzDao.selectClazzsByLimit(begin, size);
        //添加专业名信息
        addMajorNameForClazzes(clazzes);
        return clazzes;
    }

    @Override
    public int getAmount() {
        return clazzDao.getClazzsCount();
    }

    @Override
    public int deleteClazzs(List<Clazz> clazzs) {
        return clazzDao.deleteClazzs(clazzs);
    }

    @Override
    public int addClazz(Clazz clazz) {
        return clazzDao.insertClazz(clazz);
    }

    @Override
    public int updateClazz(Clazz clazz) {
        return clazzDao.updateClazz(clazz);
    }

    @Override
    public List<Clazz> searchClazzs(Integer page, Integer size, Map<String, Object> searchParam) {
        int begin = (page - 1) * size;
        //在搜索的基础上添加2个参数
        Map<String,Object> map = searchParam;
        map.put("begin", begin);
        map.put("size", size);
        List<Clazz> clazzes = clazzDao.searchClazzsByLimit(map);
        //添加专业名信息
        addMajorNameForClazzes(clazzes);
        return clazzes;
    }

    @Override
    public int getSearchCount(Map<String, Object> searchParam) {
        return clazzDao.getSearchCount(searchParam);
    }

    @Override
    public List<Clazz> queryAllClazzs() {
        return clazzDao.selectClazzs();
    }

    @Override
    public List<Clazz> queryAllClazzsByTeacher(int tid) {
        return clazzDao.getCLazzsByTeacher(tid);
    }

}
