package com.fosss.a43_1到n整数中1出现的次数;

/**
 * @author fosss
 * @date 2023/2/7
 * @description： 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次   输入：n = 12  输出：5
 * 限制：1 <= n < 2^31
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.countDigitOne(12);
        System.out.println("res = " + res);
    }

    /**
     * 自解,for中套while,不出所料超时
     */
    public int countDigitOne(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp != 0) {
                if (temp % 10 == 1) {
                    count++;
                }
                temp /= 10;
            }
        }
        return count;
    }
}























