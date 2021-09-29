package com.wangpeng.service.impl;

import com.wangpeng.dao.ManagerDao;
import com.wangpeng.pojo.Manager;
import com.wangpeng.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerDao managerDao;

    @Override
    public List<Manager> findAllManagers() {
        return managerDao.selectManagers();
    }

    @Override
    public List<Manager> findManagersByPage(int page, int size) {
        int begin = (page - 1) * size;
        return managerDao.selectManagersByLimit(begin,size);
    }

    @Override
    public int getManagersCount() {
        return managerDao.getManagersCount();
    }

    @Override
    public int deleteManagers(List<Manager> managers) {
        return managerDao.deleteManagers(managers);
    }

    @Override
    public int addManager(Manager manager) {
        return managerDao.insertManager(manager);
    }

    @Override
    public int updateManager(Manager manager) {
        return managerDao.updateManager(manager);
    }

    @Override
    public List<Manager> searchManagers(Integer page, Integer size, Map<String, Object> searchParam) {
        int begin = (page - 1) * size;
        //在搜索的基础上添加2个参数
        Map<String,Object> map = searchParam;
        map.put("begin", begin);
        map.put("size", size);
        List<Manager> managers = managerDao.searchManagersByLimit(map);
        return managers;
    }

    @Override
    public int getSearchCount(Map<String, Object> searchParam) {
        return managerDao.getSearchCount(searchParam);
    }

}
