package com.fosss.a17_打印从1到最大的n位数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author fosss
 * date 2023/1/12
 * description：
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999
 * 例：输入: n = 1  输出: [1,2,3,4,5,6,7,8,9]
 * 说明：用返回一个整数列表来代替打印
 * n 为正整数
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.printNumbers(2);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 自解
     */
    public int[] printNumbers(int n) {
        if (n == 0) {
            return new int[0];
        }
        int s = (int) Math.pow(10.0, n);
        int[] arr = new int[s - 1];
        for (int i = 0; i < s-1; i++) {
            arr[i]=i+1;
        }
        return arr;
    }
}
















