package a10_动态规划;

import java.util.Arrays;

/**
 * @author: fosss
 * Date: 2023/10/3
 * Time: 18:34
 * Description:
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * 提示：
 * 1 <= nums.length <= 2500
 * -10^4 <= nums[i] <= 104
 */
public class B31_最长递增子序列 {

    public int lengthOfLIS(int[] nums) {
        //dp[i]表示以nums[i]结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        //初始化，以任何元素结尾的序列长度最少肯定都为1
        Arrays.fill(dp, 1);
        //记录最长子序列。dp[i]只是以nums[i]结尾的最大长度，不是最长子序列的长度
        int res = 1;
        for (int i = 1; i < dp.length; i++) {
            //记录从0~i-1的最长子序列。dp[j]max的长度+1即为dp[i]
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            //更新最长长度
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
