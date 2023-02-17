package com.fosss.a51_数组中的逆序对;

/**
 * @author fosss
 * @date 2023/2/17
 * @description： 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数
 * 例：输入: [7,5,6,4]  输出: 5
 * 限制：0 <= 数组长度 <= 50000
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        Solution solution = new Solution();
        int res = solution.reversePairs(nums);
        System.out.println("res = " + res);
    }


    /**
     * 自解，不管怎么样，先暴力一下,超出时间限制
     */
    public int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}










