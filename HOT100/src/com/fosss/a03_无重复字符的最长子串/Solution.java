package com.fosss.a03_无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: fosss
 * Date: 2023/4/24
 * Time: 11:41
 * Description:给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度
 * 示例：
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println("res = " + res);
    }

    /**
     * 自解，动态规划记录左临近的最长字符串，map标记是否重复  87%  25%
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        //map用来标记每个字符的下标，字符重复的话就记录下标大的
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        //动态规划数组
        //int[] dp = new int[s.length()];
        //dp[0] = 1;
        int dp = 0;
        //标记最大值
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                dp = dp + 1;
            } else {
                //需要判断那个前面出现过的字符是不是已经包含在已经统计过的字符串中了
                Integer l = map.get(chars[i]);
                if (i - l > dp) {
                    //不在当前统计的字符串的范围内，相当于不重复
                    dp = dp + 1;
                } else {
                    dp = i - l;
                }
            }
            max = Math.max(max, dp);
            map.put(chars[i], i);
        }
        return max;
    }
}


















