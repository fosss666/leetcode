package com.fosss.a42_连续子数组的最大和;

/**
 * @author fosss
 * @date 2023/2/6
 * @description： 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值  要求时间复杂度为O(n)
 * 例：输入: nums = [-2,1,-3,4,-1,2,1,-5,4] 输出: 6  解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 * 提示：1 <= arr.length <= 10^5   -100 <= arr[i] <= 100
 * <p>
 * 思路：
 * 动态规划，dp[i]表示遍历到第下标为i的元素时，前边“相邻”连续子数组和的最大值，不代表所有子数组和的最大值
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2};
        Solution solution = new Solution();
        int res = solution.maxSubArray2(nums);
        System.out.println("res = " + res);
    }

    /**
     * 动态规划-优化版
     */
    public int maxSubArray3(int[] nums) {

        int max = nums[0];//记录最大值
        int pre = 0;//记录dp[i-1]

        for (int i = 0; i < nums.length; i++) {
            int cur = pre > 0 ? nums[i] + pre : nums[i];
            max = Math.max(max, cur);
            pre = cur;//更新pre
        }
        return max;

        //int max = nums[0];
        //int cur = nums[0];
        //for (int i = 1; i < nums.length; i++) {
        //    cur = cur > 0 ? cur + nums[i] : nums[i];
        //    max = Math.max(cur, max);
        //}
        //return max;
    }

    /**
     * 动态规划-dp数组版
     */
    public int maxSubArray2(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /**
     * 动态规划-以原nums数组作为dp数组，不推荐
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






















