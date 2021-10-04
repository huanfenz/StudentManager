package com.wangpeng.pojo;

public class OpenCourseAndScore {
    private String year;
    private String term;
    private Integer tid;
    private String tname;
    private Integer courseId;
    private String courseName;
    private String remark;
    private Integer score;

    public OpenCourseAndScore() {
    }

    public OpenCourseAndScore(String year, String term, Integer tid, String tname, Integer courseId, String courseName, String remark, Integer score) {
        this.year = year;
        this.term = term;
        this.tid = tid;
        this.tname = tname;
        this.courseId = courseId;
        this.courseName = courseName;
        this.remark = remark;
        this.score = score;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "OpenCourseAndScore{" +
                "year='" + year + '\'' +
                ", term='" + term + '\'' +
                ", tid=" + tid +
                ", tname='" + tname + '\'' +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", remark='" + remark + '\'' +
                ", score=" + score +
                '}';
    }
}
