package com.wangpeng.pojo;

public class Approval {
    private Integer aid;
    private Integer sid;
    private String sname;
    private String title;
    private String type;
    private String time;
    private String status;

    public Approval() {
    }

    public Approval(Integer aid, Integer sid, String sname, String title, String type, String time, String status) {
        this.aid = aid;
        this.sid = sid;
        this.sname = sname;
        this.title = title;
        this.type = type;
        this.time = time;
        this.status = status;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Approval{" +
                "aid=" + aid +
                ", sid=" + sid +
                ", sname='" + sname + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
