package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/7
 * Time: 18:40
 * Description:
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意: 每个数组中的元素不会超过 100 数组的大小不会超过 200
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class B10_分割等和子集 {
    public static void main(String[] args) {
        B10_分割等和子集 test = new B10_分割等和子集();
        int[] nums = {2, 2, 1, 1};
        test.canPartition(nums);
    }

    /**
     * 数组要想能够分割成两个元素和相等的子集，可以通过寻找是否存在所有数总和的一半的子集来进行判断。首先，总和必须是偶数；其次，如果找到了和为总和
     * 一半的子集，也间接说明剩余元素的和也为总和的一半，即数组能分割成两个元素和相等的数组。寻找子集可通过背包实现，数组元素相当于物品，元素数值相
     * 当于物品重量和价值。先求出总和大小的一半，在向背包中放置物品（数组元素）时计算总价值，如果总价值（背包内元素数值和）==总和一半，说明此时背包
     * 中的元素是符合条件的子集，返回true。可以判断出背包容量最大为总和一半，据此初始化dp数组大小。
     */
    public boolean canPartition(int[] nums) {
        //计算总和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //判断是否是偶数
        if (sum % 2 != 0) return false;
        //计算总和一半
        int half = sum / 2;
        //初始化dp数组，判断是否存在合适的子集条件是：dp[half]==half（背包容量half==总和一半）
        int[] dp = new int[half + 1];
        //第一个循环遍历物品
        for (int i = 0; i < nums.length; i++) {
            //第二个循环遍历背包容量，使用滚动数组记录时，应该倒序遍历(背包容量>=物品重量时才考虑是否放进背包)
            for (int j = nums.length - 1; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], nums[i] + dp[j - nums[i]]);
            }
        }
        return dp[half] == half;
    }
}
