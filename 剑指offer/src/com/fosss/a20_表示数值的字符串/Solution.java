package com.fosss.a20_表示数值的字符串;

/**
 * @author fosss
 * date 2023/1/14
 * description：
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 数值 (按顺序) 可以分成以下几个部分:
 * 1.若干空格
 * 2.一个小数或者整数
 * 3.(可选) 一个e’或，E’，后面跟着一个整数
 * 4.若干空格
 * 小数(按顺序) 可以分成以下几个部分:
 * 1.(可选) 一个符号字符 (’+’ 或’-')
 * 2.下述格式之一:
 * 1.至少一位数字，后面跟着一个点
 * 2.至少一位数字，后面跟着一个点后面再跟着至少一位数字
 * 3.一个点，后面跟着至少一位数字
 * 整数 (按顺序) 可以分成以下几个部分
 * 1.(可选) 一个符号字符(’+’ 或，-’)
 * 2.至少一位数字
 * 部分数值列举如下:["+100"，"5e2"，"-123"，"3.1416，"-1E-16"，"0123"]
 * 部分非数值列举如下:["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 * <p>
 * 思路：
 * 1.编写两个辅助函数 1).判断是不是小数  2).判断是不是整数
 * 2.去掉字符串两边空格
 * 3.遍历字符串进行分情况讨论
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "+-.";
        boolean number = solution.isNumber(s);
        System.out.println("number = " + number);
    }

    public boolean isNumber(String s) {
        //去掉字符串两边的空格
        s = s.trim();
        //逐个判断
        int i = 0;
        //记录e处的下标
        int eIndex = -1;
        while (i < s.length()) {
            //获取索引为i处的字符，先找一下有没有e或E
            if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                eIndex = i;
            }
            i++;
        }
        //根据有没有e分别进行处理
        if (eIndex == -1) {
            //没有e,则判断这个字符串是不是数值
            if (!isADecimal(s) && !isAnInteger(s)) {
                //不是数值，返回false
                return false;
            }
        } else {
            //有e则判断e的左右两边是否符合
            //判断左边  一个小数或者整数
            String left = s.substring(0, eIndex);
            if (!isADecimal(left) && !isAnInteger(left)) {
                return false;
            }
            //判断右边  一个整数
            String right = s.substring(eIndex + 1, s.length());
            if (!isAnInteger(right)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是不是小数
     * 1.(可选) 一个符号字符 (’+’ 或’-')
     * 2.下述格式之一:
     * 1.至少一位数字，后面跟着一个点
     * 2.至少一位数字，后面跟着一个点后面再跟着至少一位数字
     * 3.一个点，后面跟着至少一位数字
     */
    private boolean isADecimal(String s) {
        if (s.length() == 0) {
            return false;
        }
        int i = 0;
        //跳过＋、-号
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            if (s.length() == 1) {
                //只有一个符号
                return false;
            }
            s = s.substring(1, s.length());
        }
        //记录‘.’的个数
        int count = 0;
        while (i < s.length()) {
            //获取索引为i处的字符
            char c = s.charAt(i);
            //判断是不是数字或点
            if (c >= '0' && c <= '9' || c == '.') {
                i++;
                //判断c是不是.
                if (c == '.') {
                    //.的个数加一
                    count++;
                    if (s.length() == 1 || count > 1) {
                        //说明字符串只有一个'.'或者字符串中有多个'.'
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是不是整数
     * 1.(可选) 一个符号字符(’+’ 或，-’)
     * 2.至少一位数字
     */
    private boolean isAnInteger(String s) {
        if (s.length() == 0) {
            return false;
        }
        int i = 0;
        //跳过＋、-号
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            if (s.length() == 1) {
                //只有一个符号
                return false;
            }
            s = s.substring(1, s.length());
        }
        while (i < s.length()) {
            char c = s.charAt(i);
            //判断c是不是0~9的数
            if (c >= '0' && c <= '9') {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }

}



















