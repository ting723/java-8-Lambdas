package com.zhanglw.java8lambdas.chapter04;

import com.zhanglw.java8lambdas.base.Artist;

import java.util.stream.Stream;

/**
 * Author : zhanglianwei
 * Create : 2018/1/25 23:41
 * Update : 2018/1/25 23:41
 * Descriptions :
 */
public interface Performance {
    String getName();

    Stream<Artist> getMusicians();

    default Stream<Artist> getAllMusicians() {
        return getMusicians()
                .flatMap(artist ->
                        // concat 艺术家或乐队   乐队下的艺术家
                        Stream.concat(Stream.of(artist), artist.getMembers()));
    }
}
