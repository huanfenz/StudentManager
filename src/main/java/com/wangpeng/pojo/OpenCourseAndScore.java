package com.wangpeng.pojo;

public class OpenCourseAndScore {
    /**
     * 学年
     */
    private String year;
    /**
     * 学期
     */
    private String term;
    /**
     * 教师id
     */
    private Integer tid;
    /**
     * 教师名
     */
    private String tname;
    /**
     * 课程id
     */
    private Integer courseId;
    /**
     * 课程名
     */
    private String courseName;
    /**
     * 备注
     */
    private String remark;
    /**
     * 分数
     */
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
