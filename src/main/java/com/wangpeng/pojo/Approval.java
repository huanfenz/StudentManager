package com.wangpeng.pojo;

public class Approval {
    /**
     * 审批id
     */
    private Integer aid;
    /**
     * 学生id
     */
    private Integer sid;
    /**
     * 学生姓名
     */
    private String sname;
    /**
     * 标题
     */
    private String title;
    /**
     * 理由
     */
    private String reason;
    /**
     * 请假类型
     */
    private String type;
    /**
     * 开始日期
     */
    private String sDate;
    /**
     * 结束日期
     */
    private String eDate;
    /**
     * 状态
     */
    private String status;
    /**
     * 附件名
     */
    private String attName;
    /**
     * 附件地址
     */
    private String att;
    /**
     * 回复消息
     */
    private String msg;

    public Approval() {
    }

    public Approval(Integer aid, Integer sid, String sname, String title, String reason, String type, String sDate, String eDate, String status, String attName, String att, String msg) {
        this.aid = aid;
        this.sid = sid;
        this.sname = sname;
        this.title = title;
        this.reason = reason;
        this.type = type;
        this.sDate = sDate;
        this.eDate = eDate;
        this.status = status;
        this.attName = attName;
        this.att = att;
        this.msg = msg;
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

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public String geteDate() {
        return eDate;
    }

    public void seteDate(String eDate) {
        this.eDate = eDate;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
                ", sDate='" + sDate + '\'' +
                ", eDate='" + eDate + '\'' +
                ", status='" + status + '\'' +
                ", attName='" + attName + '\'' +
                ", att='" + att + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
