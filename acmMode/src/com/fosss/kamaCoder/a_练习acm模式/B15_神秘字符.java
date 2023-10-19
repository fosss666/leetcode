package com.fosss.kamaCoder.a_练习acm模式;

import java.util.*;

/**
 * 题目描述：
 * 输出一个词组中每个单词的首字母的大写组合。
 * <p>
 * 输入：考古学家发现墓碑上有神秘的字符。经过仔细研究，发现原来这是开启古墓入口的方法。墓碑上有2行字符串，其中第一个串的长度为偶数，现在要求把第2个串插入到第一个串的正中央，如此便能开启墓碑进入墓中。
 * <p>
 * 输出：请为每组数据输出一个能开启古墓的字符串，每组输出占一行。
 * <p>
 * 样例输入：
 * 2
 * asdf
 * yu
 * rtyu
 * HJK
 * 样例输出：
 * asyudf
 * rtHJKyu
 */
public class B15_神秘字符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            while (n-- > 0) {
                String s1 = sc.next();
                String s2 = sc.next();
                StringBuilder sb = new StringBuilder();
                int l = s1.length() / 2;
                sb.append(s1.substring(0, l)).append(s2).append(s1.substring(l));
                System.out.println(sb.toString());
            }

        }
        sc.close();
    }
}