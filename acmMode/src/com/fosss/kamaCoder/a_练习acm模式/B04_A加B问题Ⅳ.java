package com.fosss.kamaCoder.a_练习acm模式;

import java.util.Scanner;

/**
 * 题目描述：
 * 你的任务依然是计算a+b。
 * <p>
 * 输入：
 * 输入中每行是一对a和b。其中会有一对是0和0标志着输入结束，且这一对不要计算。
 * <p>
 * 输出：
 * 对于输入的每对a和b，你需要在相应的行输出a、b的和。如第二对a和b，他们的和也输出在第二行。
 * <p>
 * 样例输入：
 * 2 4
 * 11 19
 * 0 0
 * <p>
 * 样例输出：
 * 6
 * 30
 */
public class B04_A加B问题Ⅳ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0) break;
            System.out.println(a + b);
        }
        sc.close();
    }
}