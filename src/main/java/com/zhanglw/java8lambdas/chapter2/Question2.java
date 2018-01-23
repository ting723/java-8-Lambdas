package com.zhanglw.java8lambdas.chapter2;

import java.text.SimpleDateFormat;

/**
 * Author : zhanglianwei
 * Create : 2018/1/14 22:44
 * Update : 2018/1/14 22:44
 * Descriptions :
 */
public class Question2 {

    /**
     *  需要熟悉ThreadLocal的相关方法
     */
    public final static ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(
            () -> new SimpleDateFormat("dd-MMM-yyy")
    );

//    public static void main(String[] args) {
//        System.out.println(formatter.get().format(new Date()));
//    }
}

