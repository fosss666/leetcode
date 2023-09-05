package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/5
 * Time: 11:06
 * Description:
 * 有n件物品和一个最多能背重量为w 的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
 */
public class B08_01背包_二维数组实现 {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int w = 4;
        B08_01背包_二维数组实现 test = new B08_01背包_二维数组实现();
        int res = test.bagProblem(weight, value, w);
        System.out.println("res = " + res);
    }

    /**
     * @param weight 第i件物品的重量是weight[i]
     * @param value  第i件物品的价值是value[i]
     * @param w      背包最大承重
     * @return 返回背包里物品价值最大值
     */
    public int bagProblem(int[] weight, int[] value, int w) {
        //dp[i][j]表示遍历到第i件物品，背包承重最大为j时，此时背包中的物品最大价值
        int[][] dp = new int[value.length][w + 1];
        //递推公式，dp[i][j]=Math.max( dp[i-1][j] , value[i]+dp[i-1][j-weight[i]] )
        //dp[i-1][j]：(下标为i)物品放不进去，所以价值仍为放入上个物品后的背包价值
        //value[i]+dp[i-1][j-weight[i]]：（下标为i）物品价值 + 背包剩余容量能够放入的最大价值

        //初始化dp数组
        //背包容量为0时，即第一列，放不了物品所以背包价值为0。dp数组初始化都为0，所以不用再进行赋值
        //根据递推公式，需要用到第一行（遍历到第i件物品时）的数据，所以对第一行进行初始化，当背包承重<（下标为0）物品价值时，不能放入，即dp为0；
        //反之，dp初始化为（下标为0）物品价值
        for (int i = weight[0]; i < dp[0].length; i++) {
            dp[0][i] = value[0];
        }

        //先遍历物品(下标为0的那一行已经初始化过了，所以从1开始)，再遍历背包容量（先容量后物品也可以）
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < weight[i]) {
                    //背包容量<物品重量
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i - 1][j - weight[i]]);
                }
            }
        }
        return dp[weight.length - 1][w];
    }
}
