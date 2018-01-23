package com.zhanglw.java8lambdas.base;

/**
 * Author : zhanglianwei
 * Create : 2018/1/4 22:15
 * Update : 2018/1/4 22:15
 * Descriptions : 曲目
 */
public class Track {

    private final String name;

    private final int length;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public Track copy() {
        return new Track(name, length);
    }
}
