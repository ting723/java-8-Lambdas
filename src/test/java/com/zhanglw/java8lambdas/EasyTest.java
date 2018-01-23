package com.zhanglw.java8lambdas;

import java.util.Arrays;

/**
 * Author : zhanglianwei
 * Create : 2018/1/23 17:17
 * Update : 2018/1/23 17:17
 * Descriptions :
 */
public class EasyTest {

    public static void main(String[] args) {
        int rs = Arrays.asList(1, 2, 3, 4, 5).stream().reduce(0, (x, y) -> x + y);
        System.out.println(rs);
    }

}
