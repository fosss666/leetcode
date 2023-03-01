package com.fosss.a58_2_左旋转字符串;

/**
 * @author: fosss
 * Date: 2023/3/1
 * Time: 11:03
 * Description:
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"
 * 限制：1 <= k < s.length <= 10000
 * 思考：
 * String的substring方法底层是new String(value, beginIndex, subLen) 新建字符串
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String res = solution.reverseLeftWords3("abcdefg", 2);
        System.out.println("res = " + res);
    }

    /**
     * 自解，直接截取拼接 100%  47%
     */
    public String reverseLeftWords3(String s, int n) {
        return s.substring(n) + s.substring(0, n);
        //StringBuilder sb = new StringBuilder();
        //sb.append(s, 0, n);
        //return s.substring(n) + sb;
    }

    /**
     * 自解，不利用StringBuilder拼接字符串  5%  5%
     */
    public String reverseLeftWords2(String s, int n) {
        for (int i = 0; i < n; i++) {
            s += s.charAt(0);
            s = s.substring(1);
        }
        return s;
    }

    /**
     * 自解，拼接字符串   6%  48%
     */
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for (int i = 0; i < n; i++) {
            //添加到尾部
            sb.append(s.charAt(i));
            //删除头部
            sb.delete(0, 1);
        }
        return sb.toString();
    }
}



















