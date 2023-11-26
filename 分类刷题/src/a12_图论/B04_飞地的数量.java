package a12_图论;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: fosss
 * Date: 2023/11/26
 * Time: 16:07
 * Description: https://leetcode.cn/problems/number-of-enclaves/description/
 * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
 * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
 * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
 */
public class B04_飞地的数量 {

    public static void main(String[] args) {
        B04_飞地的数量 test = new B04_飞地的数量();
        int[][] grip = {
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };
        test.numEnclaves2(grip);
    }

    /**
     * dfs
     */
    int count = 0;
    int[][] directions = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    public int numEnclaves(int[][] grid) {
        //1. 将与矩阵边缘有联系的陆地变为海洋
        //左右两边
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) dfs(grid, i, 0);
            if (grid[i][grid[i].length - 1] == 1) dfs(grid, i, grid[0].length - 1);

        }
        //上下两边
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) dfs(grid, 0, i);
            if (grid[grid.length - 1][i] == 1) dfs(grid, grid.length - 1, i);
        }

        //2. 统计剩余的陆地即为飞地的数量，调用dfs方法或直接遍历整个二维数组
        count = 0;//count在经历上述过程后已经变化，将其重新赋值为0
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) dfs(grid, i, j);
            }
        }
        return count;
    }

    //这个方法有两个用处：1. 将（x,y）变成海洋 2. 统计陆地的个数   都在这一个方法中完成。另外，由于会将遍历到的陆地变为海洋，所以不需要再设置isVisited数据记录每块地方是否被遍历，因为海洋是不会被遍历到的
    private void dfs(int[][] grid, int x, int y) {
        //功能1
        grid[x][y] = 0;
        //功能2
        count++;

        //遍历四个方向
        for (int k = 0; k < 4; k++) {
            int newX = x + directions[k][0];
            int newY = y + directions[k][1];
            if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) continue;
            if (grid[newX][newY] == 1) dfs(grid, newX, newY);
        }
    }

    /**
     * bfs
     */
    public int numEnclaves2(int[][] grid) {
        //1. 将与矩阵边缘有联系的陆地变为海洋
        //左右两边
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) bfs(grid, i, 0);
            if (grid[i][grid[i].length - 1] == 1) bfs(grid, i, grid[0].length - 1);

        }
        //上下两边
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) bfs(grid, 0, i);
            if (grid[grid.length - 1][i] == 1) bfs(grid, grid.length - 1, i);
        }

        //2. 统计剩余的陆地即为飞地的数量，调用dfs方法或直接遍历整个二维数组
        count = 0;//count在经历上述过程后已经变化，将其重新赋值为0
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) bfs(grid, i, j);
            }
        }
        return count;
    }

    private void bfs(int[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        grid[x][y] = 0;
        count++;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            //遍历四个方向
            for (int k = 0; k < 4; k++) {
                int newX = poll[0] + directions[k][0];
                int newY = poll[1] + directions[k][1];
                if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) continue;
                if (grid[newX][newY] == 1) {
                    queue.add(new int[]{newX, newY});
                    grid[newX][newY] = 0;
                    count++;
                }
            }
        }
    }
}
