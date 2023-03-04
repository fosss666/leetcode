package com.fosss.a63_股票的最大利润;

/**
 * @author: fosss
 * Date: 2023/3/4
 * Time: 9:29
 * Description: 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 示例1：
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例2：
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 限制：0 <= 数组长度 <= 10^5
 */
public class Solution {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Solution solution = new Solution();
        int res = solution.maxProfit(prices);
        System.out.println("res = " + res);
    }

    /**
     * 动态规划,原理也是找最小值和最大的差   52%  41%
     */
    public int maxProfit2(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    /**
     * 自解，固定最小值找差最大  52%  69%
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int i = 0, j = 1;
        int max = 0;
        while (j < prices.length) {
            //找到右比左小的地方
            while (j < prices.length && prices[j] - prices[i] < 0) {
                //prices[j]比prices[i]小，则prices[j]小
                i = j;
                j++;
            }
            //更新max
            if (j < prices.length && prices[j] - prices[i] > max) {
                max = prices[j] - prices[i];
            }
            j++;
        }

        return max;
    }
}

























