package com.wangpeng.pojo;

public class Teacher {
    /**
     * 教师id
     */
    private Integer tid;
    /**
     * 教师名
     */
    private String tname;
    /**
     * 教师职工号
     */
    private String tnum;
    /**
     * 性别
     */
    private String tsex;
    /**
     * 年龄
     */
    private Integer tage;
    /**
     * 状态
     */
    private String tstatus;
    /**
     * 备注
     */
    private String tremark;
    /**
     * 身份证号
     */
    private String idcard;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 地址
     */
    private String address;
    /**
     * 入职时间
     */
    private String entime;
    /**
     * 密码
     */
    private String pswd;
    /**
     * 照片地址
     */
    private String pic;

    public Teacher() {
    }

    public Teacher(Integer tid, String tname, String tnum, String tsex, Integer tage, String tstatus, String tremark, String idcard, String phone, String address, String entime, String pswd, String pic) {
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
        this.pic = pic;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
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
                ", pic='" + pic + '\'' +
                '}';
    }
}
