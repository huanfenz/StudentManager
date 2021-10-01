package com.wangpeng.pojo;

import java.math.BigDecimal;

public class CourseGrade {
    private Integer cgid;
    private Integer oid;
    private Integer sid;
    private String snum;
    private String sname;
    private BigDecimal score;

    public CourseGrade() {
    }

    public CourseGrade(Integer cgid, Integer oid, Integer sid, String snum, String sname, BigDecimal score) {
        this.cgid = cgid;
        this.oid = oid;
        this.sid = sid;
        this.snum = snum;
        this.sname = sname;
        this.score = score;
    }

    public Integer getCgid() {
        return cgid;
    }

    public void setCgid(Integer cgid) {
        this.cgid = cgid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "CourseGrade{" +
                "cgid=" + cgid +
                ", oid=" + oid +
                ", sid=" + sid +
                ", snum='" + snum + '\'' +
                ", sname='" + sname + '\'' +
                ", score=" + score +
                '}';
    }
}
