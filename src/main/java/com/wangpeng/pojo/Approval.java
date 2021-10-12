package com.wangpeng.pojo;

public class Approval {
    private Integer aid;
    private Integer sid;
    private String sname;
    private String title;
    private String reason;
    private String type;
    private String time;
    private String status;
    private String attName;
    private String att;

    public Approval() {
    }

    public Approval(Integer aid, Integer sid, String sname, String title, String reason, String type, String time, String status, String attName, String att) {
        this.aid = aid;
        this.sid = sid;
        this.sname = sname;
        this.title = title;
        this.reason = reason;
        this.type = type;
        this.time = time;
        this.status = status;
        this.attName = attName;
        this.att = att;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public String getAttName() {
        return attName;
    }

    public void setAttName(String attName) {
        this.attName = attName;
    }

    public String getAtt() {
        return att;
    }

    public void setAtt(String att) {
        this.att = att;
    }

    @Override
    public String toString() {
        return "Approval{" +
                "aid=" + aid +
                ", sid=" + sid +
                ", sname='" + sname + '\'' +
                ", title='" + title + '\'' +
                ", reason='" + reason + '\'' +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                ", attName='" + attName + '\'' +
                ", att='" + att + '\'' +
                '}';
    }
}
