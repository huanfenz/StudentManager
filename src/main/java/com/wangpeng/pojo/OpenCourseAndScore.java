package com.wangpeng.pojo;

public class OpenCourseAndScore extends OpenCourse {

    /**
     * 分数
     */
    private Integer score;

    public OpenCourseAndScore(Integer score) {
        this.score = score;
    }

    public OpenCourseAndScore(Integer oid, String year, String term, Integer cid, String cname, Integer tid, String tname, Integer courseId, String courseName, String remark, Integer score) {
        super(oid, year, term, cid, cname, tid, tname, courseId, courseName, remark);
        this.score = score;
    }

    public OpenCourseAndScore() {
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
                "score=" + score +
                '}';
    }
}
