package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-08 18:17
 */
public class Context implements Serializable {
    private int errno;
    private List<String> data;

    public Context() {
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Context{" +
                "errno=" + errno +
                ", data=" + data +
                '}';
    }
}
