package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/2
 * Time: 13:47
 * Description:
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 * 示例：
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 * 解释：你将从下标为 0 的台阶开始。
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 */
public class B03_使用最小花费爬楼梯 {

    /**
     * 动规
     */
    public int minCostClimbingStairs(int[] cost) {
        //dp[i]表示爬到第i个台阶需要支付的费用,台阶顶部为cost.length+1
        int[] dp = new int[cost.length + 1];
        //一开始可以选择从下标0或1出开始爬，也就是说这两个位置是不需要支付费用的
        dp[0] = 0;
        dp[1] = 0;
        //推导公式，第i个台阶可以从i-1或i-2爬过来，选择花费少的那个，即min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

    /**
     * 动规——空间优化
     */
    public int minCostClimbingStairs2(int[] cost) {
        //dp[i]表示爬到第i个台阶需要支付的费用,台阶顶部为cost.length+1
        //一开始可以选择从下标0或1出开始爬，也就是说这两个位置是不需要支付费用的,a，b分别表示下标为i-1,i-2的台阶
        int a = 0, b = 0;
        //推导公式，第i个台阶可以从i-1或i-2爬过来，选择花费少的那个，即min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
        for (int i = 2; i <= cost.length; i++) {
            int temp = b;
            //a，b分别表示下标为i-1,i-2的台阶
            b = Math.min(a + cost[i - 2], b + cost[i - 1]);
            a = temp;
        }
        return b;
    }
}
