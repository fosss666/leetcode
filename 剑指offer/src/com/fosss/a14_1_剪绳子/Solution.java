package com.fosss.a14_1_剪绳子;

/**
 * @author fosss
 * date 2023/1/10
 * description：
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大
 * 乘积是18。
 * 例：输入: 2  输出: 1  解释: 2 = 1 + 1, 1 × 1 = 1   输入: 10 输出: 36 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：2 <= n <= 58
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.cuttingRope(10);
        System.out.println("i = " + i);
    }

    /**
     * 动态规划
     */
    /**
     * 这道题给定一个大于 1 的正整数 n，要求将 n 拆分成至少两个正整数的和，并使这些正整数的乘积最大化，返回最大乘积。
     * 令 x 是拆分出的第一个正整数，则剩下的部分是n−x，n−x 可以不继续拆分，或者继续拆分成至少两个正整数的和。由于每个正整数对应的最大
     * 乘积取决于比它小的正整数对应的最大乘积，因此可以使用动态规划求解。
     * * 创建数组dp，其中dp[i] 表示将正整数 i 拆分成至少两个正整数的和之后，这些正整数的最大乘积。特别地，0不是正整数，1 是最小的正整数，
     * 0和 1 都不能拆分，因此 dp[0]=dp[1]=0。
     * 当 i≥2 时，假设对正整数 i 拆分出的第一个正整数是 j（1≤j<i），则有以下两种方案：
     * *将 i拆分成 j 和 i-j 的和，且 i-j不再拆分成多个正整数，此时的乘积是 j×(i−j)；
     * *将 i拆分成 j 和 i-j 的和，且 i-j继续拆分成多个正整数，此时的乘积是 j×dp[i−j]。
     */
    public int cuttingRope(int n) {
        //创建数组保存最大值
        int[] max = new int[n + 1];
        //从2递推到n
        for (int m = 2; m <= n; m++) {
            int curMax = 0;//记录长度为1~m-1时最长的
            //每段的长度可为1~m-1
            for (int i = 1; i < m; i++) {
                curMax = Math.max(curMax, Math.max(i * (m - i), i * max[m - i]));
            }
            max[m] = curMax;
        }
        return max[n];
    }
}

















