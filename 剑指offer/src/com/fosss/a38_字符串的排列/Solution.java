package com.fosss.a38_字符串的排列;

import java.util.*;

/**
 * @author fosss
 * @date 2023/2/2
 * @description： 输入一个字符串，打印出该字符串中字符的所有排列。你可以以任意顺序返回这个字符串数组，但里面不能有重复元素
 * 例：输入：s = "abc"  输出：["abc","acb","bac","bca","cab","cba"]
 * 限制：1 <= s 的长度 <= 8
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = solution.permutation("abc");
        System.out.println(Arrays.toString(strings));
    }

    /**
     * 回溯法（k神）,深度优先算法
     */
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        List<String> res = new ArrayList<>();
        dfs(0, chars, res);
        return res.toArray(new String[res.size()]);
    }

    /**
     * @param x     字符数组中被固定的字符
     * @param chars 字符数组
     * @param res   排列结果
     */
    private void dfs(int x, char[] chars, List<String> res) {
        //递归结束条件-x到达最后一个字符时
        if (x == chars.length - 1) {
            //添加排列
            res.add(String.valueOf(chars));
            return;
        }
        //利用set集合判断字符是否重复
        Set<Character> set = new HashSet<>();
        for (int i = x; i < chars.length; i++) {
            //字符不重复，则进行下一步处理
            if (!set.contains(chars[i])) {
                //拼接字符串
                set.add(chars[i]);
                //交换
                swap(i, x, chars);
                //递归
                dfs(x + 1, chars, res);
                //恢复交换
                swap(i, x, chars);
            }
        }

    }

    /**
     * 字符位置交换
     */
    private void swap(int i, int x, char[] chars) {
        char c = chars[i];
        chars[i] = chars[x];
        chars[x] = c;
    }

}




















