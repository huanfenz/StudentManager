package com.wangpeng.pojo;

import java.math.BigDecimal;

public class CourseGrade {
    private Integer csid;
    private Integer oid;
    private Integer sid;
    private BigDecimal score;

    public CourseGrade() {
    }

    public CourseGrade(Integer csid, Integer oid, Integer sid, BigDecimal score) {
        this.csid = csid;
        this.oid = oid;
        this.sid = sid;
        this.score = score;
    }

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
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
                "csid=" + csid +
                ", oid=" + oid +
                ", sid=" + sid +
                ", score=" + score +
                '}';
    }
}
