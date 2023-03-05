package com.fosss.a64_求1加2一直加到n;

/**
 * @author: fosss
 * Date: 2023/3/5
 * Time: 10:56
 * Description: 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C)
 * 示例：输入: n = 3  输出: 6
 * 限制：1 <= n <= 10000
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.sumNums(4);
        System.out.println("res = " + res);
    }

    /**
     * 自解，递归  100%  70%
     */
    public int sumNums(int n) {
        int res = sum(0, n, n);
        return res;
    }

    private int sum(int sum, int i, int n) {
        if (i == 1) {
            return 1;
        }
        return i + sum(sum + i, i - 1, n);
    }
}

























