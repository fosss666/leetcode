package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/8
 * Time: 14:55
 * Description:
 * 有一堆石头，每块石头的重量都是正整数。每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的
 * 可能结果如下：如果 x == y，那么两块石头都会被完全粉碎；如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。
 * 示例：
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * 提示：
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */
public class B11_最后一块石头的重量Ⅱ {

    public static void main(String[] args) {
        int[] stones = {31, 26, 33, 21, 40};
        B11_最后一块石头的重量Ⅱ test = new B11_最后一块石头的重量Ⅱ();
        test.lastStoneWeightII(stones);
    }

    /**
     * 实质是将石头尽可能地分成重量相近的两堆，这样在碰撞后剩下的就是最小的，与上一题分割等和子集相似
     */
    public int lastStoneWeightII(int[] stones) {
        //计算石头一半的重量
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int half = sum / 2;
        //dp[i]：背包容量为i时，背包最大价值
        int[] dp = new int[half + 1];
        //遍历石头
        for (int i = 0; i < stones.length; i++) {
            //倒序遍历背包容量
            for (int j = dp.length - 1; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], stones[i] + dp[j - stones[i]]);
            }
        }
        //计算另一半的重量，half是sum/2得到的，出现小数时向下取整（如1.5得到的是1），所以sum-half>=half
        return (sum - dp[half]) - dp[half];
    }
}
