package a12_图论;

/**
 * @author: fosss
 * Date: 2023/11/30
 * Time: 20:48
 * Description: https://leetcode.cn/problems/island-perimeter/description/
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连
 * 组成的岛屿）。岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不
 * 超过 100 。计算这个岛屿的周长。
 */
public class B10_岛屿的周长 {
    public int islandPerimeter(int[][] grid) {
        //岛屿周长=陆地数*4-每块陆地上下左右的陆地数的和
        int count = 0;//记录陆地数
        int sides = 0;//记录每块陆地上下左右的陆地数的和
        //四个方向
        int[][] directions = {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1}
        };
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    //陆地数+1
                    count++;
                    for (int k = 0; k < 4; k++) {
                        int newI = i + directions[k][0];
                        int newJ = j + directions[k][1];
                        if (newI < 0 || newI >= grid.length || newJ < 0 || newJ >= grid[0].length) continue;
                        if (grid[newI][newJ] == 1) sides++;
                    }
                }
            }
        }
        return count * 4 - sides;
    }
}
