package com.zhanglw.java8lambdas.chapter3;

import com.alibaba.fastjson.JSON;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

/**
 * Author : zhanglianwei
 * Create : 2018/1/24 14:07
 * Update : 2018/1/24 14:07
 * Descriptions :在一个字符串列表中，找出包含最多小写字母的字符串。对于空列表，返回 Optional <String> 对象。
 */
public class Question7 {

    private Optional<String> haveMaxNumLowerChar(List<String> list) {
        return list.stream()
                .max(Comparator.comparing(Question6::countLowerChar));
    }

    public static void main(String[] args) {
        Question7 question7 = new Question7();

        System.out.println(JSON.toJSONString(question7.haveMaxNumLowerChar(asList("q1we", "qeioooo", "we"))));
    }
}
