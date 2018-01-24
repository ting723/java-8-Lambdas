package com.zhanglw.java8lambdas.chapter3;

import com.alibaba.fastjson.JSON;

/**
 * Author : zhanglianwei
 * Create : 2018/1/24 11:21
 * Update : 2018/1/24 11:21
 * Descriptions :计算一个字符串中小写字母的个数（提示：参阅 String 对象的 chars 方法）
 */
public class Question6 {

    public static int countLowerChar(String str) {
        Long rs = str.chars()
                .filter(Character::isLowerCase)
                .count();
        return rs.intValue();
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(Question6.countLowerChar("A8uNmm9n_n_o_[w")));
        System.out.println(JSON.toJSONString(Question6.countLowerChar("wW")));
    }
}
