package com.fosss.kamaCoder.a_练习acm模式;

import java.util.Scanner;

/**
 * 题目描述：
 * 有一天, 小明收到一张奇怪的信, 信上要小明计算出给定数各个位上数字为偶数的和。例如：5548，结果为12，等于 4 + 8 。小明很苦恼，想请你帮忙解决这个问题。
 * <p>
 * 输入： 输入数据有多组。每组占一行，只有一个整整数，保证数字在32位整型范围内。
 * <p>
 * 输出： 对于每组输入数据，输出一行，每组数据下方有一个空行。
 * <p>
 * 样例输入：
 * 415326
 * 3262
 * 样例输出：
 * 12
 * <p>
 * 10
 * <p>
 */
public class B09_奇怪的信 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int sum = 0;
            while (n > 0) {
                int t = n % 10;
                if (t % 2 == 0) sum += t;
                n /= 10;
            }
            System.out.println(sum);
            System.out.println();
        }
        sc.close();
    }
}