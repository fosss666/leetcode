package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/10/9
 * Time: 20:08
 * Description:
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class B36_最大子序和 {
    public static void main(String[] args) {
        int[] nums = {4, -1, 2, 1};
        B36_最大子序和 test = new B36_最大子序和();
        int res = test.maxSubArray2(nums);
        System.out.println("res = " + res);
    }

    /**
     * 贪心
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];//或INTEGER.MIN_VALUE
        int tempSum = 0;

        for (int i = 0; i < nums.length; i++) {
            //计算临时和
            tempSum += nums[i];
            //更新最大和，直接取最大值
            maxSum = Math.max(maxSum, tempSum);
            //更新临时和，当临时和为负数时，重置为0。原因：为负数，那么tempSum一定是导致和变小的累赘
            if (tempSum < 0) tempSum = 0;
        }
        return maxSum;
    }

    /**
     * 动规
     */
    public int maxSubArray2(int[] nums) {
        //dp[i]：遍历到数组下标为i处，此时的最大子序和
        int[] dp = new int[nums.length];
        //初始化：第0处，子序和为nums[0]
        dp[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //dp[i - 1] + nums[i]：把当前加入之前的序列
            //nums[i]：从头开始计算当前连续子序列和，为什么要从头开始，因为当前元素值已经比之前的子序和大了，之前的子序和是累赘，抛弃掉
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 动规——空间优化
     * dp数组中，实际只有dp[i]和dp[i-1]在推动者数值的推导，dp[i-1]不断被dp[i]覆盖，所以可以用一个变量代替
     */
    public int maxSubArray3(int[] nums) {
        //初始化：第0处，子序和为nums[0]
        int pre = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //dp[i - 1] + nums[i]：把当前加入之前的序列
            //nums[i]：从头开始计算当前连续子序列和，为什么要从头开始，因为当前元素值已经比之前的子序和大了，之前的子序和是累赘，抛弃掉
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }
}





