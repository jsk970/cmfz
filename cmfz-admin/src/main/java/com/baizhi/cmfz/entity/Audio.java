package com.baizhi.cmfz.entity;

import java.io.Serializable;

public class Audio implements Serializable {
    private Integer id;
    private String name;
    private String audioPath;
    private Integer albumId;
    private String size;

    public Audio() {
    }

    public Audio(Integer id, String name, String audioPath, Integer albumId, String size) {
        this.id = id;
        this.name = name;
        this.audioPath = audioPath;
        this.albumId = albumId;
        this.size = size;
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

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", audioPath='" + audioPath + '\'' +
                ", albumId=" + albumId +
                ", size='" + size + '\'' +
                '}';
    }
}
