package com.wangpeng.pojo;

public class Clazz {
    /**
     * 班级id
     */
    private Integer cid;
    /**
     * 班级名
     */
    private String cname;
    /**
     * 专业id
     */
    private Integer mid;
    /**
     * 专业名
     */
    private String mname;
    /**
     * 备注
     */
    private String cremark;

    public Clazz() {
    }

    public Clazz(Integer cid, String cname, Integer mid, String mname, String cremark) {
        this.cid = cid;
        this.cname = cname;
        this.mid = mid;
        this.mname = mname;
        this.cremark = cremark;
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

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getCremark() {
        return cremark;
    }

    public void setCremark(String cremark) {
        this.cremark = cremark;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", mid=" + mid +
                ", mname='" + mname + '\'' +
                ", cremark='" + cremark + '\'' +
                '}';
    }
}
