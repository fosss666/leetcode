package com.fosss.a50_第一个只出现一次的字符;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fosss
 * @date 2023/2/16
 * @description： 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母
 * 例：输入：s = "abaccdeff"  输出：'b'
 * 限制：0 <= s 的长度 <= 50000
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char res = solution.firstUniqChar("loveleetcode");
        System.out.println("res = " + res);
    }

    /**
     * 自解，暴力遍历  5% 11%
     */
    public char firstUniqChar(String s) {
        if (s.length() == 1) {
            return s.charAt(0);
        }
        //转成集合，便于遍历和删除
        List<Character> list = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        //遍历集合,i用来遍历，j用来记录遍历开始的位置
        int i = 1, j = 0;
        while (j < list.size()) {

            if (list.get(i).equals(list.get(0))) {
                //字符相同，不符合要求，从集合中删除该字符
                int finalI = i;
                //这里要对list重新赋值
                List<Character> finalList = list;
                list = list.stream().filter((item) -> {
                    return !item.equals(finalList.get(finalI));
                }).collect(Collectors.toList());
                i = 1;
            } else {
                i++;
            }
            //如果i的长度达到集合长度，说明此时j处的字符是符合要求的，直接返回
            if (i == list.size()) {
                return list.get(j);
            }
        }
        //j的长度达到集合长度，说明没有符合要求的字符，返回空格
        return ' ';
    }
}


























