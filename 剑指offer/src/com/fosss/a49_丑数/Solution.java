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
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.nthUglyNumber(11);
        System.out.println("res = " + res);
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

    //找到一个数的因子
    private List<Integer> getFactors(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= n / 2; i++) {
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



























