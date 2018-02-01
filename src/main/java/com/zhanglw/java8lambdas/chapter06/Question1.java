package com.zhanglw.java8lambdas.chapter06;

import java.util.stream.IntStream;

/**
 * Author : zhanglianwei
 * Create : 2018/2/1 9:47
 * Update : 2018/2/1 9:47
 * Descriptions :
 */
public class Question1 {

    public static int sequentialSumOfSquares(IntStream range) {
        return range.map(x -> x * x).sum();
    }

    public static int parallelSumOfSquares(IntStream range) {
        return range.parallel().map(x -> x * x).sum();
    }

    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1,100);
        IntStream nwintStream = IntStream.range(1,100);
        System.out.println("---串行处理---");
        System.out.println(System.currentTimeMillis());
        System.out.println(sequentialSumOfSquares(intStream));
        System.out.println(System.currentTimeMillis());

        System.out.println("---并行处理---");
        System.out.println(System.currentTimeMillis());
        System.out.println(parallelSumOfSquares(nwintStream));
        System.out.println(System.currentTimeMillis());
    }
}
