package a10_动态规划;

import java.util.Arrays;

/**
 * @author: fosss
 * Date: 2023/9/16
 * Time: 10:59
 * Description:
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * 示例 1：
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * 提示：
 * 1 <= n <= 10^4
 */
public class B19_完全平方数 {

    public static void main(String[] args) {
        B19_完全平方数 test = new B19_完全平方数();
        test.numSquares(12);
    }

    /**
     * 先遍历背包，再遍历数值
     */
    public int numSquares(int n) {
        //dp[i]：和为i的完全平方数的最少数量
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++) dp[i] = Integer.MAX_VALUE;

        //遍历背包容量
        for (int i = 1; i <= n; i++) {
            //遍历物品
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    /**
     * 先遍历数值，再遍历背包
     */
    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);

        //遍历数值
        for (int i = 1; i * i <= n; i++) {
            //遍历背包
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
