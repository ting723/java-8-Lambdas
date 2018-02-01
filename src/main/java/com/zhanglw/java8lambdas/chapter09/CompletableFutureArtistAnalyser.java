package com.zhanglw.java8lambdas.chapter09;

import com.zhanglw.java8lambdas.base.Artist;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Author : zhanglianwei
 * Create : 2018/2/1 13:46
 * Update : 2018/2/1 13:46
 * Descriptions :
 */
public class CompletableFutureArtistAnalyser implements ArtistAnalyzer {

    private final Function<String, Artist> artistLookupService;

    public CompletableFutureArtistAnalyser(Function<String, Artist> artistLookupService) {
        this.artistLookupService = artistLookupService;
    }

    public void isLargerGroup(String artistName, String otherArtistName, Consumer<Boolean> handler) {
        CompletableFuture<Long> otherArtistMemberCount = CompletableFuture.supplyAsync(() -> getNumberOfMembers(otherArtistName));

        CompletableFuture<Long> artistMemberCount = CompletableFuture.completedFuture(getNumberOfMembers(artistName));

        artistMemberCount.thenCombine(otherArtistMemberCount, (count, otherCount) -> count > otherCount)
                .thenAccept(handler::accept);
    }

    private long getNumberOfMembers(String artistName) {
        return artistLookupService.apply(artistName)
                .getMembers()
                .count();
    }

}
