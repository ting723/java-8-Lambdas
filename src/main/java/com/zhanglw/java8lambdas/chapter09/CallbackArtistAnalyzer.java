package com.zhanglw.java8lambdas.chapter09;

import com.zhanglw.java8lambdas.base.Artist;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Author : zhanglianwei
 * Create : 2018/2/1 11:52
 * Update : 2018/2/1 11:52
 * Descriptions :
 */
public class CallbackArtistAnalyzer implements ArtistAnalyzer {

    private final Function<String, Artist> artistLookupService;

    public CallbackArtistAnalyzer(Function<String, Artist> artistLookupService) {
        this.artistLookupService = artistLookupService;
    }

    public void isLargerGroup(String artistName, String otherArtistName, Consumer<Boolean> handler) {
        boolean isLarger = getNumberOfMembers(artistName) > getNumberOfMembers(otherArtistName);
        handler.accept(isLarger);
    }

    private long getNumberOfMembers(String artistName) {
        return artistLookupService.apply(artistName)
                .getMembers()
                .count();
    }
}
