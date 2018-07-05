package com.baizhi.cmfz.entity;

import java.io.Serializable;

public class Province implements Serializable {
    private Integer pid;
    private String provinceId;
    private  String province;

    public Province() {
    }

    public Province(Integer pid, String provinceId, String province) {
        this.pid = pid;
        this.provinceId = provinceId;
        this.province = province;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Province{" +
                "pid=" + pid +
                ", provinceId='" + provinceId + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
