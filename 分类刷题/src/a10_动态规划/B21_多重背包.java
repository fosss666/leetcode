package a10_动态规划;

import java.util.List;

/**
 * @author: fosss
 * Date: 2023/9/19
 * Time: 19:56
 * Description:
 * 与01背包相比，就是物品的数量由1个变成了有限数个。力扣中没有相关题目。
 */
public class B21_多重背包 {
    /**
     * 版本一：改变物品数量为01背包格式
     */
    public void testMultiPack1(List<Integer> weight, List<Integer> value, List<Integer> nums, int bagWeight) {
        /**
         * 将物品拓展成数量为一的
         */
        for (int i = 0; i < nums.size(); i++) {
            while (nums.get(i) > 1) { // 把物品展开为i
                weight.add(weight.get(i));
                value.add(value.get(i));
                nums.set(i, nums.get(i) - 1);
            }
        }

        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.size(); i++) { // 遍历物品
            for (int j = bagWeight; j >= weight.get(i); j--) { // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weight.get(i)] + value.get(i));
            }
        }
    }

    /**
     * 版本二：改变遍历个数
     */
    public void testMultiPack2(int[] weight, int[] value, int[] nums, int bagWeight) {

        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++) { // 遍历物品
            for (int j = bagWeight; j >= weight[i]; j--) { // 遍历背包容量
                // 以上为01背包，然后加一个遍历个数
                for (int k = 1; k <= nums[i] && j >= k * weight[i]; k++) { // 遍历个数
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
            }
        }
    }
}
