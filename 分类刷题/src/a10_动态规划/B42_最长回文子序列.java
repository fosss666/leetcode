package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/10/15
 * Time: 13:38
 * Description:
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 * 示例 1: 输入: "bbbab" 输出: 4 一个可能的最长回文子序列为 "bbbb"。
 * 示例 2: 输入:"cbbd" 输出: 2 一个可能的最长回文子序列为 "bb"。
 * 提示：
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母
 */
public class B42_最长回文子序列 {
    public static void main(String[] args) {
        B42_最长回文子序列 test = new B42_最长回文子序列();
        int res = test.longestPalindromeSubseq("cbbd");
        System.out.println("res = " + res);
    }

    /**
     * 动规    24%   7%
     */
    public int longestPalindromeSubseq(String s) {
        //dp[i][j]表示：[i,j] 处的最长回文子序列长度
        int[][] dp = new int[s.length()][s.length()];

        //注意遍历顺序，递推公式要用到i+1和j-1所以应该从下向上遍历
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    //只有一个字符时，长度为一
                    dp[i][j] = 1;
                } else {
                    //长度超过1个字符，如果两端字符相等，则在[i+1,j-1]字符长度基础上加2
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        //不相等，说明首尾加上这俩字符后不是回文序列，那么分别加入s[i]、s[j]看看哪一个可以组成最长的回文子序列，取大的
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
