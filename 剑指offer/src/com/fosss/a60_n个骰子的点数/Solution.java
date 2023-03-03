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
        double[] res = solution.dicesProbability2(2);
        System.out.println("res = " + Arrays.toString(res));
    }

    /**
     * k神-更加优雅的一维数组动态规划     100%   59%
     */
    public double[] dicesProbability3(int n) {
        //因为最后的结果只与前一个动态转移数组有关，所以这里只需要设置一个一维的动态转移数组
        //原本dp[i][j]表示的是前i个骰子的点数之和为j的概率，现在只需要最后的状态的数组，所以就只用一个一维数组dp[j]表示n个骰子下每个结果的概率。
        //初始是1个骰子情况下的点数之和情况，就只有6个结果，所以用dp的初始化的size是6个
        double[] dp = new double[6];
        //只有一个数组
        Arrays.fill(dp, 1.0 / 6.0);
        //从第2个骰子开始，这里n表示n个骰子，先从第二个的情况算起，然后再逐步求3个、4个···n个的情况
        //i表示当总共i个骰子时的结果
        for (int i = 2; i <= n; i++) {
            //每次的点数之和范围会有点变化，点数之和的值最大是i*6，最小是i*1，i之前的结果值是不会出现的；
            //比如i=3个骰子时，最小就是3了，不可能是2和1，所以点数之和的值的个数是6*i-(i-1)，化简：5*i+1
            //当有i个骰子时的点数之和的值数组先假定是temp
            double[] temp = new double[5 * i + 1];
            //从i-1个骰子的点数之和的值数组入手，计算i个骰子的点数之和数组的值
            //先拿i-1个骰子的点数之和数组的第j个值，它所影响的是i个骰子时的temp[j+k]的值
            for (int j = 0; j < dp.length; j++) {
                //比如只有1个骰子时，dp[1]是代表当骰子点数之和为2时的概率，它会对当有2个骰子时的点数之和为3、4、5、6、7、8产生影响，因为当有一个骰子的值为2时，另一个骰子的值可以为1~6，产生的点数之和相应的就是3~8；比如dp[2]代表点数之和为3，它会对有2个骰子时的点数之和为4、5、6、7、8、9产生影响；所以k在这里就是对应着第i个骰子出现时可能出现六种情况，这里可能画一个K神那样的动态规划逆推的图就好理解很多
                for (int k = 0; k < 6; k++) {
                    //这里记得是加上dp数组值与1/6的乘积，1/6是第i个骰子投出某个值的概率
                    temp[j + k] += dp[j] * (1.0 / 6.0);
                }
            }
            //i个骰子的点数之和全都算出来后，要将temp数组移交给dp数组，dp数组就会代表i个骰子时的可能出现的点数之和的概率；用于计算i+1个骰子时的点数之和的概率
            dp = temp;
        }
        return dp;
    }

    /**
     * 空间优化-一维数组动态规划   100%  50%
     */
    public double[] dicesProbability2(int n) {
        double[] res = new double[6 * n - n + 1];
        //dp[i]表示和为i时的组合数，初始创建大小为7的数组，因为一个骰子的最大值为6
        double[] dp = new double[7];//
        //初始化只有一个骰子的时候的的情况
        for (int i = 1; i <= 6; i++) {
            //每种结果只有一种可能组合
            dp[i] = 1;
        }
        //处理多个骰子的情况,从第二个骰子开始
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[i * 6 + 1];//i个骰子时，最大和为6*i
            //这些骰子值的和的可能值
            for (int j = i; j <= 6 * i; j++) {
                //每个骰子有6种可能值,i-k==>因为第i个骰子可能值为1~6，所以第i-1个骰子的和为第i个骰子的和减去k(1<=k<=6)
                for (int k = 1; k <= 6; k++) {
                    if (j - k < 1) {
                        break;
                    }
                    if (j - k >= dp.length) {
                        continue;
                    }
                    //第i个骰子的可能和的组合数为第i-1个骰子的和！！！！！
                    tmp[j] += dp[j - k];
                }
            }
            //将tmp赋给dp
            dp = tmp;
        }
        //以上得到了所有可能和的组合
        //所有可能情况为6^n
        //求概率  每种可能和的组合数/总数
        for (int i = n; i <= 6 * n; i++) {
            res[i - n] = dp[i] / (Math.pow(6, n));
        }
        return res;
    }

    /**
     * 二维数组动态规划   100%  35%
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
            for (int j = i; j <= 6 * i; j++) {
                //每个骰子有6种可能值,j-k==>因为第i个骰子可能值为1~6，所以第i-1个骰子的和为第i个骰子的和减去k(1<=k<=6)
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

























