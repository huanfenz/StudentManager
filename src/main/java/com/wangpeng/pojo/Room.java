package com.wangpeng.pojo;

public class Room {
    /**
     * 教室id
     */
    private Integer rid;
    /**
     * 教室名
     */
    private String rname;
    /**
     * 容量
     */
    private Integer capacity;
    /**
     * 备注
     */
    private String remark;

    public Room() {
    }

    public Room(Integer rid, String rname, Integer capacity, String remark) {
        this.rid = rid;
        this.rname = rname;
        this.capacity = capacity;
        this.remark = remark;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Room{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", capacity=" + capacity +
                ", remark='" + remark + '\'' +
                '}';
    }
}
