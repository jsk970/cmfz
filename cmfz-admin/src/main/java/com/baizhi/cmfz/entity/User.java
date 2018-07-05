package com.baizhi.cmfz.entity;

import java.io.Serializable;

public class User implements Serializable {
    private String tel;
    private String password;
    private String salt;
    private String headPic;
    private String legalName;
    private String name;
    private String sex;
    private String local;
    private String signature;//签名
    private String guruId;

    public User() {
    }

    public User(String tel, String password, String salt, String headPic, String legalName, String name, String sex, String local, String signature, String guruId) {
        this.tel = tel;
        this.password = password;
        this.salt = salt;
        this.headPic = headPic;
        this.legalName = legalName;
        this.name = name;
        this.sex = sex;
        this.local = local;
        this.signature = signature;
        this.guruId = guruId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    @Override
    public String toString() {
        return "User{" +
                "tel='" + tel + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", headPic='" + headPic + '\'' +
                ", legalName='" + legalName + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", local='" + local + '\'' +
                ", signature='" + signature + '\'' +
                ", guruId='" + guruId + '\'' +
                '}';
    }
}
