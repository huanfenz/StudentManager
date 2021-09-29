package com.wangpeng.pojo;

public class CourseTable {
    private Integer ctid;
    private Integer oid;
    private Integer rid;
    private String rname;
    private String weekno;
    private Integer week;
    private Integer start;
    private Integer size;

    public CourseTable() {
    }

    public CourseTable(Integer ctid, Integer oid, Integer rid, String rname, String weekno, Integer week, Integer start, Integer size) {
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
        return "CourseTable{" +
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
