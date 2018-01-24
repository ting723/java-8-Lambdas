package com.zhanglw.java8lambdas.chapter3;

import com.zhanglw.java8lambdas.base.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Author : zhanglianwei
 * Create : 2018/1/23 23:12
 * Update : 2018/1/23 23:12
 * Descriptions :
 */
public class Question2 {

    private List<Artist> init() {
        List<Artist> artists = new ArrayList<>();
        Artist artist1 = new Artist();
        Artist child11 = new Artist();
        Artist child12 = new Artist();
        artist1.setMembers(Stream.of(child11, child12));

        Artist artist2 = new Artist();
        Artist child21 = new Artist();
        Artist child22 = new Artist();
        Artist child23 = new Artist();
        Artist child24 = new Artist();
        artist2.setMembers(Stream.of(child21, child22, child23, child24));

        artists.add(artist1);
        artists.add(artist2);
        return artists;
    }

    /**
     * topic: 将外部迭代转换成内部迭代
     */
    private void topicCode() {
        int totalMember = 0;
        for (Artist artist : init()) {
            Stream<Artist> members = artist.getMembers();
            totalMember += members.count();
        }
        System.out.println(totalMember);
    }

    /**
     * solution:
     */
    private void solutionCode() {
//        List<Long> result = artists.stream().map(artist -> artist.getMembers().count()).collect(toList());
//        long count = result.stream().reduce(0l, (x, y) -> x + y);
//        System.out.println(count);

        List<Artist> artists = init();
        int rc = artists.stream().map(artist -> artist.getMembers().count())
//                .reduce(0l, (acc, x) -> acc + x).intValue();
                .reduce(0l, Long::sum).intValue();
        System.out.println(rc);
    }

    public static void main(String[] args) {
        Question2 question2 = new Question2();
        System.out.println("外部迭代:");
        question2.topicCode();
        System.out.println("内部迭代:");
        question2.solutionCode();
    }

}
