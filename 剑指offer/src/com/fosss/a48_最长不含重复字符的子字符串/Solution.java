package com.fosss.a48_最长不含重复字符的子字符串;

import java.util.*;

/**
 * @author fosss
 * @date 2023/2/13
 * @description： 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度
 * 例：
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 提示：s.length <= 40000
 * <p>
 * 思路：
 * 动态规划，dp[i]表示遍历到下标为i时的子字符串长度,初始化dp[0]=1表示遍历到第一个字符时，子字符串的长度为1。借助map来判断字符是否重复，键为字符，值为该字符在
 * 字符串中的下标。在遍历字符串的各个字符时，如果map中不存在该字符，则dp[i]=dp[i-1]+1；若存在该字符，则需要分情况讨论，如果该字符下标i-重复的字符下标
 * k>dp[i-1]，则说明该重复的字符是之前已经判断过的了（即已经算到其他子字符串长度里边去了，而现在正在判断一个新的子字符串，即该字符在目前这个子字符串中还没有出现
 * 过，对目前这个子字符串来说不是重复的），对目前正在增加长度的子字符串长度没有影响，dp[i]=dp[i-1]+1,否则dp[i]=i-k。
 * 小技巧，在循环外将子字符串的最长长度变量定义出来，每次遍历时与dp[i]进行比较取大值，这样之后就不用再去遍历dp数组找最大值了
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.lengthOfLongestSubstring2("abcabcbb");
        System.out.println("res = " + res);
    }

    /**
     * 动态规划-优化dp所占空间
     */
    public int lengthOfLongestSubstring3(String s) {
        if (s.length() == 0) {
            return 0;
        }
        //用哈希表判断字符是否出现过（是否重复）
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        //用变量代替dp数组
        //dp[0] = 1;//初始化以第一个字符结尾的子字符串的长度为1
        int dp = 1;
        //最长子字符串
        int res = 1;
        for (int i = 1; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                //如果哈希表中字符没有重复，则i处的长度为上一个字符的长度+1
                dp = dp + 1;
            } else {
                //哈希表中有该字符，则根据上一个字符dp[i-1]是否在这两个重复的字符之间的区间 来设置dp[i]的值
                //i - k <= dp[i - 1]可以画图看出来这个公式表示下标k处的字符在dp[i-1]这个长度的字符串区间外
                Integer k = map.get(s.charAt(i));
                dp = i - k <= dp ? i - k : dp + 1;
            }
            //更新哈希表
            map.put(s.charAt(i), i);
            //更新res
            res = Math.max(res, dp);
        }
        return res;
    }

    /**
     * 动态规划
     * dp[i]表示以字符s[i]结尾的子字符串的长度
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        //用哈希表判断字符是否出现过（是否重复）
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        //创建dp数组,dp[i]表示以字符s[i]结尾的子字符串的长度
        int[] dp = new int[s.length()];
        dp[0] = 1;//初始化以第一个字符结尾的子字符串的长度为1
        //最长子字符串
        int res = 1;
        for (int i = 1; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                //如果哈希表中字符没有重复，则i处的长度为上一个字符的长度+1
                dp[i] = dp[i - 1] + 1;
            } else {
                //哈希表中有该字符，则根据上一个字符dp[i-1]是否在这两个重复的字符之间的区间 来设置dp[i]的值

                // i - k <= dp[i - 1]可以画图看出来这个公式表示k在dp[i-1]这个长度的字符串区间外
                Integer k = map.get(s.charAt(i));
                dp[i] = i - k <= dp[i - 1] ? i - k : dp[i - 1] + 1;
            }
            //更新哈希表
            map.put(s.charAt(i), i);
            //更新res
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 自解，暴力求解 5% 5%
     */
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        List<Set<Character>> res = new ArrayList<>();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                i++;
            } else {
                res.add(set);
                set = new HashSet<>();
                j++;
                i = j;
            }
        }
        //最后i退出时的set还没有放到res中
        res.add(set);
        int max = 0;
        Set<Character> r = new HashSet<>();
        for (Set<Character> se : res) {
            if (se.size() > r.size()) {
                r = se;
                max = se.size();
            }
        }
        return max;
    }
}





















