package com.zhanglw.java8lambdas.chapter06;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Author : zhanglianwei
 * Create : 2018/2/1 10:26
 * Update : 2018/2/1 10:26
 * Descriptions :
 */
public class Question3 {

    public static int slowSumOfSquares(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.parallelStream().map(x -> x * x)
                .reduce(0, (acc, x) -> acc + x);
    }

    public static int fastSumOfSquares(List<Integer> linkedListOfNumbers) {
//        return linkedListOfNumbers.stream()
//                .reduce(0, (acc, x) -> acc + x * x);
        return linkedListOfNumbers.parallelStream().mapToInt(x -> x * x)
                .reduce(0, (acc, x) -> acc + x);
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(slowSumOfSquares(asList(1, 100, 18, 20, 1, 8, 9, 10, 29,18)));
        System.out.println(System.currentTimeMillis());

        System.out.println(System.currentTimeMillis());
        System.out.println(fastSumOfSquares(asList(1, 100, 18, 20, 1, 8, 9, 10, 29,18)));
        System.out.println(System.currentTimeMillis());
    }
}
