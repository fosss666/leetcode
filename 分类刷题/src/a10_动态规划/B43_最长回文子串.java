package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/10/15
 * Time: 14:23
 * Description:
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * 提示：
 * 1 <= s.length <= 1000
 */
public class B43_最长回文子串 {

    /**
     * 思路同回文子串，不过本题不是记录回文子串数量，而是记录最长回文子串
     */
    public String longestPalindrome(String s) {
        //dp[i][j]表示：下标从i~j的字符串是不是回文子串
        boolean[][] dp = new boolean[s.length()][s.length()];
        //记录最长回文子串的长度
        int len = 0;
        //记录最长回文子串
        String res = "";
        for (int i = s.length() - 1; i >= 0; i--) {//注意遍历顺序
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1 || dp[i + 1][j - 1]) {
                        //对应第1、2中情况
                        dp[i][j] = true;
                        //判断是否要更新结果
                        if (j - i + 1 > len) {
                            len = j - i + 1;
                            res = s.substring(i, j + 1);
                        }

                    }
                }
            }
        }
        return res;
    }
}
