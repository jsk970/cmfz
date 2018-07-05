package com.baizhi.cmfz.entity;

import java.util.List;

public class Menu {
    private Integer id;
    private String menuName;
    private String menuCode;
    private String MenuIcon;
    private String menuUrl;
    private String menuLevel;
    private String menuParentId;
    private List<Menu> Menulist;

    public Menu() {
    }

    public Menu(Integer id, String menuName, String menuCode, String menuIcon, String menuUrl, String menuLevel, String menuParentId, List<Menu> menulist) {
        this.id = id;
        this.menuName = menuName;
        this.menuCode = menuCode;
        MenuIcon = menuIcon;
        this.menuUrl = menuUrl;
        this.menuLevel = menuLevel;
        this.menuParentId = menuParentId;
        Menulist = menulist;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuIcon() {
        return MenuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        MenuIcon = menuIcon;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(String menuParentId) {
        this.menuParentId = menuParentId;
    }

    public List<Menu> getMenulist() {
        return Menulist;
    }

    public void setMenulist(List<Menu> menulist) {
        Menulist = menulist;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", menuCode='" + menuCode + '\'' +
                ", MenuIcon='" + MenuIcon + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuLevel='" + menuLevel + '\'' +
                ", menuParentId='" + menuParentId + '\'' +
                ", Menulist=" + Menulist +
                '}';
    }
}
