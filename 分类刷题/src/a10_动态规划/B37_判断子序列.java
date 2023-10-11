package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/10/10
 * Time: 18:56
 * Description:
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 示例 1：
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * 提示：
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 */
public class B37_判断子序列 {

    /**
     * 同最长公共子序列的解法
     */
    public boolean isSubsequence(String s, String t) {
        //dp[i][j]表示s从0~i-1与t从0~j-1元素相同的个数
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    //s和t此处元素相同，dp[i][j]赋值成s从0~i-2的子序列与t从0~j-2的子序列的公共长度+1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //由于s是要进行匹配的字符串，所以要从t中找s对应的字符，此时j处不符合，则dp[i][j]赋值成s从0~i-1的子序列与t从0~j-2的子
                    //序列的公共长度即可。即模拟从t中删除j-1这个元素
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        //判断是否将s的所有元素都匹配上了
        return dp[s.length()][t.length()] == s.length();
    }

}
