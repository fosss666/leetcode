package com.fosss.a42_连续子数组的最大和;

/**
 * @author fosss
 * @date 2023/2/6
 * @description： 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值  要求时间复杂度为O(n)
 * 例：输入: nums = [-2,1,-3,4,-1,2,1,-5,4] 输出: 6  解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 * 提示：1 <= arr.length <= 10^5   -100 <= arr[i] <= 100
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution solution = new Solution();
        int res = solution.maxSubArray(nums);
        System.out.println("res = " + res);
    }

    /**
     * 动态规划
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //判断上一个值是正数还是负数，负数的话就用0代替
            int pre = Math.max(nums[i - 1], 0);
            //nums[i]加上上一个数
            nums[i] += pre;
            //更新res
            res = Math.max(nums[i], res);
        }
        return res;
    }
}






















