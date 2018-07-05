package com.baizhi.cmfz.entity;

import java.io.Serializable;

public class Category implements Serializable {
    private Integer id;
    private String categoryName;
    private String flag;
    private Integer userId;

    public Category() {
    }

    public Category(Integer id, String categoryName, String flag, Integer userId) {
        this.id = id;
        this.categoryName = categoryName;
        this.flag = flag;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", flag='" + flag + '\'' +
                ", userId=" + userId +
                '}';
    }
}
