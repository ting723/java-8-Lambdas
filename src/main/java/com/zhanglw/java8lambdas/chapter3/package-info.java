/**
 * Author : zhanglianwei
 * Create : 2018/1/24 11:36
 * Update : 2018/1/24 11:36
 * Descriptions :
 */
package com.zhanglw.java8lambdas.chapter3;

// Question3
/*
 * 判断是否惰性求值还是及早求值
 * 看返回值，返回为steam，就是惰性求值,若返回为空或其他值，那么就是及早求值
 * <p>
 * a 为及早求值
 * b 为惰性求值
 */
//a. boolean anyMatch(Predicate<? super T> predicate);

// b. Stream<T> limit(long maxSize);

//***Answer***//
/*
 * a 为及早求值
 * b 为惰性求值
 */


// Question4
/*
 * 判断是否高阶函数
 * a. boolean anyMatch(Predicate<? super T> predicate);
 * b. Stream<T> limit(long maxSize);
 * 判断依据:
 * 如果是高阶函数，则其签名即参数列表包含函数接口，或者返回一个函数接口
 */

//***Answer***//
/*
 * a 是高阶函数
 * b 不是高阶函数
 */

// Question5
/*
 * 下面的 Lambda 表达式有无副作用，或者说它们是否更改了程序状态
 * x->x+1
 * 示例代码:
 *  AtomicInteger count = new AtomicInteger(0);
 *  List<String> origins = album.musicians()
 *      .forEach(musician -> count.incAndGet();)
 */

//***Answer***//
/* x->x+1  side effect free 无副作用
 * Mutates count 变异数
 * Mutates:发生改变或者变量
 */
