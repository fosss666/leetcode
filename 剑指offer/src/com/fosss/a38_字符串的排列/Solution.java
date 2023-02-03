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
        //利用set集合判断字符是否重复,set的作用是防止字符串中有重复字符时影响排列结果(去除重复的结果)
        Set<Character> set = new HashSet<>();
        //set中存储的是拼接的字符串，这个for循环可以让chars中每个字符都出现在拼接后的字符串的每一位（x表示字符串的第几位）
        //过程是先固定第一位（有n种可能取值），再固定第二位（有n-1种可能取值），以此类推
        //看这个图 https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/solution/mian-shi-ti-38-zi-fu-chuan-de-pai-lie-hui-su-fa-by/
        //！！！回溯时x也会变为初始值，比如for循环种i到了=x+1的这个循环了，则此时x也为初始值0了，例如“abc”，i=b了，会在接下来的出现，索引1，2
        //处交换变成bac,接着索引1，3处交换变成cab,然后再恢复递归结束，再恢复交换变成abc,再然后i++,变成索引3处的c,如上类推（1，3交换，接着2，3交换）
        for (int i = x; i < chars.length; i++) {
            //当字符串存在重复字符时，排列方案中也存在重复的排列方案。为排除重复方案，需在固定某位字符时，保证 “每种字符只在此位固定一次” ，即遇
            //到重复字符时不交换，直接跳过。从 DFS 角度看，此操作称为 “剪枝”
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




















