package com.fosss.kamaCoder.a_练习acm模式;

import java.util.Scanner;

/**
 * 题目描述：
 * 你的任务是计算两个整数的和。
 * <p>
 * 输入：
 * 输入包含若干行，每行输入两个整数a和b，由空格分隔。
 * <p>
 * 输出：
 * 对于每组输入，输出a和b的和，每行输出后接一个空行。
 * <p>
 * 样例输入：
 * 2 4
 * 11 19
 * <p>
 * 样例输出：
 * 6
 * 30
 */
public class B05_A加B问题Ⅴ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
            System.out.println();
        }
        sc.close();
    }
}