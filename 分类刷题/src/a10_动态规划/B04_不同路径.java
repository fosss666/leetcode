package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/2
 * Time: 14:15
 * Description:
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * 示例1：
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例2：
 * 输入：m = 2, n = 3
 * 输出：3
 * 解释： 从左上角开始，总共有 3 条路径可以到达右下角。向右 -> 向右 -> 向下    向右 -> 向下 -> 向右   向下 -> 向右 -> 向右
 */
public class B04_不同路径 {

    /**
     * 动规
     */
    public int uniquePaths(int m, int n) {
        //dp[i][j]表示到达第i行第j列不同路径数量
        int[][] dp = new int[m][n];
        //i++表示向下移动一格，j++表示向右移动一格
        //一个格可能是从左（j-1）或上（i-1）移动而到达的，dp[0][j]和dp[i][0]都只有一条路径
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //(i,j)处的路径数=左侧一格的路径数+上侧一格的路径数
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}
