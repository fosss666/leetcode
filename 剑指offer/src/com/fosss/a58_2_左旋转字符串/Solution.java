package com.fosss.a58_2_左旋转字符串;

/**
 * @author: fosss
 * Date: 2023/3/1
 * Time: 11:03
 * Description:
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"
 * 限制：1 <= k < s.length <= 10000
 *
 */
public class Solution {

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



















