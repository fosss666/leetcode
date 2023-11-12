package com.fosss.lanqiaoCode.动态规划;

import java.util.Scanner;

/**
 * @author: fosss
 * Date: 2023/11/12
 * Time: 17:06
 * Description:
 * 小明刚刚看完电影《第39级台阶》，离开电影院的时候，他数了数礼堂前的台阶数，恰好是39级！站在台阶前，他突然又想着一个问题
 * 如果我每一步只能迈上1个或2个台阶。先迈左脚，然后左右交替，最后一步是迈右脚，也就是说一共要走偶数步。那么，上完39级台阶，有
 * 多少种不同的上法呢？请你利用计算机的优势，帮助小明寻找答案
 */
public class B01_第39级台阶 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n = 39;
        //dp[i][j]表示上完第（i+1）级台阶，j==0:奇数步，j==1:偶数步 有dp[i][j]种上法
        int[][] dp = new int[n][2];
        //初始化
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 1;
        dp[1][1] = 1;

        //递推 第i级台阶由第i-1和i-2递推而来
        for (int i = 2; i < n; i++) {
            //奇数步 第i-1层（偶数步）迈一级或第i-2层（偶数步）迈两级
            dp[i][0] = dp[i - 1][1] + dp[i - 2][1];
            //偶数步 第i-1层（奇数步）迈一级或第i-2层（奇数步）迈两级
            dp[i][1] = dp[i - 1][0] + dp[i - 2][0];
        }
        System.out.println(dp[n - 1][1]);
        scan.close();
    }
}
