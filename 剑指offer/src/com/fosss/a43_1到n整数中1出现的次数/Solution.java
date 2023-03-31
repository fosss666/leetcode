package com.fosss.a43_1到n整数中1出现的次数;

/**
 * @author fosss
 * @date 2023/2/7
 * @description： 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次   输入：n = 12  输出：5
 * 限制：1 <= n < 2^31
 *
 * 思路：
 * 相当于找规律问题.. 分情况判断
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.countDigitOne2(12);
        System.out.println("res = " + res);
    }

    /**
     * k神，分别判断
     */
    public int countDigitOne2(int n) {
        //digit代表当前位数（个十百千万）
        int digit = 1, res = 0;
        //high代表当前位左边的所有数,low代表当前位右边的所有数 cur代表当前位是数字几
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                //推出来的公式
                res += high * digit;
            } else if (cur == 1) {
                //推出来的公式
                res += high * digit + low + 1;
            } else {
                //推出来的公式
                res += (high + 1) * digit;
            }
            //更新各变量
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
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























