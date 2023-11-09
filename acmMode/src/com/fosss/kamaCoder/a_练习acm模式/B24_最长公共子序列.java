package com.fosss.kamaCoder.a_练习acm模式;

import java.util.*;

/**
 * 题目描述：
 * 给你一个序列X和另一个序列Z，当Z中的所有元素都在X中存在，并且在X中的下标顺序是严格递增的，那么就把Z叫做X的子序列。
 * 例如：Z=<a,b,f,c>是序列X=<a,b,c,f,b,c>的一个子序列，Z中的元素在X中的下标序列为<1,2,4,6>。
 * 现给你两个序列X和Y，请问它们的最长公共子序列的长度是多少？
 * 输入：输入包含多组测试数据。每组输入占一行，为两个字符串，由若干个空格分隔。每个字符串的长度不超过100。
 * 输出：对于每组输入，输出两个字符串的最长公共子序列的长度。
 * 样例输入：
 * abcfbc abfcab
 * programming contest
 * abcd mnp
 * 样例输出：
 * 4
 * 2
 * 0
 */

public class B24_最长公共子序列 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String X = sc.next();
            String Z = sc.next();
            //动态规划经典题目
            //dp[i][j]：以X[i-1]结尾的字符串和以Z[j-1]结尾的字符串的公共子序列长度
            int[][] dp = new int[X.length() + 1][Z.length() + 1];
            int max = 0;//记录最长长度
            for (int i = 1; i <= X.length(); i++) {
                for (int j = 1; j <= Z.length(); j++) {
                    if (X.charAt(i - 1) == Z.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
            System.out.println(max);
        }
        sc.close();
    }
}