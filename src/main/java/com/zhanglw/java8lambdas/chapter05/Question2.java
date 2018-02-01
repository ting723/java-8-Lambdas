package com.zhanglw.java8lambdas.chapter05;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Author : zhanglianwei
 * Create : 2018/1/26 11:08
 * Update : 2018/1/26 11:08
 * Descriptions :
 */
public class Question2 {

    public static void main(String[] args) {
        //a
        Stream<String> names = Stream.of("John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");
        String longName = names.max(Comparator.comparing(String::length)).orElse("unknown");
        System.out.println(longName);

        //b
        Stream<String> names2 = Stream.of("John", "Paul", "George", "John", "Paul", "John");
        Map<String, Long> collect = names2.collect(groupingBy(x -> x, counting()));
        System.out.println(JSON.toJSONString(collect, SerializerFeature.PrettyFormat));
        //c
    }
}
