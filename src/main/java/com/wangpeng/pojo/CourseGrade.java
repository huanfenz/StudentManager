package com.wangpeng.pojo;

import java.math.BigDecimal;

public class CourseGrade {
    private Integer cgid;
    private Integer oid;
    private Integer sid;
    private BigDecimal score;

    public CourseGrade() {
    }

    public CourseGrade(Integer cgid, Integer oid, Integer sid, BigDecimal score) {
        this.cgid = cgid;
        this.oid = oid;
        this.sid = sid;
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
                ", score=" + score +
                '}';
    }
}
