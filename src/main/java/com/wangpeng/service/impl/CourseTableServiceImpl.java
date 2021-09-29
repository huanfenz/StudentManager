package com.wangpeng.service.impl;

import com.wangpeng.dao.CourseTableDao;
import com.wangpeng.dao.RoomDao;
import com.wangpeng.pojo.*;
import com.wangpeng.service.CourseTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CourseTableServiceImpl implements CourseTableService {

    @Autowired
    CourseTableDao courseTableDao;
    @Autowired
    RoomDao roomDao;

    @Override
    public List<CourseTable> findAllCourseTables() {
        return courseTableDao.selectCourseTables();
    }

    @Override
    public List<CourseTable> findCourseTablesByPage(int page, int size) {
        int begin = (page - 1) * size;
        List<CourseTable> courseTables = courseTableDao.selectCourseTablesByLimit(begin, size);
        List<CourseTable> res = new ArrayList<>();
        //放入班级名、教师名、课程名信息
        for(CourseTable courseTable : courseTables) {
            int rid = courseTable.getRid();
            Room room = roomDao.selectRoom(rid);
            courseTable.setRname(room.getRname());
            res.add(courseTable);
        }
        return res;
    }

    @Override
    public int getCourseTablesCount() {
        return courseTableDao.getCourseTablesCount();
    }

    @Override
    public int deleteCourseTables(List<CourseTable> courseTables) {
        return courseTableDao.deleteCourseTables(courseTables);
    }

    @Override
    public int addCourseTable(CourseTable courseTable) {
        return courseTableDao.insertCourseTable(courseTable);
    }

    @Override
    public int updateCourseTable(CourseTable courseTable) {
        return courseTableDao.updateCourseTable(courseTable);
    }

    @Override
    public List<CourseTable> findCourseTablesByPageByOid(int page, int size, int oid) {
        int begin = (page - 1) * size;
        List<CourseTable> courseTables = courseTableDao.selectCourseTablesByLimitByOid(begin, size, oid);
        List<CourseTable> res = new ArrayList<>();
        //放入班级名、教师名、课程名信息
        for(CourseTable courseTable : courseTables) {
            int rid = courseTable.getRid();
            Room room = roomDao.selectRoom(rid);
            courseTable.setRname(room.getRname());
            res.add(courseTable);
        }
        return res;
    }

}
