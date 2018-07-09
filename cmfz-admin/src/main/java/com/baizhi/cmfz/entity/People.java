package com.baizhi.cmfz.entity;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-09 14:52
 */
public class People {
    private String name;
    private int value;

    public People() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
