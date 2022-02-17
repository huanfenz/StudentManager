package com.wangpeng.pojo;

public class ArrangeCourse {
    /**
     * 排课id
     */
    private Integer ctid;
    /**
     * 开课id
     */
    private Integer oid;
    /**
     * 教室id
     */
    private Integer rid;
    /**
     * 教师名
     */
    private String rname;
    /**
     * 星期几
     */
    private String weekno;
    /**
     * 周数
     */
    private Integer week;
    /**
     * 开始节数
     */
    private Integer start;
    /**
     * 课程长度
     */
    private Integer size;

    public ArrangeCourse() {
    }

    public ArrangeCourse(Integer ctid, Integer oid, Integer rid, String rname, String weekno, Integer week, Integer start, Integer size) {
        this.ctid = ctid;
        this.oid = oid;
        this.rid = rid;
        this.rname = rname;
        this.weekno = weekno;
        this.week = week;
        this.start = start;
        this.size = size;
    }

    public Integer getCtid() {
        return ctid;
    }

    public void setCtid(Integer ctid) {
        this.ctid = ctid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
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

    @Override
    public String toString() {
        return "ArrangeCourse{" +
                "ctid=" + ctid +
                ", oid=" + oid +
                ", rid=" + rid +
                ", rname='" + rname + '\'' +
                ", weekno='" + weekno + '\'' +
                ", week=" + week +
                ", start=" + start +
                ", size=" + size +
                '}';
    }
}
