package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/26
 * Time: 19:47
 * Description:
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。注意利润不能是 7-1 = 6, 因为卖出价
 * 格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class B25_买卖股票的最佳时机 {

    /**
     * 暴力解法，找最大差值。超时。
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    /**
     * 贪心算法
     * 遍历过程中记录最小的值start,每次先计算出与其差值，如果比start小，那么更新start;否则更新max。即左边取最小值，右边取最大值
     */
    public int maxProfit2(int[] prices) {
        int max = 0;
        int start = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int count = prices[i] - start;
            if (count > 0) {
                max = Math.max(max, count);
            } else {
                start = prices[i];
            }
            //或可写成
            /*start = Math.min(start, prices[i]);
            max = Math.max(max, prices[i] - start);*/
        }
        return max;
    }

    /**
     * 动态规划，用变量优化后就是贪心算法的代码
     */
    public int maxProfit3(int[] prices) {
        //dp[i]表示第i天得到的最大利润
        int[] dp = new int[prices.length];
        //记录最小值
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return dp[prices.length - 1];
    }

    /**
     * 动态规划——代码随想录版
     */
    public int maxProfit4(int[] prices) {
        //dp[i][0]表示第i天持有股票所花的现金,这个钱肯定是越少越好
        //dp[i][1]表示第i天不持有股票所得最多现金，这个钱肯定是越多越好
        int[][] dp = new int[prices.length][2];
        //初始化
        dp[0][0] = prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            //更新股票最低价
            dp[i][0] = Math.min(dp[i - 1][0], prices[i]);
            //这天卖出去得到的利润
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] - dp[i - 1][0]);
        }
        return dp[prices.length - 1][1];
    }

    /**
     * 空间优化
     * 行数只有两个值实际有用dp[i][]和dp[i-1][]，用长度为2的一维数组优化，然而又可以用两个正数变量代替，所以改着改着又变成贪心的代码了
     */
    public int maxProfit5(int[] prices) {
        //dp[i][0]表示第i天持有股票所花的现金,这个钱肯定是越少越好
        //dp[i][1]表示第i天不持有股票所得最多现金，这个钱肯定是越多越好
        int[] dp = new int[2];
        //初始化
        dp[0] = prices[0];
        dp[1] = 0;

        for (int i = 1; i < prices.length; i++) {
            //更新股票最低价
            dp[0] = Math.min(dp[0], prices[i]);
            //这天卖出去得到的利润
            dp[1] = Math.max(dp[1], prices[i] - dp[0]);
        }
        return dp[1];
    }
}
