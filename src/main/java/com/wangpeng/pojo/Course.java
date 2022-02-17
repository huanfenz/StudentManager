package com.wangpeng.pojo;

public class Course {
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
    private String courseRemark;

    public Course() {
    }

    public Course(Integer courseId, String courseName, String courseRemark) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseRemark = courseRemark;
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

    public String getCourseRemark() {
        return courseRemark;
    }

    public void setCourseRemark(String courseRemark) {
        this.courseRemark = courseRemark;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseRemark='" + courseRemark + '\'' +
                '}';
    }
}
