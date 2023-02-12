package com.fosss.a47_礼物的最大价值;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fosss
 * @date 2023/2/12
 * @description： 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一
 * 格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物
 * 例：输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * 提示：0 < grid.length <= 200   0 < grid[0].length <= 200
 */
public class Solution {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        Solution solution = new Solution();
        int res = solution.maxValue2(grid);
        System.out.println("res = " + res);
    }

    /**
     * 动态规划-k神版
     * 当i=0且j=0时，为起始元素；
     * 当i=0且j!=0时，为矩阵第一行元素，只可从左边到达；
     * 当i!=0且j=0时，为矩阵第一列元素，只可从上边到达；
     * 当i,j!=0时，可从左边或上边到达
     *
     * 空间复杂度优化：由于dp[i][j]只与 dp[i-1][j], dp[i][j-1], grid[i][j]grid[i][j] 有关系，
     * 因此可以将原矩阵grid用作dp矩阵，即直接在grid上修改即可
     *
     */
    public int maxValue2(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    //此时j不为0
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (j == 0) {
                    //此时i不为0
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else {
                    grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[row - 1][col - 1];
    }

    /**
     * 动态规划
     */
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[row][col];
    }

}

























