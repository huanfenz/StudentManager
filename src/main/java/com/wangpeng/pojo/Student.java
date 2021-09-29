package com.wangpeng.pojo;

import java.util.Date;

public class Student {
    private Integer sid;
    private String sname;
    private String snum;
    private String ssex;
    private Integer sage;
    private Integer cid;
    private String sstatus;
    private String sremark;
    private String idcard;
    private String phone;
    private String address;
    private String entime;
    private String pswd;
    private String cname;

    public Student() {
    }

    public Student(Integer sid, String sname, String snum, String ssex, Integer sage, Integer cid, String sstatus, String sremark, String idcard, String phone, String address, String entime, String pswd, String cname) {
        this.sid = sid;
        this.sname = sname;
        this.snum = snum;
        this.ssex = ssex;
        this.sage = sage;
        this.cid = cid;
        this.sstatus = sstatus;
        this.sremark = sremark;
        this.idcard = idcard;
        this.phone = phone;
        this.address = address;
        this.entime = entime;
        this.pswd = pswd;
        this.cname = cname;
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

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getSstatus() {
        return sstatus;
    }

    public void setSstatus(String sstatus) {
        this.sstatus = sstatus;
    }

    public String getSremark() {
        return sremark;
    }

    public void setSremark(String sremark) {
        this.sremark = sremark;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEntime() {
        return entime;
    }

    public void setEntime(String entime) {
        this.entime = entime;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", snum='" + snum + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sage=" + sage +
                ", cid=" + cid +
                ", sstatu='" + sstatus + '\'' +
                ", sremark='" + sremark + '\'' +
                ", idcard='" + idcard + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", entime=" + entime +
                ", pswd='" + pswd + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }
}
