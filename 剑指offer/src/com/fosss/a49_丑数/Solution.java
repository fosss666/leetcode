package com.fosss.a49_丑数;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fosss
 * @date 2023/2/15
 * @description： 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数
 * 例：
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明：1是丑数。n不超过1690
 * <p>
 * 思路:
 * 1.将num的因子获取到，判断是不是只有2，3，5。获取时需要注意，因子能整除已获取的因子时，不需要将该因子放到因子集合中。此方法超时。
 * 2.对每个数，判断他是不是丑数（能整除（2、3、5）的时候就一直除，最后判断结果是不是1，是1则说明是丑数），是的话count++,一直到count==n时结束。此方法超时。
 * 3.动态规划。原理：丑数 = 某较小丑数×某因子。
 * dp[i]表示第（i+1）个丑数。dp[i]就等于他之前没有使用过的3个丑数*(2或3或5)中较小的那个值
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.nthUglyNumber3(11);
        System.out.println("res = " + res);
    }

    /**
     * 动态规划
     * 丑数的递推性质： 丑数只包含因子 2,3,5 ，因此有 “丑数 = 某较小丑数× 某因子” （例如：10=5×2）
     */
    public int nthUglyNumber3(int n) {
        int a = 0, b = 0, c = 0;
        //dp[i]表示第（i+1）个丑数
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            //“丑数 = 某较小丑数× 某因子"
            //最小的那个即为下一位丑数
            dp[i] = Math.min(Math.min(dp[a] * 2, dp[b] * 3), dp[c] * 5);
            //判断a,b,c数进行了上面的处理
            if (dp[i] == dp[a] * 2) {
                a++;
            }
            if (dp[i] == dp[b] * 3) {
                b++;
            }
            if (dp[i] == dp[c] * 5) {
                c++;
            }
        }
        return dp[n - 1];
    }

    /**
     * 自解，整除判断,超时。。。玛德
     */
    public int nthUglyNumber2(int n) {
        if (n <= 6) {
            return n;
        }
        int count = 6;
        int i = 7;
        while (count < n) {
            int temp = i;
            while (temp % 2 == 0) {
                temp /= 2;
            }
            while (temp % 3 == 0) {
                temp /= 3;
            }
            while (temp % 5 == 0) {
                temp /= 5;
            }
            if (temp == 1) {
                count++;
            }
            i++;
        }
        return i - 1;//while中最后i多++了一次，所以要减回来
    }

    /**
     * 自解，超时。。。
     */
    public int nthUglyNumber(int n) {
        //判断n的因子是否只有2，3，5
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        //1, 2, 3, 4, 5, 6是连续的丑数，所以可以通过这样优化时间
        if (n <= 6) {
            return n;
        }
        //返回第n个丑数
        int count = 6;//1，2,3,4,5,6是连续的丑数，所以可以通过这样优化时间
        int num = 7;
        while (true) {
            List<Integer> factors = getFactors(num);
            if (factors.size() > 0 && list.containsAll(factors)) {
                //是丑数
                count++;
                if (count == n) {
                    break;
                }
            }
            num++;
        }
        return num;
    }

    //找到一个数的因子（因子的因子不能是res中的）
    private List<Integer> getFactors(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                //8的因子有4，但是4的因子只有2，所以8也是丑数
                //是因子，判断i的因子是否由res中的数组成
                if (res.size() == 0) {
                    res.add(i);
                }
                boolean flag = true;
                for (int j = 0; j < res.size(); j++) {
                    if (i % res.get(j) == 0) {
                        //是的话，不能添加到集合中
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}



























