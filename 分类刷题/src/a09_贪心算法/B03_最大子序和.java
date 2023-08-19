package a09_贪心算法;

/**
 * @author: fosss
 * Date: 2023/8/19
 * Time: 15:48
 * Description:
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:  连续子数组  [4,-1,2,1] 的和最大，为  6。
 */
public class B03_最大子序和 {

    /**
     * 暴力遍历——超时
     */
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    /**
     * 贪心算法，当局部和小于0时，立即放弃；当局部和大于全局和时，更新全局和。相当于暴力遍历加上了条件。
     */
    public int maxSubArray2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > maxSum) maxSum = sum;//先更新全局和
            if (sum < 0) sum = 0;//重新开始
        }
        return maxSum;
    }

    /**
     * 动态规划。dp[i]表示下标为i处，子序列和最大值为dp[i]
     */
    public int maxSubArray3(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //转移方程
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    /**
     * 动态规划空间优化
     */
    public int maxSubArray3_2(int[] nums) {
        int dp = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //转移方程
            dp = Math.max(dp + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp);
        }
        return maxSum;
    }
}
