package com.wangpeng.pojo;

public class Teacher {
    private Integer tid;
    private String tname;
    private String tnum;
    private String tsex;
    private Integer tage;
    private String tstatus;
    private String tremark;
    private String idcard;
    private String phone;
    private String address;
    private String entime;
    private String pswd;

    public Teacher() {
    }

    public Teacher(Integer tid, String tname, String tnum, String tsex, Integer tage, String tstatus, String tremark, String idcard, String phone, String address, String entime, String pswd) {
        this.tid = tid;
        this.tname = tname;
        this.tnum = tnum;
        this.tsex = tsex;
        this.tage = tage;
        this.tstatus = tstatus;
        this.tremark = tremark;
        this.idcard = idcard;
        this.phone = phone;
        this.address = address;
        this.entime = entime;
        this.pswd = pswd;
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

    public String getTnum() {
        return tnum;
    }

    public void setTnum(String tnum) {
        this.tnum = tnum;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public Integer getTage() {
        return tage;
    }

    public void setTage(Integer tage) {
        this.tage = tage;
    }

    public String getTstatus() {
        return tstatus;
    }

    public void setTstatus(String tstatus) {
        this.tstatus = tstatus;
    }

    public String getTremark() {
        return tremark;
    }

    public void setTremark(String tremark) {
        this.tremark = tremark;
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

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", tnum='" + tnum + '\'' +
                ", tsex='" + tsex + '\'' +
                ", tage=" + tage +
                ", tstatus='" + tstatus + '\'' +
                ", tremark='" + tremark + '\'' +
                ", idcard='" + idcard + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", entime='" + entime + '\'' +
                ", pswd='" + pswd + '\'' +
                '}';
    }
}
