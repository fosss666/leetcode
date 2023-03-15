package com.fosss.a67_把字符串转换成整数;

/**
 * @author: fosss
 * Date: 2023/3/15
 * Time: 11:21
 * Description:写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将
 * 其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0
 * <p>
 * 示例1：输入: "   -42" 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42
 * 示例2： 输入: "4193 with words"  输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例3：输入: "-91283472332" 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。因此返回 INT_MIN (−231) 。
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "010";
        int res = solution.strToInt(s);
        System.out.println("res = " + res);
    }

    /**
     *  自解  面向测试编程   20%  35%
     */
    public int strToInt(String str) {
        //去除开头空格
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        //获取符号
        char symbol = '+';
        //防止连续是正负号的情况  “+-2”
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            if (str.length() == 1 || str.charAt(1) < '0' || str.charAt(1) > '9') {
                return 0;
            }
            symbol = str.charAt(0);
            str = str.substring(1);
        }

        //跳过开始的0
        while (str.length() > 0 && str.charAt(0) == '0') {
            //防止 "0-1"这种情况
            if (str.length() > 1 && (str.charAt(1) == '+' || str.charAt(1) == '-')) {
                return 0;
            }
            str = str.substring(1);

        }
        if (str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int start = -1, end = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                if (start == -1) {
                    start = i;
                }
                end = i;
            } else {
                break;
            }
        }
        if (chars[end] < '0' || chars[end] > '9') {
            return 0;
        }
        String s = str.substring(start, end + 1);
        if (s.length() > String.valueOf(Integer.MAX_VALUE).length() || Long.parseLong(s) > Integer.MAX_VALUE) {
            return symbol == '+' ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            int res = Integer.parseInt(s);
            return symbol == '+' ? res : -res;
        }
    }
}


















