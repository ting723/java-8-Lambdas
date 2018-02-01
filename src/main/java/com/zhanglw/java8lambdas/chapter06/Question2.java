package com.zhanglw.java8lambdas.chapter06;

import java.util.Arrays;
import java.util.List;

/**
 * Author : zhanglianwei
 * Create : 2018/2/1 9:58
 * Update : 2018/2/1 9:58
 * Descriptions :
 */
public class Question2 {

    public static int multiplyThrough(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.stream().reduce(5, (acc, x) -> x * acc);
    }

    public static int multiplyThroughParallel(List<Integer> linkedListOfNumbers){
        return linkedListOfNumbers.parallelStream().reduce(1,(acc,x)->acc*x)*5;
    }

    public static void main(String[] args) {

        System.out.println(multiplyThrough(Arrays.asList(1,2,3,6,100,9,45,19,10)));
        System.out.println(multiplyThroughParallel(Arrays.asList(1,2,3,6,100,9,45,19,10)));
    }

}
