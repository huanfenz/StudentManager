package com.wangpeng.pojo;

public class Student {
    /**
     * 学生id
     */
    private Integer sid;
    /**
     * 学生姓名
     */
    private String sname;
    /**
     * 学号
     */
    private String snum;
    /**
     * 性别
     */
    private String ssex;
    /**
     * 年龄
     */
    private Integer sage;
    /**
     * 班级id
     */
    private Integer cid;
    /**
     * 班级名
     */
    private String cname;
    /**
     * 状态
     */
    private String sstatus;
    /**
     * 备注
     */
    private String sremark;
    /**
     * 身份证号
     */
    private String idcard;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 家庭住址
     */
    private String address;
    /**
     * 进入时间
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

    public Student() {
    }

    public Student(Integer sid, String sname, String snum, String ssex, Integer sage, Integer cid, String cname, String sstatus, String sremark, String idcard, String phone, String address, String entime, String pswd, String pic) {
        this.sid = sid;
        this.sname = sname;
        this.snum = snum;
        this.ssex = ssex;
        this.sage = sage;
        this.cid = cid;
        this.cname = cname;
        this.sstatus = sstatus;
        this.sremark = sremark;
        this.idcard = idcard;
        this.phone = phone;
        this.address = address;
        this.entime = entime;
        this.pswd = pswd;
        this.pic = pic;
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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
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
                ", cname='" + cname + '\'' +
                ", sstatus='" + sstatus + '\'' +
                ", sremark='" + sremark + '\'' +
                ", idcard='" + idcard + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", entime='" + entime + '\'' +
                ", pswd='" + pswd + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
