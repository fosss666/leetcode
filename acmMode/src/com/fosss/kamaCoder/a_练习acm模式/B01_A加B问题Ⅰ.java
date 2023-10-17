package com.fosss.kamaCoder.a_练习acm模式;

import java.util.Scanner;

/**
 * 题目描述：
 * 你的任务是计算a+b。
 * <p>
 * 输入：
 * 输入包含一系列的a和b对，通过空格隔开。一对a和b占一行。
 * <p>
 * 输出：
 * 对于输入的每对a和b，你需要依次输出a、b的和。如对于输入中的第二对a和b，在输出中它们的和应该也在第二行。
 * <p>
 * 样例输入：
 * 3 4
 * 11 40
 * <p>
 * 样例输出：
 * 7
 * 51
 */
public class B01_A加B问题Ⅰ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
    }

}