package com.fosss.a48_最长不含重复字符的子字符串;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author fosss
 * @date 2023/2/13
 * @description： 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度
 * 例：
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 提示：s.length <= 40000
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.lengthOfLongestSubstring("dvdf");
        System.out.println("res = " + res);
    }

    /**
     * 自解，5% 5%
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





















