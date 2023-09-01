package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/1
 * Time: 11:32
 * Description:
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： F(0) = 0，
 * F(1) = 1 F(n) = F(n - 1) + F(n - 2)，其中 n > 1 给你n ，请计算 F(n) 。
 * 示例 1：
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * 提示：
 * 0 <= n <= 30
 */
public class B01_斐波那契数 {

    /**
     * 递归法
     */
    public int fib0(int n) {
        if (n <= 1) return n;
        return fib0(n - 1) + fib0(n - 2);
    }

    /**
     * 动态规划
     */
    public int fib(int n) {
        if (n <= 1) return n;
        //dp[i]表示F[i]的值
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 动态规划——空间优化
     */
    public int fib2(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;//a:F[0]  b:F[1]
        for (int i = 2; i <= n; i++) {
            int temp = b;//暂存b
            //a和b向后移动
            b = a + b;
            a = temp;
        }
        return b;
    }
}
