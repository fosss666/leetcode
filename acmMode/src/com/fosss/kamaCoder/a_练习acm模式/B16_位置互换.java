package com.fosss.kamaCoder.a_练习acm模式;

import java.util.*;

/**
 * 题目描述：
 * 给定一个长度为偶数位的字符串，请编程实现字符串的奇偶位互换。
 * <p>
 * 输入：输入包含多组测试数据。输入的第一行是一个整数n，表示有测试数据。（整个输入中，只有一个n）接下来是n组测试数据，保证串长为偶数位(串长<=50)。
 * <p>
 * 输出：请为每组测试数据输出奇偶位互换后的结果，每组输出占一行。
 * <p>
 * 样例输入：
 * 2
 * 0aa0
 * bb00
 * 样例输出：
 * a00a
 * bb00
 */
public class B16_位置互换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            while (n-- > 0) {
                String s = sc.next();
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < s.length(); i += 2) {
                    sb.append(s.charAt(i)).append(s.charAt(i - 1));
                }
                System.out.println(sb.toString());
            }

        }
        sc.close();
    }
}