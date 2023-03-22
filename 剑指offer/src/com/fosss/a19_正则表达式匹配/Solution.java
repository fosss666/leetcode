package com.fosss.a19_正则表达式匹配;

/**
 * @author: fosss
 * Date: 2023/3/22
 * Time: 12:41
 * Description:请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配
 * 示例1：输入: s = "aa" p = "a" 输出: false 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例2：输入: s = "aa" p = "a*" 输出: true 解释:因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例3：输入: s = "ab" p = ".*" 输出: true 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例4：输入: s = "aab" p = "c*a*b" 输出: true 解释:因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例5：输入: s = "mississippi" p = "mis*is*p*." 输出: false
 * 提示：s 可能为空，且只包含从 a-z 的小写字母；p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'
 */
public class Solution {

    /**
     * 动态规划
     * 题目中的匹配是一个「逐步匹配」的过程：我们每次从字符串p 中取出一个字符或者「字符 + 星号」的组合，并在s 中进行匹配。对于p 中一个字符而言，
     * 它只能在s 中匹配一个字符，匹配的方法具有唯一性；而对于p 中字符 + 星号的组合而言，它可以在s 中匹配任意自然数个字符，并不具有唯一性。因此
     * 我们可以考虑使用动态规划，对匹配的方案进行枚举
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        //f[i][j]表示s的前i个字符和p的前j个字符是否匹配
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    /**
     * matches(x,y) 判断两个字符是否匹配的辅助函数。只有当y是 . 或者x和y本身相同时，这两个字符才会匹配
     */
    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}






















