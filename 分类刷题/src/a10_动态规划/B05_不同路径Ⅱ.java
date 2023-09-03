package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/3
 * Time: 13:32
 * Description:
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下
 * 图中标记为“Finish”）。现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？网格中的障碍物和空位置分别用 1 和 0 来表示。
 * https://leetcode.cn/problems/unique-paths-ii/
 * 示例：
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class B05_不同路径Ⅱ {

    public static void main(String[] args) {
        B05_不同路径Ⅱ test = new B05_不同路径Ⅱ();
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        test.uniquePathsWithObstacles(obstacleGrid);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        //对于第一行和第一列，如果遇到障碍，则那个位置以及后边的位置都无法到达，即路径数为0
        //初始化第一行
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                for (int j = i; j < obstacleGrid[0].length; j++) {
                    dp[0][j] = 0;
                }
                break;
            }
        }
        //初始化第一列
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                for (int j = i; j < obstacleGrid.length; j++) {
                    dp[j][0] = 0;
                }
                break;
            }
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    //非障碍物才需要计算路径数，（i,j）路径数=紧靠着的上边路径数和左边路径数之和，障碍物的路径数默认都是0
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}






