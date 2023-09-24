package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/24
 * Time: 14:51
 * Description:
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 * 示例 1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 */
public class B23_打家劫舍Ⅱ {
    /**
     * 房屋排列成一个环，则偷东西时一定不能同时偷第一个和最后第一个，所以分别计算不考虑第一个和最后一个两种情况下
     * 能偷到的最大值，取最大值即可
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int start, int end) {

        //dp[i]表示走到第i个房子时能偷到的最大值
        int[] dp = new int[nums.length];

        //初始化
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }

    /**
     * 空间优化
     */
    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(rob2(nums, 0, nums.length - 2), rob2(nums, 1, nums.length - 1));
    }

    private int rob2(int[] nums, int start, int end) {
        //dp[i]表示走到第i个房子时能偷到的最大值
        int a = nums[start], b = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            int temp = b;
            b = Math.max(a + nums[i], b);
            a = temp;
        }
        return b;
    }
}












