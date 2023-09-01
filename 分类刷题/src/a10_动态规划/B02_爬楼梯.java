package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/1
 * Time: 11:48
 * Description:
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1 阶 + 1 阶
 * 2 阶
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1 阶 + 1 阶 + 1 阶
 * 1 阶 + 2 阶
 * 2 阶 + 1 阶
 */
public class B02_爬楼梯 {

    /**
     * 动态规划
     */
    public int climbStairs(int n) {
        //n=1时，1种
        //n=2时，2种
        //n=3时，3种  F[3]=F[2]+F[1]
        //n=4时，5种  F[4]=F[3]+F[2]
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 动态规划——空间优化
     */
    public int climbStairs2(int n) {
        //n=1时，1种
        //n=2时，2种
        //n=3时，3种  F[3]=F[2]+F[1]
        //n=4时，5种  F[4]=F[3]+F[2]
        if (n <= 2) return n;
        int a = 1, b = 2;//代表F[1] 和 F[2]
        for (int i = 3; i <= n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }
}
