package com.fosss.a57_和为s的两个数字;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author fosss
 * @date 2023/2/26
 * @description： 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可
 * 例：输入：nums = [2,7,11,15], target = 9 输出：[2,7] 或者 [7,2]
 * 限制：1 <= nums.length <= 10^5  1 <= nums[i] <= 10^6
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {2, 3, 9, 41, 46, 47};
        Solution solution = new Solution();
        int[] res = solution.twoSum2(nums, 49);
        System.out.println("res = " + Arrays.toString(res));
    }

    /**
     * set  11%  91%
     */
    public int[] twoSum2(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(target - num)) {
                set.add(num);
            } else {
                return new int[]{num, target - num};
            }
        }
        return new int[]{};
    }

    /**
     * 自解，暴力循环   超时
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] + nums[i] > target) {
                        break;
                    }
                    if (nums[i] + nums[j] == target) {
                        res[0] = nums[i];
                        res[1] = nums[j];
                        return res;
                    }
                }
            }

        }
        return new int[]{};
    }
}
























