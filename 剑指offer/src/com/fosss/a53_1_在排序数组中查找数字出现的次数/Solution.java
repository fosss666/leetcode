package com.fosss.a53_1_在排序数组中查找数字出现的次数;

/**
 * @author fosss
 * @date 2023/2/19
 * @description： 统计一个数字在排序数组中出现的次数
 * 例：输入: nums = [5,7,7,8,8,10], target = 8  输出: 2
 * 提示：
 * 0 <= nums.length <= 105
 * -10^9<= nums[i]<= 10^9
 * nums是一个非递减数组
 * -10^9<= target<= 10^9
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 1};
        Solution solution = new Solution();
        int res = solution.search(nums, 1);
        System.out.println("res = " + res);
    }

    /**
     * 自解，二分查找  100% 58%
     */
    public int search(int[] nums, int target) {
        int index = binarySearch(nums, target);
        if (index < 0) {
            return 0;
        }
        //向左右查找该值出现的次数
        int count = 1;
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] == target) {
                count++;
            }
        }
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }

    //返回目标值的下标
    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                //向右查找
                left = mid + 1;
            } else {
                //向左查找
                right = mid - 1;
            }
        }
        //数组中没有该目标值
        return -1;
    }
}



















