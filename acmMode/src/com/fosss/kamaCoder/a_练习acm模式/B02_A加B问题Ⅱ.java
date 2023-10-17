package com.fosss.kamaCoder.a_练习acm模式;

import java.util.Scanner;

/**
 * 题目描述：
 * 计算a+b，但输入方式有所改变。
 * <p>
 * 输入：
 * 第一行是一个整数N，表示后面会有N行a和b，通过空格隔开。
 * <p>
 * 输出：
 * 对于输入的每对a和b，你需要在相应的行输出a、b的和。如第二对a和b，对应的和也输出在第二行。
 * <p>
 * 样例输入：
 * 2
 * 2 4
 * 9 21
 * <p>
 * 样例输出：
 * 6
 * 30
 */
public class B02_A加B问题Ⅱ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            while (N-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                System.out.println(a + b);
            }
        }
        sc.close();
    }
}