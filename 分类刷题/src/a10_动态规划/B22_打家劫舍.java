package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/22
 * Time: 20:40
 * Description:
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。   偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。   偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * 提示：
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
public class B22_打家劫舍 {

    /**
     * 每走到一个房屋，应该判断是否要偷。
     */
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        //房屋下标为i,dp[i]表示走到i处能偷窃到的最高金额
        int[] dp = new int[nums.length];
        //初始化，第0个房屋，一定是要偷的。遍历到其他房屋时，就要判断要不要偷这个屋子了。如果偷，则dp[i]=dp[i-2]+nums[i];如果不偷，则dp[i]=dp[i-1]。判断一下这两种情况哪个金额大，即dp[i]=Math.max(dp[i-2]+dp[i],dp[i-1])。既然公式中用到了i-2的下标，则i一定>=2,所以应该对dp[1]也进行初始化，dp[1]=Math.max(nums[0],nums[1])
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        //遍历房屋
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    /**
     * 空间优化
     */
    public int rob2(int[] nums) {
        if (nums.length == 1) return nums[0];

        int a = nums[0], b = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = b;
            b = Math.max(a + nums[i], b);
            a = temp;
        }
        return b;
    }
}
