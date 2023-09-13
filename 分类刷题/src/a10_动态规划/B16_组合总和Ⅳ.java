package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/13
 * Time: 16:14
 * Description:
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 * 示例:
 * nums = [1, 2, 3]
 * target = 4
 * 所有可能的组合为： (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (1, 3) (2, 1, 1) (2, 2) (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 因此输出为 7。
 */
public class B16_组合总和Ⅳ {
    public static void main(String[] args) {
        B16_组合总和Ⅳ test = new B16_组合总和Ⅳ();
        int[] nums = {1, 2, 3};
        test.combinationSum4(nums, 4);
    }

    /**
     * `如果求组合数就是外层for循环遍历物品，内层for遍历背包。`
     * `如果求排列数就是外层for遍历背包，内层for循环遍历物品。`
     */
    public int combinationSum4(int[] nums, int target) {
        //dp[i]: 凑成目标正整数为i的排列个数为dp[i]
        int[] dp = new int[target + 1];
        //初始化
        dp[0] = 1;
        //遍历背包
        for (int i = 0; i <= target; i++) {
            //遍历物品
            for (int j = 0; j < nums.length; j++) {
                //能装得下物品时
                if (i >= nums[j]) dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
}
