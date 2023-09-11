package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/11
 * Time: 10:24
 * Description:
 * 有N件物品和一个最多能背重量为W的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。每件物品都有无限个（也就是可以放入背包多次），求解
 * 将哪些物品装入背包里物品价值总和最大。
 * https://www.programmercarl.com/%E8%83%8C%E5%8C%85%E9%97%AE%E9%A2%98%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%80%E5%AE%8C%E5%85%A8%E8%83%8C%E5%8C%85.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE
 */
public class B14_完全背包 {

    public static void main(String[] args) {
        int[] weights = {1, 3, 4};
        int[] values = {15, 20, 30};
        B14_完全背包 test = new B14_完全背包();
        test.completePack2(weights, values, 4);
    }

    /**
     * 01背包内嵌的循环是从大到小遍历，为了保证每个物品仅被添加一次。而完全背包的物品是`可以添加多次`的，所以要从小到大去遍历.
     * 在完全背包中，对于一维dp数组来说，其实两个for循环嵌套顺序是无所谓的！
     */
    /**
     * 滚动数组实现
     */
    public int completePack(int[] weights, int[] values, int W) {
        //dp[i]表示背包容量为i时背包价值最大为dp[i]
        int[] dp = new int[W + 1];
        //遍历物品
        for (int i = 0; i < weights.length; i++) {
            //遍历背包容量
            for (int j = weights[i]; j <= W; j++) {
                dp[j] = Math.max(dp[j], values[i] + dp[j - weights[i]]);
            }
        }
        return dp[W];
    }

    /**
     * 二维数组实现,注意初始化第一行时
     */
    public int completePack2(int[] weights, int[] values, int W) {
        //dp[i][j]遍历到第i个物品，背包容量为j时背包价值最大为dp[i][j]
        int[][] dp = new int[weights.length][W + 1];
        //初始化dp数组，下标为0的物品那一行，只有背包容量>=weights[0]时，才有价值。并且能装几个0，就初始化为几倍的价值！！！！！！！
        for (int i = weights[0]; i <= W; i++) {
            dp[0][i] = values[0] * (i / weights[0]);
        }

        //遍历物品,从下标1处开始
        for (int i = 1; i < weights.length; i++) {
            //遍历背包容量
            for (int j = 1; j <= W; j++) {
                if (j < weights[i]) {
                    //背包装不下i时，背包价值为i-1时的价值
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //可以重复添加,能装的进去就一直装
                    int count = 1;//记录i的数量
                    while (j - weights[i] * count >= 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], values[i] * count + dp[i - 1][j - weights[i] * count]);
                        count++;
                    }
                }
            }
        }
        return dp[weights.length - 1][W];
    }
}
