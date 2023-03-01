package com.fosss.a59_滑动窗口的最大值;

import java.util.Arrays;

/**
 * @author: fosss
 * Date: 2023/3/1
 * Time: 20:06
 * Description:给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值
 * 示例：
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 提示：你可以假设 k 总是有效的，在输入数组 不为空 的情况下，1 ≤ k ≤ nums.length
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, -1};
        int[] res = solution.maxSlidingWindow(nums, 1);
        System.out.println("res = " + Arrays.toString(res));
    }

    /**
     * 自解，两个while  超时
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        //i为滑动窗口左边界，j为滑动窗口右边界
        int i = 0, j = k - 1;
        int[] res = new int[nums.length - k + 1];
        int m = 0;
        while (j < nums.length) {
            int max = nums[i];
            i++;
            //找到窗口中的最大值
            while (i <= j) {
                if (max < nums[i]) {
                    max = nums[i];
                }
                i++;
            }
            res[m++] = max;
            //更新j和i
            j++;
            i = j - (k - 1);
        }

        return res;
    }
}























