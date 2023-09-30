package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/29
 * Time: 21:51
 * Description:
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。设计一个算法来计算你所能获取的最大利润。你最多可以完
 * 成 k 笔交易。注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例 1：
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2。
 * 示例 2：
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4。随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * 提示：
 * 0 <= k <= 100
 * 0 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 */
public class B28_买卖股票的最佳时机Ⅳ {

    public static void main(String[] args) {
        B28_买卖股票的最佳时机Ⅳ test = new B28_买卖股票的最佳时机Ⅳ();
        int res = test.maxProfit(2, new int[]{2, 4, 1});
        System.out.println("res = " + res);
    }

    public int maxProfit(int k, int[] prices) {
        //dp[i][j],i表示到哪天，j表示买股票状态。一共有2k种状态，分别是第k次买入卖出。
        int[][] dp = new int[prices.length][2 * k];
        //初始化，每次买入花的钱都为prices[0]，每次卖出赚的钱为0
        for (int i = 0; i < 2 * k; i += 2) dp[0][i] = prices[0];

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k; j++) {
                if (j % 2 == 0) {
                    // 买入，记录花的最少的。j==0说明是第一次买入，j!=0时不是第一次买入，所以股票价格要减去上次赚的钱
                    dp[i][j] = Math.min(dp[i - 1][j], j == 0 ? prices[i] : prices[i] - dp[i - 1][j - 1]);
                } else {
                    // 卖出，记录赚的最多的。当天股票价格减去之前赚的
                    dp[i][j] = Math.max(dp[i - 1][j], prices[i] - dp[i - 1][j - 1]);
                }
            }
        }
        return dp[prices.length - 1][2 * k - 1];
    }

    /**
     * 不用奇偶来判断是买还是卖
     */
    public int maxProfit2(int k, int[] prices) {
        //dp[i][j],i表示到哪天，j表示买股票状态。一共有2k种状态，分别是第k次买入卖出。
        int[][] dp = new int[prices.length][2 * k];
        //初始化，每次买入花的钱都为prices[0]，每次卖出赚的钱为0
        for (int i = 0; i < 2 * k; i += 2) dp[0][i] = prices[0];

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < k * 2 - 1; j += 2) {
                dp[i][j] = Math.min(dp[i - 1][j], j == 0 ? prices[i] : prices[i] - dp[i - 1][j - 1]);
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], prices[i] - dp[i - 1][j]);
            }
        }
        return dp[prices.length - 1][2 * k - 1];
    }
}
