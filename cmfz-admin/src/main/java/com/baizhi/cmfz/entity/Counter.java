package com.baizhi.cmfz.entity;

import java.io.Serializable;

public class Counter implements Serializable {
    private Integer id;
    private String name;
    private String createDate;
    private String count;
    private Integer categoryId;

    public Counter() {
    }

    public Counter(Integer id, String name, String createDate, String count, Integer categoryId) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.count = count;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate='" + createDate + '\'' +
                ", count='" + count + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
