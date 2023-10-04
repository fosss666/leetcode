package a10_动态规划;

import java.util.Arrays;

/**
 * @author: fosss
 * Date: 2023/10/4
 * Time: 19:26
 * Description:
 * 给定一个未经排序的整数数组，找到最长且连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l],
 * nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * 示例 1：
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * 示例 2：
 * 输入：nums = [2,2,2,2,2]
 * 输出：1
 * 解释：最长连续递增序列是 [2], 长度为1。
 * 提示：
 * 0 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 */
public class B32_最长连续递增序列 {

    /**
     * 暴力遍历   7% 70%
     */
    public int findLengthOfLCIS(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int len = 1;
            while (j < nums.length && nums[j] > nums[j - 1]) {
                j++;
                len++;
            }
            max = Math.max(max, len);
        }
        return max;
    }

    /**
     * 动规 ×  贪心 √   98% 7%
     */
    public int findLengthOfLCIS2(int[] nums) {

        //dp[i]表示遍历以nums[i]结尾的连续递增序列的长度
        int[] dp = new int[nums.length];
        dp[0] = 1;

        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 贪心        98%    40%
     */
    public int findLengthOfLCIS3(int[] nums) {
        int count = 1;

        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    /**
     * 动规      32%   54%
     */
    public int findLengthOfLCIS4(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}










