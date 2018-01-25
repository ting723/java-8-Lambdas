package com.zhanglw.java8lambdas.chapter04;

import com.zhanglw.java8lambdas.base.Artist;

import java.util.List;
import java.util.Optional;

/**
 * Author : zhanglianwei
 * Create : 2018/1/26 0:01
 * Update : 2018/1/26 0:01
 * Descriptions :
 */
public class Artists {

    private List<Artist> artists;

    public Artists(List<Artist> artists) {
        this.artists = artists;
    }

    public Optional<Artist> getArtist(int index){
        if(index<0||index>=artists.size()){
            return Optional.empty();
        }
        return Optional.of(artists.get(index));
    }

    public String getArtistname(int index){
        Optional<Artist> artist = getArtist(index);
        return artist.map(Artist::getName).orElse("unknown");
    }
}
