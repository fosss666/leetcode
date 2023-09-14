package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/14
 * Time: 10:06
 * Description:
 * 一共有n阶台阶，
 * 一步一个台阶，两个台阶，三个台阶，.......，直到 m个台阶。问有多少种不同的方法可以爬到楼顶呢？
 */
public class B17_爬楼梯_进阶版 {
    /**
     * 每次可以爬的台阶数可以看作是物品，总台阶数看作背包容量，每次爬的台阶数可重复，与上一题组合总和Ⅳ相似
     */
    public int climbStairs(int n, int m) {
        //dp[i]表示，爬到第i阶台阶由多少种方法
        int[] dp = new int[n + 1];
        dp[0] = 1;
        //遍历背包容量
        for (int i = 1; i <= n; i++) {
            //遍历每次爬的台阶数
            for (int j = 1; j <= m; j++) {
                if (i >= j) dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }
}
