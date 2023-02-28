package com.fosss.a58_1_翻转单词顺序;

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
        String s = "II am a student. ";
        String res = solution.reverseWords(s);
        System.out.println("res = " + res);
        System.out.println(s.length());
        System.out.println(res.length());
    }

    /**
     * 自解，用StringBuilder拼接字符串，超出内存限制
     */
    public String reverseWords(String s) {
        StringBuilder newS = new StringBuilder();
        int k = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                //防止两个单词之间有多个空格
                while (s.charAt(i) == ' ') {
                    i++;
                }
                String substring = s.substring(i, k);
                newS.append(substring).append(' ');
                //更新k
                k = i;
            }
        }
        //添加上最后一个单词
        newS.append(s, 0, k);
        return newS.toString().trim();
    }
}




















