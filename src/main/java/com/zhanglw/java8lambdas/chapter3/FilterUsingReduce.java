package com.zhanglw.java8lambdas.chapter3;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * Author : zhanglianwei
 * Create : 2018/1/24 14:24
 * Update : 2018/1/24 14:24
 * Descriptions :
 */
public class FilterUsingReduce {
//    public static <I> List<I> filter(Stream<I> stream, Predicate<I> mapper) {
//        return stream.reduce(new ArrayList<I>(), (acc, x) -> {
//            List<I> newAcc = new ArrayList<>();
//            if (mapper.test(x)) {
//                newAcc.add(x);
//            }
//            return newAcc;
//        }, (List<I> left, List<I> right) -> {
//            List<I> newLeft = new ArrayList<>(left);
//            newLeft.addAll(right);
//            return newLeft;
//        });
//    }

    public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate) {
        List<I> initial = new ArrayList<>();
        return stream.reduce(initial, (List<I> acc, I x) -> {
            if (predicate.test(x)) {
                List<I> newAcc = new ArrayList<>(acc);
                newAcc.add(x);
                return newAcc;
            } else {
                return acc;
            }
        }, FilterUsingReduce::combineLists);
    }

    public static <I> List<I> combineLists(List<I> left, List<I> right) {
        List<I> newLeft = new ArrayList<>(left);
        newLeft.addAll(right);
        return newLeft;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(filter(asList("aa", "11", "bb", "cc", "21").stream(), (String x) -> x.length() > 2)));
    }
}
