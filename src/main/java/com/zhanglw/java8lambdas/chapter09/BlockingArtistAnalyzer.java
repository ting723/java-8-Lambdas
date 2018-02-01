package com.zhanglw.java8lambdas.chapter09;

import com.zhanglw.java8lambdas.base.Artist;

import java.util.function.Function;

/**
 * Author : zhanglianwei
 * Create : 2018/2/1 11:45
 * Update : 2018/2/1 11:45
 * Descriptions :
 */
public class BlockingArtistAnalyzer {

    private final Function<String, Artist> artistLookupService;

    public BlockingArtistAnalyzer(Function<String, Artist> artistLookupService) {
        this.artistLookupService = artistLookupService;
    }

    public boolean isLargerGroup(String artistName, String otherArtistName) {
        return getNumberOfMembers(artistName) > getNumberOfMembers(otherArtistName);
    }

    private long getNumberOfMembers(String artistName) {
        return artistLookupService.apply(artistName).getMembers().count();
    }
}
