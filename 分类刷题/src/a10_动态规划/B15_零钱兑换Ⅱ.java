package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/12
 * Time: 16:30
 * Description:
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * 示例 1:
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 * 注意，你可以假设：
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 */
public class B15_零钱兑换Ⅱ {

    public static void main(String[] args) {
        B15_零钱兑换Ⅱ test = new B15_零钱兑换Ⅱ();
        test.change(5, new int[]{1, 2, 5});
    }

    public int change(int amount, int[] coins) {
        //题目说每种硬币有无数个，所以是完全背包问题
        //dp[i]表示总金额（背包容量）为i时，不同组合数为dp[i]
        int[] dp = new int[amount + 1];
        //初始化，当总金额为0时，只有哪种硬币都不选这一种情况
        dp[0] = 1;

        //遍历硬币
        for (int i = 0; i < coins.length; i++) {
            //遍历总金额
            for (int j = coins[i]; j <= amount; j++) {
                //递推公式。金额为j时的组合数=金额为j-1时的组合数+金额为j-coins[i]的组合数，其中j-1的组合数用滚动数组优化成dp[j]，即等号
                //前边的dp[j]表示当前j的组合数，等号后边的dp[j]表示原来的j（即上个循环，即j-1）的组合数
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

        return dp[amount];
    }
}
