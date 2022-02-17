package com.wangpeng.pojo;

public class Major {
    /**
     * 专业id
     */
    private Integer mid;
    /**
     * 专业名
     */
    private String mname;
    /**
     * 专业所属院系
     */
    private String mdept;
    /**
     * 备注
     */
    private String mremark;

    public Major() {
    }

    public Major(Integer mid, String mname, String mdept, String mremark) {
        this.mid = mid;
        this.mname = mname;
        this.mdept = mdept;
        this.mremark = mremark;
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

    public String getMdept() {
        return mdept;
    }

    public void setMdept(String mdept) {
        this.mdept = mdept;
    }

    public String getMremark() {
        return mremark;
    }

    public void setMremark(String mremark) {
        this.mremark = mremark;
    }

    @Override
    public String toString() {
        return "Major{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                ", mdept='" + mdept + '\'' +
                ", mremark='" + mremark + '\'' +
                '}';
    }
}
