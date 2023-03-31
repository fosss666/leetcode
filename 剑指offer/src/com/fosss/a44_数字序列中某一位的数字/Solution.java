package com.fosss.a44_数字序列中某一位的数字;

/**
 * @author fosss
 * @date 2023/2/8
 * @description： 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等
 * 请写一个函数，求任意第n位对应的数字
 * 例：输入：n = 3  输出：3
 * 限制：0 <= n < 2^31
 *
 * 思路：
 * 找规律题。。
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findNthDigit2(1000000000);
        System.out.println("res = " + res);
    }

    /**
     * 找规律题
     * 用long，因为int表示的范围不够
     *
     * 数字范围      位数      数字数量     数位数量
     * 1 - 9        1        9          9
     * 10 - 99      2        90         180
     * 100 - 999    3        900        2700
     * ...         ...       ...        ...
     * start~end   digit     9*start    9*start*dight
     */
    public int findNthDigit2(int n) {

        int digit = 1;
        long count = 9;
        long start = 1;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = 9 * digit * start;
        }
        //注意这里用long类型，int表示的范围太小！！！！!!!
        long num = start + (n - 1) / digit;
        char c = (num + "").charAt((n - 1) % digit);
        return Integer.parseInt(c + "");

        ////例如求第11个数，即n=11
        ////几位数
        //int digit = 1;
        ////几位数的第一个数，比如三位数的第一个数是100
        //long start = 1;
        ////几位数一共有多少个数位，比如两位数共有180位（90个数*两位）
        //long count = 9;
        //while (n > count) { // 1.  11>9成立
        //    n -= count;//n-=9,即n=2
        //    digit += 1;//digit=2
        //    start *= 10;//start=10
        //    count = digit * start * 9;//count=180
        //}
        ////要找的那位在那个数上,注意这里用long类型，int表示的范围太小！！！！！！！
        //long num = start + (n - 1) / digit; // 2.  num=10+1/2=10
        ////要找的那一位是这个数的哪一位
        //return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.  res=num.charAt(1%2)=0

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
        return Integer.parseInt(s.charAt(n) + "");
    }
}















