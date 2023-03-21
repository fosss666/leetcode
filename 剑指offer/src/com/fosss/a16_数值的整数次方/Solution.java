package com.fosss.a16_数值的整数次方;


/**
 * @author fosss
 * date 2023/1/11
 * description：
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。不得使用库函数，同时不需要考虑大数问题
 * 例：输入：x = 2.00000, n = 10  输出：1024.00000
 * 输入：x = 2.00000, n = -2  输出：0.25000  解释：2的-2次方 = 1/2的二次方 = 1/4 = 0.25
 * 提示：
 * -100.0 < x < 100.0
 * -2的31次方 <= n <= 2的31次方-1
 * -10的四次方 <= x的n次方 <= 10的4次方
 *
 * 思路：
 * 根据n是否能被2整除乘以不同的贡献量
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        double result = solution.myPow3(2.00000, 4);
        System.out.println("result = " + result);
    }

    /**
     * 快速幂+迭代
     */
    public double myPow3(double x, int n) {
        long N=n;
        return N > 0 ? iteration(x, N) : 1.0 / iteration(x, -N);
    }

    private double iteration(double x, long n) {
        double result = 1.0;
        //贡献量初始为x
        double contribution = x;
        while (n > 0) {
            if (n % 2 == 1) {
                //n不能整除2，则结果要乘贡献量
                result *= contribution;
            }
            //每个循环贡献量都要随x平方
            contribution *= contribution;
            n /= 2;
        }
        return result;
    }

    /**
     * 快速幂+递归
     */
    /**
     * 当我们要计算 x的n次方时，我们可以先递归地计算出 y = x的[n/2]次方，其中 [a] 表示对 a 进行下取整:
     * 根据递归计算的结果，如果 n 为偶数，那么 x的n次方= y的平方;如果 n 为奇数，那么 x的n次方=y的平方*x
     * 递归的边界为 n = 0，任意数的 0 次方均为 1
     */
    public double myPow2(double x, int n) {
        //要转为long，因为int最小值为-2^31,最大值为2^31-1,所以负数为最小值时不能直接转为正数！！
        long N=n;
        //x<0则求出-x的n次方再取倒数
        return N > 0 ? recursion(x, N) : 1.0 / recursion(x, -N);
    }

    private double recursion(double x, long n) {
        //结束条件
        if (n == 0) {
            return 1.0;
        }
        double y = recursion(x, n / 2);
        //根据n是否能够整除2进行不同的计算
        return n % 2 == 0 ? y * y : y * y * x;
    }

    /**
     * for循环，考虑太多，不适用
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
















