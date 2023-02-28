package com.fosss.a58_1_翻转单词顺序;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/2/28
 * Time: 12:46
 * Description:
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
 * 则输出"student. a am I"
 * 限制：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "II  am a student. ";
        String res = solution.reverseWords4(s);

        System.out.println("res = " + res);
        System.out.println(s.length());
        System.out.println(res.length());

    }

    /**
     * 分割+倒序   100%  63%
     */
    public String reverseWords4(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        //按照空格分割
        String[] arr = s.split(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            //多个连续空格以空格分割的话会形成空字符串，所以要跳过
            if (arr[i].equals("")) {
                continue;
            }
            sb.append(arr[i]).append(' ');
        }
        return sb.toString().trim();
    }

    /**
     * 双指针法  76%  86%
     */
    public String reverseWords3(String s) {
        s = s.trim();
        StringBuffer sb = new StringBuffer();
        int i = s.length() - 1, j = s.length() - 1;
        while (i >= 0) {
            //查找第一个空格
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s, i + 1, j + 1).append(" ");
            //去除空格间的多个空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }

        return sb.toString().trim();
    }

    /**
     * 自解，List记录单词再反转  35%  88%
     */
    public String reverseWords2(String s) {
        s = s.trim();
        List<String> list = new ArrayList<>();
        int i = 0, j = 0;
        while (j < s.length()) {
            if (s.charAt(j) == ' ' || j == s.length() - 1) {
                if (j == s.length() - 1) {
                    //substring是左开右闭的，j++才能添加到最后一个元素
                    j++;
                }
                list.add(s.substring(i, j));
                //更新i
                i = j + 1;
                //防止两个单词之间有多个空格
                while (i < s.length() && s.charAt(i) == ' ') {
                    i++;
                    //同步更新j
                    j++;
                }

            }
            //更新j
            j++;
        }
        StringBuffer sb = new StringBuffer();
        //倒叙拼接
        for (int k = list.size() - 1; k >= 0; k--) {
            sb.append(k == 0 ? list.get(k) : list.get(k) + " ");
        }
        return sb.toString();
    }


    /**
     * 自解，用StringBuilder拼接字符串  76%  54%
     */
    public String reverseWords(String s) {
        //先去除字符串两端空格
        s = s.trim();
        //使用StringBuilder拼接字符串
        StringBuilder newS = new StringBuilder();
        int k = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                //防止两个单词之间有多个空格
                if (s.charAt(i + 1) == ' ') {
                    //有多个空格，则进入下一个循环，此时相当于i--,则同时对应应该更新k,才能截取正确的单词
                    k--;
                    continue;
                }
                String substring = s.substring(i + 1, k);
                newS.append(substring).append(' ');
                //更新k
                k = i;
            }
        }
        //添加上最后一个单词
        newS.append(s, 0, k);
        return newS.toString();
    }
}




















