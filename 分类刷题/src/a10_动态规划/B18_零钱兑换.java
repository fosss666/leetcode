package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/15
 * Time: 17:04
 * Description:
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 你可以认为每种硬币的数量是无限的。
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * 输入：coins = [1], amount = 2
 * 输出：2
 * 提示：
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 */
public class B18_零钱兑换 {

    public int coinChange(int[] coins, int amount) {
        //dp[i]：凑成总金额所需的最少的硬币个数为dp[i]
        int[] dp = new int[amount + 1];
        //初始化：i为0时，需要0个硬币，∴dp[0]=0;其他情况下，由于递推公式更新依据的是最小值，所以应该初始化为足够大的值
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) dp[i] = Integer.MAX_VALUE;

        //先遍历物品或背包都可以
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                //递推公式：min( 不把i放到背包中需要的硬币个数, 把i放到背包中需要的硬币个数 )
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {//dp[j-coins[i]]能由硬币组成时
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        //dp[amount]==int最大值说明没有任何一种硬币组合能组成总金额，返回-1
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
