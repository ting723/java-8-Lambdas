package com.zhanglw.java8lambdas.chapter09;

import java.util.function.Consumer;

/**
 * Author : zhanglianwei
 * Create : 2018/2/1 11:47
 * Update : 2018/2/1 11:47
 * Descriptions :
 */
public interface ArtistAnalyzer {
    void isLargerGroup(String artistName, String otherArtistName, Consumer<Boolean> handler);
}
