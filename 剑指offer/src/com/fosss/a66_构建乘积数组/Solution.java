package com.fosss.a66_构建乘积数组;

import java.util.Arrays;

/**
 * @author: fosss
 * Date: 2023/3/7
 * Time: 15:27
 * Description: 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即
 * B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法
 * 示例：输入: [1,2,3,4,5]  输出: [120,60,40,30,24]
 * 提示：所有元素乘积之和不会溢出 32 位整数； a.length <= 100000
 * <p>
 * 思路：
 * 不能用除法，也就不能用所有数的乘积除以当前值的方法
 * 解法：动态规划，分别求i左侧的乘积和i右侧的乘积，最后再乘起来。
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        int[] res = solution.constructArr(nums);
        System.out.println("res = " + Arrays.toString(res));
    }

    /**
     * 分别求出i的左侧乘积和右侧乘积，再乘起来          29%  96%
     */
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        //返回结果组合
        int[] b = new int[a.length];
        //左侧乘积
        int[] left = new int[a.length];
        //右侧乘积
        int[] right = new int[a.length];

        //初始化第一个数左侧乘积为1，最后一个数右侧乘积为1
        left[0] = 1;
        right[a.length - 1] = 1;

        //求i左侧的数乘积
        for (int i = 1; i < a.length; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        //求i右侧的数乘积
        for (int i = a.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        //求总乘积
        for (int i = 0; i < a.length; i++) {
            b[i] = left[i] * right[i];
        }
        return b;
    }
}

















