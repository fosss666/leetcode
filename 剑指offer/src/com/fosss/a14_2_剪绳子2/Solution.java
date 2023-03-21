package com.fosss.a14_2_剪绳子2;

/**
 * @author: fosss
 * Date: 2023/3/20
 * Time: 21:48
 * Description:给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1]。
 * 请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1
 * 示例：输入: 10  输出: 36  解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：2 <= n <= 1000
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.cuttingRope(120);
        System.out.println("res = " + res);
    }

    /**
     * 数学推导
     */
    public int cuttingRope(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int res = n / 3;
        int mod = n % 3;
        int p = 1000000007;
        if (mod == 0) {
            return (int) pow(3, res);
        } else if (mod == 1) {
            //说明除了3外，还剩下一个4
            return (int) (pow(3, res - 1) * 4 % p);
        } else {
            //mod==2  还剩下一个2
            return (int) (pow(3, res) * 2 % p);
        }
    }

    /**
     * 求幂
     * 注意需要用long,防止超出int范围
     */
    private long pow(int x, int n) {
        long res = 1;
        int p = 1000000007;
        for (int i = 0; i < n; i++) {
            res = (res * x) % p;
        }
        return res;
    }
}




















