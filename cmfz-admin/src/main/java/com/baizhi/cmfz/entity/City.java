package com.baizhi.cmfz.entity;

import java.io.Serializable;

public class City implements Serializable {
    private Integer cid;
    private String cityId;
    private String city;
    private String father;

    public City() {
    }

    public City(Integer cid, String cityId, String city, String father) {
        this.cid = cid;
        this.cityId = cityId;
        this.city = city;
        this.father = father;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    @Override
    public String toString() {
        return "City{" +
                "cid=" + cid +
                ", cityId='" + cityId + '\'' +
                ", city='" + city + '\'' +
                ", father='" + father + '\'' +
                '}';
    }
}
