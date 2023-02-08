package com.fosss.a44_数字序列中某一位的数字;

/**
 * @author fosss
 * @date 2023/2/8
 * @description： 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等
 * 请写一个函数，求任意第n位对应的数字
 * 例：输入：n = 3  输出：3
 * 限制：0 <= n < 2^31
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findNthDigit(11);
        System.out.println("res = " + res);
    }

    /**
     * 自解，构造字符串，超出内存限制。。。。。
     */
    public int findNthDigit(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= n; i++) {
            sb.append(i);
        }
        String s = sb.toString();
        return Integer.parseInt(s.charAt(n)+"");
    }
}















