package com.zhanglw.java8lambdas.base;

import java.util.List;

/**
 * Author : zhanglianwei
 * Create : 2018/1/5 16:05
 * Update : 2018/1/5 16:05
 * Descriptions : 专辑
 */
public class Album {

    /**
     * 专辑名
     */
    private String name;

    /**
     * 曲目列表
     */
    private List<Track> tracks;

    /**
     * 艺术家
     */
    private List<Artist> musicians;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<Artist> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<Artist> musicians) {
        this.musicians = musicians;
    }
}
