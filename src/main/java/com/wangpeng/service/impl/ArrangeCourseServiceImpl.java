package com.wangpeng.service.impl;

import com.wangpeng.dao.ArrangeCourseDao;
import com.wangpeng.dao.RoomDao;
import com.wangpeng.pojo.*;
import com.wangpeng.service.ArrangeCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArrangeCourseServiceImpl implements ArrangeCourseService {

    @Autowired
    ArrangeCourseDao arrangeCourseDao;
    @Autowired
    RoomDao roomDao;

    @Override
    public List<ArrangeCourse> findAllArrangeCourses() {
        return arrangeCourseDao.selectArrangeCourses();
    }

    @Override
    public List<ArrangeCourse> findArrangeCoursesByPage(int page, int size) {
        int begin = (page - 1) * size;
        List<ArrangeCourse> arrangeCourses = arrangeCourseDao.selectArrangeCoursesByLimit(begin, size);
        //放入班级名、教师名、课程名信息
        for(ArrangeCourse arrangeCourse : arrangeCourses) {
            int rid = arrangeCourse.getRid();
            Room room = roomDao.selectRoom(rid);
            arrangeCourse.setRname(room.getRname());
        }
        return arrangeCourses;
    }

    @Override
    public int getArrangeCoursesCount() {
        return arrangeCourseDao.getArrangeCoursesCount();
    }

    @Override
    public int deleteArrangeCourses(List<ArrangeCourse> arrangeCourses) {
        return arrangeCourseDao.deleteArrangeCourses(arrangeCourses);
    }

    @Override
    public int addArrangeCourse(ArrangeCourse arrangeCourse) {
        return arrangeCourseDao.insertArrangeCourse(arrangeCourse);
    }

    @Override
    public int updateArrangeCourse(ArrangeCourse arrangeCourse) {
        return arrangeCourseDao.updateArrangeCourse(arrangeCourse);
    }

    @Override
    public List<ArrangeCourse> findArrangeCoursesByPageByOid(int page, int size, int oid) {
        int begin = (page - 1) * size;
        List<ArrangeCourse> arrangeCourses = arrangeCourseDao.selectArrangeCoursesByLimitByOid(begin, size, oid);
        //放入班级名、教师名、课程名信息
        for(ArrangeCourse arrangeCourse : arrangeCourses) {
            int rid = arrangeCourse.getRid();
            Room room = roomDao.selectRoom(rid);
            arrangeCourse.setRname(room.getRname());
        }
        return arrangeCourses;
    }

}
