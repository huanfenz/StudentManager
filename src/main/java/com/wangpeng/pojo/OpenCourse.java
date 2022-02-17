package com.wangpeng.pojo;

public class OpenCourse {
    /**
     * 开课id
     */
    private Integer oid;
    /**
     * 学年
     */
    private String year;
    /**
     * 学期
     */
    private String term;
    /**
     * 课程id
     */
    private Integer cid;
    /**
     * 课程名
     */
    private String cname;
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

    public OpenCourse() {
    }

    public OpenCourse(Integer oid, String year, String term, Integer cid, String cname, Integer tid, String tname, Integer courseId, String courseName, String remark) {
        this.oid = oid;
        this.year = year;
        this.term = term;
        this.cid = cid;
        this.cname = cname;
        this.tid = tid;
        this.tname = tname;
        this.courseId = courseId;
        this.courseName = courseName;
        this.remark = remark;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
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

    @Override
    public String toString() {
        return "OpenCourse{" +
                "oid=" + oid +
                ", year='" + year + '\'' +
                ", term='" + term + '\'' +
                ", cid=" + cid +
                ", cname='" + cname + '\'' +
                ", tid=" + tid +
                ", tname='" + tname + '\'' +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
