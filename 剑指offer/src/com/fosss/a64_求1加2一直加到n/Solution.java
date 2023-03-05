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
        int res = solution.sumNums2(4);
        System.out.println("res = " + res);
    }

    /**
     * 正确解法，利用运算符的短路效应替换到递归解法中的if判断    21%  46%
     * if(A && B)  // 若 A 为 false ，则 B 的判断不会执行（即短路），直接判定 A && B 为 false
     * if(A || B) // 若 A 为 true ，则 B 的判断不会执行（即短路），直接判定 A || B 为 true
     * n > 1 && sumNums(n - 1) // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
     */
    int res = 0;

    public int sumNums2(int n) {
        //这个布尔变量是没有实际用处的，知识为了让这段代码不报错  sumNums2(n - 1)>0的判断也没有实际意义，只是为了凑这个与运算
        boolean flag = (n > 1) && (sumNums2(n - 1) > 0);
        //n==1的时候，停止n>1这个条件为false，则不执行&&右边的递归操作，即递归终止
        res += n;
        return res;

    }


    /**
     * 自解，递归   用到了if或三目运算符,不符合要求
     */
    public int sumNums(int n) {

        return (n == 0) ? 0 : (n + sumNums(n - 1));

        //int res = sum(0, n, n);
        //return res;
    }

    //private int sum(int sum, int i, int n) {
    //    if (i == 1) {
    //        return 1;
    //    }
    //    return i + sum(sum + i, i - 1, n);
    //}
}

























