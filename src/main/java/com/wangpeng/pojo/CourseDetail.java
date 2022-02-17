package com.wangpeng.pojo;

public class CourseDetail {
    /**
     * 唯一排课id
     */
    private Integer ctid;
    /**
     * 哪几周上课
     */
    private String weekno;
    /**
     * 星期几
     */
    private Integer week;
    /**
     * 第几节课
     */
    private Integer start;
    /**
     * 课长
     *
     */
    private Integer size;
    /**
     * 课程名
     */
    private String courseName;
    /**
     * 教室名
     */
    private String rname;
    /**
     * 教师名
     */
    private String tname;

    public CourseDetail() {
    }

    public CourseDetail(Integer ctid, String weekno, Integer week, Integer start, Integer size, String courseName, String rname, String tname) {
        this.ctid = ctid;
        this.weekno = weekno;
        this.week = week;
        this.start = start;
        this.size = size;
        this.courseName = courseName;
        this.rname = rname;
        this.tname = tname;
    }

    public Integer getCtid() {
        return ctid;
    }

    public void setCtid(Integer ctid) {
        this.ctid = ctid;
    }

    public String getWeekno() {
        return weekno;
    }

    public void setWeekno(String weekno) {
        this.weekno = weekno;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "CourseDetail{" +
                "ctid=" + ctid +
                ", weekno='" + weekno + '\'' +
                ", week=" + week +
                ", start=" + start +
                ", size=" + size +
                ", courseName='" + courseName + '\'' +
                ", rname='" + rname + '\'' +
                ", tname='" + tname + '\'' +
                '}';
    }
}
