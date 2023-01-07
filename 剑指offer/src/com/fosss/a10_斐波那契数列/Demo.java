package com.fosss.a10_斐波那契数列;

/**
 * @author fosss
 * date 2023/1/7
 * description：
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下:
 * F(0) = 0,   F(1) = 1 ,F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 例：输入：n = 2  输出：1
 * 限制：0 <= n <= 100
 */
public class Demo {
    public static void main(String[] args) {
        Demo demo = new Demo();
        int fib = demo.fib(44);
        System.out.println("fib = " + fib);

    }

    /**
     * 递归_超时了，废弃
     */
    public int fib(int n) {
        if(n<2){
            return n;
        }
        return fib(n-2)+fib(n-1);
    }
}























