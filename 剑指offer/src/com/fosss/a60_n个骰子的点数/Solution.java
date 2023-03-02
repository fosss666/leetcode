package com.fosss.a60_n个骰子的点数;

import java.util.Arrays;

/**
 * @author: fosss
 * Date: 2023/3/2
 * Time: 14:57
 * Description:把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。你需要用一个浮点数数组返回答案，其中第
 * i个元素代表这n个骰子所能掷出的点数集合中第i小的那个的概率。
 * 示例：输入: 1   输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 限制：1 <= n <= 11
 * 分析：
 * n个骰子有(6*n-n+1)种可能情况
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        double[] res = solution.dicesProbability(2);
        System.out.println("res = " + Arrays.toString(res));
    }

    /**
     * 二维数组动态规划   100%  92%
     */
    public double[] dicesProbability(int n) {
        double[] res = new double[6 * n - n + 1];
        //设置动态规划数组dp[i][j]，表示有i个骰子的时候，和为j一共有多少组情况
        double[][] dp = new double[n + 1][6 * n + 1];
        //初始化只有一个骰子的时候的的情况
        for (int i = 1; i <= 6; i++) {
            //每种结果只有一种可能组合
            dp[1][i] = 1;
        }
        //处理多个骰子的情况,从第二个骰子开始
        for (int i = 2; i <= n; i++) {
            //这些骰子值的和的可能值
            for (int j = i; j <= 6 * n; j++) {
                //每个骰子有6种可能值,i-k==>因为第i个骰子可能值为1~6，所以第i-1个骰子的和为第i个骰子的和减去k(1<=k<=6)
                for (int k = 1; k <= 6; k++) {
                    if (j - k < 1) {
                        break;
                    }
                    //第i个骰子的可能和的组合数为第i-1个骰子的和！！！！！
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        //以上得到了所有可能和的组合
        //所有可能情况为6^n
        //求概率  每种可能和的组合数/总数
        for (int i = n; i <= 6 * n; i++) {
            res[i - n] = dp[n][i] / (Math.pow(6, n));
        }
        return res;
    }
}

























