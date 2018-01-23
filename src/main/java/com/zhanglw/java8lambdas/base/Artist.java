package com.zhanglw.java8lambdas.base;

import java.util.stream.Stream;

/**
 * Author : zhanglianwei
 * Create : 2018/1/4 22:14
 * Update : 2018/1/4 22:14
 * Descriptions :
 */
public class Artist {

    private String name;

    private Stream<Artist> members;

    private String nationality;

    private Track track;

    public Artist() {
    }

    public Artist(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Stream<Artist> getMembers() {
        return members;
    }

    public void setMembers(Stream<Artist> members) {
        this.members = members;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
