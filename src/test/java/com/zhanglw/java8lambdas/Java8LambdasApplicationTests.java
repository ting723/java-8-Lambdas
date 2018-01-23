package com.zhanglw.java8lambdas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Java8LambdasApplicationTests {

    @Test
    public void contextLoads() {
        BinaryOperator<Integer> add = (x, y) -> x + y;
        int z = add.apply(1, 2);
        System.out.println(z);

        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("Clicked");
                System.out.println("");
            }
        });

        // 无参lambda表达式
        Runnable runnable = () -> System.out.println("Hello World");

        runnable = () -> {
            try {
                System.out.println("hello");
                System.out.println("world");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        // 上句已经转成常见形式如下
        // 匿名函函数或lambda表达式引用变量是事实上的final,不可再次赋值
        final int a = 0;
//        a = 8;
        Runnable rc = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!!");
                System.out.println(a);
            }
        };

        // 显示声明参数类型
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
        BinaryOperator<Long> addDemo = new BinaryOperator<Long>() {
            @Override
            public Long apply(Long x, Long y) {
                return x + y;
            }
        };
        long zz = addExplicit.apply(7l, 8l);
        System.out.println(zz);

        // 根据上下文环境推断相关类型
        final String[] array = {"hello", "world"};

        // 判断是否满足某种条件
        Predicate<String> stringPredicate = x -> x.length() > 0;
        Predicate<String> stringPredicateAnon = new Predicate<String>() {
            @Override
            public boolean test(String x) {
                return array.length > 0;
            }
        };
        System.out.println(stringPredicate.test("b"));

        // 可以输入值进行操作,如更新引用值
        Consumer<String> stringConsumer = x -> x = "ss";
        Consumer<String> stringConsumerAnon = new Consumer<String>() {
            @Override
            public void accept(String x) {
                x = "ss";
            }
        };

        // 定义输入和输出值,进行相关的更新操作
        Function<String, Integer> stringIntegerFunction = x -> Integer.parseInt(x);
        Function<String, Integer> stringIntegerFunctionOther = Integer::parseInt;
        Function<String, Integer> stringIntegerFunctionAnon = new Function<String, Integer>() {
            @Override
            public Integer apply(String x) {
                return Integer.parseInt(x);
            }
        };
        System.out.println(stringIntegerFunction.apply("10"));

        // 可以用于工厂方法
        Supplier<String> stringSupplier = () -> String.valueOf("000");
        Supplier<String> stringSupplierAnon = new Supplier<String>() {
            @Override
            public String get() {
                return String.valueOf("000");
            }
        };
        System.out.println(stringSupplier.get());

        // 一元操作,单算子
        UnaryOperator<String> stringUnaryOperator = s -> s + "xx";
        UnaryOperator<String> stringUnaryOperatorAnon = new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return null;
            }
        };

        // 二元操作,
        BinaryOperator<Long> longBinaryOperator = (x, y) -> x * y;
        BinaryOperator<Long> longBinaryOperator1 = new BinaryOperator<Long>() {
            @Override
            public Long apply(Long x, Long y) {
                return x * y;
            }
        };
        System.out.println(longBinaryOperator.apply(99L, 999L));


        List<Integer> resultLambda = Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(Collection::stream).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        for (List<Integer> integers : Arrays.asList(asList(1, 2), asList(3, 4))) {
            for (Integer integer : integers) {
                result.add(integer);
            }
        }

    }


}
