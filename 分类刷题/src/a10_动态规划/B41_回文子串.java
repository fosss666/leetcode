package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/10/14
 * Time: 13:32
 * Description:
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * 示例 1：
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * 提示：输入的字符串长度不会超过 1000 。
 */
public class B41_回文子串 {

    /**
     * 动规法
     */
    public int countSubstrings2(String s) {
        //dp[i][j]表示：下标从i~j的字符串是不是回文子串
        boolean[][] dp = new boolean[s.length()][s.length()];
        //需要对s[i]是否与s[j]相等来判断是不是回文子串，不相等时肯定为false，相等时可分为三种情况：
        // 1. i==j，即只有一个字符，那么一定是回文子串
        // 2. j-i==1，即只有两个字符，“aa”这种情况，一定是回文子串
        // 3. j-i>1，有两个以上的字符，因为s[i]==s[j]，所以只需要判断[i+1,j-1]这部分是不是回文子串就可判断[i,j]是不是，需要用到
        //    dp[i+1][j-1]的结果，所以应该提前将这个结果计算出来，在二维数组中，这个结果位于dp[i][j]的左下角，所以可以确定递推公式
        //    的遍历顺序为从下到上，从左到右

        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {//注意遍历顺序
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1 || dp[i + 1][j - 1]) {
                        //对应第1、2中情况
                        count++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return count;
    }


    /**
     * 暴力法    5%   6%
     */
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (isSubstrings(s.substring(j, i + 1))) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 判断字符串是不是回文子串
     */
    private boolean isSubstrings(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
