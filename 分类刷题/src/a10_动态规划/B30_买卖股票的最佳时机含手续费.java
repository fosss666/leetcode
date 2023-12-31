package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/10/2
 * Time: 19:21
 * Description:
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * 示例 1:
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000
 */
public class B30_买卖股票的最佳时机含手续费 {

    public int maxProfit(int[] prices, int fee) {
        //两种状态，买入花的钱和卖出赚的钱，买入时需要支付手续费（或理解为卖出时需支付手续费）
        int[][] dp = new int[prices.length][2];
        dp[0][0] = prices[0] + fee;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], prices[i] + fee - dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] - dp[i - 1][0]);
        }
        return dp[prices.length - 1][1];
    }

    /**
     * 一维数组
     */
    public int maxProfit2(int[] prices, int fee) {
        //两种状态，买入花的钱和卖出赚的钱，买入时需要支付手续费（或理解为卖出时需支付手续费）
        int[] dp = new int[2];
        dp[0] = prices[0] + fee;

        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.min(dp[0], prices[i] + fee - dp[1]);
            dp[1] = Math.max(dp[1], prices[i] - dp[0]);
        }
        return dp[1];
    }
}
