package com.fosss.kamaCoder.a_练习acm模式;

import java.util.Scanner;

/**
 * 题目描述：
 * 你的任务是计算两个整数的和。
 * <p>
 * 输入：
 * 输入的第一行为一个整数N，接下来N行每行先输入一个整数M，然后在同一行内输入M个整数。
 * <p>
 * 输出：
 * 对于每组输入，输出M个数的和，每组输出之间输出一个空行。
 * <p>
 * 样例输入：
 * 3
 * 4 1 2 3 4
 * 5 1 2 3 4 5
 * 3 1 2 3
 * <p>
 * 样例输出：
 * 10
 * <p>
 * 15
 * <p>
 * 6
 */
public class B06_A加B问题Ⅵ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            while (N-- > 0) {
                int M = sc.nextInt();
                int sum = 0;
                while (M-- > 0) {
                    sum += sc.nextInt();
                }
                System.out.println(sum);
                //注意，最后一组不需要输出空行
                if (N > 0) System.out.println();

            }
        }
        sc.close();
    }
}