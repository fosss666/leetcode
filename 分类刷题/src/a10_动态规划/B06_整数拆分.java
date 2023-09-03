package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/3
 * Time: 13:56
 * Description:
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class B06_整数拆分 {

    /**
     * 动规
     */
    public int integerBreak(int n) {
        //dp[i]表示i拆分后获得的最大乘积
        int[] dp = new int[n + 1];
        //初始化，0和1没什么意义，2拆分后的最大乘积为1
        dp[2] = 1;
        //从下个值3开始运算
        for (int i = 3; i <= n; i++) {
            //这个循环是为了求出dp[i]的最大值，j只需要遍历到i的一半就够了，再往后遍历都是重复的
            //循环中的内容也可直接写成dp[i]=Math.max(Math.max(j*(i-j),j*dp[i-j]),dp[i])
            for (int j = 1; j <= i / 2; j++) {
                //这步是求当前j值得到的最大乘积
                //j * (i - j) 是单纯的把整数拆分为两个数相乘，而j * dp[i - j]是拆分成两个以及两个以上的个数相乘，dp[j]是
                int curMax = Math.max(j * (i - j), j * dp[i - j]);
                //然后比较是否需要更新dp[i]
                if (curMax > dp[i]) dp[i] = curMax;
            }
        }
        return dp[n];
    }

    /**
     * 贪心
     * 需要数学推导，尽可能拆分出最多的‘3’
     */
    public int interBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        result *= n;
        return result;
    }
}

