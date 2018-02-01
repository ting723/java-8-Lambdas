package com.zhanglw.java8lambdas.chapter05;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * Author : zhanglianwei
 * Create : 2018/1/25 18:29
 * Update : 2018/1/25 18:29
 * Descriptions :
 */
public class Question1 {
    public static void main(String[] args) {
        // a
        List<String> collect = Stream.of("aa", "bb").map(String::toUpperCase).collect(Collectors.toList());

        //b
        Optional<Integer> z= Stream.of("aa", "c", "3","ii").map(x -> 1).reduce(Integer::sum);
        //c
        List<String> x = Stream.of(asList("aa", "bb"), asList("aa", "bb"))
                .flatMap(Collection::stream).collect(Collectors.toList());


        System.out.println(collect);
        System.out.println(z.get());
        System.out.println(x);
    }
}
