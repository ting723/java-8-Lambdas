package com.zhanglw.java8lambdas.chapter3;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Author : zhanglianwei
 * Create : 2018/1/24 14:24
 * Update : 2018/1/24 14:24
 * Descriptions :只用 reduce 和 Lambda 表达式写出实现 Stream 上的 map 操作的代码，如果不想返回 Stream，可以返回一个 List。
 * 思路:
 * 1. 新生成一个list
 * 2. 使用Function<T,R>
 */
public class MapUsingReduce {

    public static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper) {
        return stream.reduce(
                // 汇聚的类型 O
                new ArrayList<O>(),
                (acc, x) -> {
                    // 数据从I转换到O
                    List<O> newAcc = new ArrayList<>(acc);
                    newAcc.add(mapper.apply(x));
                    return newAcc;
                },
                // copy 到一个新的list  多线程时避免数据发生改变
                (List<O> left, List<O> right) -> {
                    List<O> newLeft = new ArrayList<>(left);
                    newLeft.addAll(right);
                    return newLeft;
                });
    }

    public static void main(String[] args) {
        List<String> rs = MapUsingReduce.map(Stream.of("aa", "bb"), String::toUpperCase);
        System.out.println(JSON.toJSONString(rs, SerializerFeature.PrettyFormat));
    }
}
