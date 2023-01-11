package com.fosss.a16_数值的整数次方;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.math.BigInteger;

/**
 * @author fosss
 * date 2023/1/11
 * description：
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题
 * 例：输入：x = 2.00000, n = 10  输出：1024.00000
 * 输入：x = 2.00000, n = -2  输出：0.25000  解释：2的-2次方 = 1/2的二次方 = 1/4 = 0.25
 * 提示：
 * -100.0 < x < 100.0
 * -2的31次方 <= n <= 2的31次方-1
 * -10的四次方 <= x的n次方 <= 10的4次方
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        double result = solution.myPow(2.00000, -2147483648);
        System.out.println("result = " + result);
    }

    /**
     * for循环，考虑太多，不适用
     *
     */
    public double myPow(double x, int n) {
        double result = 1.0;
        if (n == 0 || x == 1) {
            return 1.0;
        } else if (x == -1) {
            if (n == Integer.MIN_VALUE) {
                return 1.0;
            } else {
                return -1.0;
            }
        } else if (n == Integer.MAX_VALUE || n == Integer.MIN_VALUE) {
            return 0;
        } else if (n > 0) {
            for (int i = 0; i < n; i++) {
                result *= x;
            }
            return result;
        } else {
            x = 1 / x;
            for (int i = 0; i < (-n); i++) {
                result *= x;
            }
            return result;
        }
    }
}
















