package com.wangpeng.service.impl;

import com.wangpeng.dao.TableShowDao;
import com.wangpeng.pojo.CourseDetail;
import com.wangpeng.service.TableShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableShowServiceImpl implements TableShowService {

    @Autowired
    TableShowDao tableSHowDao;

    @Override
    public String[][] findTable(String year, String term, int cid, int weekno) {

        String[][] res = new String[5][10];

        List<CourseDetail> courseDetails = tableSHowDao.selectCourseDetail(year, term, cid);
        for (CourseDetail courseDetail : courseDetails) {
            String weeknoStr = courseDetail.getWeekno();

            Boolean[] weekFLag = new Boolean[21];   //有的周数置真，否则置假
            for(int i = 0; i < 21; i++) weekFLag[i] = false;    //初始化

            int tmp = 0;
            for(int i = 0; i < weeknoStr.length(); i++) {
                if(weeknoStr.charAt(i) != ',') {    //不是逗号，进tmp
                    tmp = tmp * 10 + (weeknoStr.charAt(i) - '0');
                } else {    //遇到逗号就把tmp送给flag，tmp清零
                    weekFLag[tmp] = true;
                    tmp = 0;
                }
            }
            weekFLag[tmp] = true;   //扫尾

            if(!weekFLag[weekno]) continue; //如果当前周不在该排课周数集合里，那么跳过

            int week = courseDetail.getWeek();  //星期几
            int start = courseDetail.getStart();    //第几节课
            int size = courseDetail.getSize();  //课长
            String courseName = courseDetail.getCourseName();  //课程名
            String rname = courseDetail.getRname(); //教室名
            String tname = courseDetail.getTname(); //教师名

            for(int j = 0; j < size; j++) {
                String str = courseName + "\n@" + rname + "\n" + tname;
                res[week - 1][start + j - 1] = str;
            }
        }

        return res;
    }
}
