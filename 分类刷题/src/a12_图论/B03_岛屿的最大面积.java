package a12_图论;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: fosss
 * Date: 2023/11/23
 * Time: 20:58
 * Description: https://leetcode.cn/problems/max-area-of-island/description/
 * 给你一个大小为 m x n 的二进制矩阵 grid 。岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直
 * 的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 */
public class B03_岛屿的最大面积 {

    /**
     * DFS
     */
    public int maxAreaOfIsland(int[][] grid) {
        //初始化
        isVisited = new boolean[grid.length][grid[0].length];

        //记录最大面积
        int res = 0;
        //遍历每块位置
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //未被访问且是陆地
                if (!isVisited[i][j] && grid[i][j] == 1) {//这个判断不加也行，因为dfs中第一句代码就是这样的逻辑
                    count = 0;//岛屿面积目前是1
                    dfs(grid, i, j);
                    //更新最大值
                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }

    //标记每块位置是否被访问过
    boolean[][] isVisited;
    //四个方向
    int[][] directions = {
            {-1, 0},//上
            {0, 1},//右
            {1, 0},//下
            {0, -1}//左
    };
    //统计岛屿面积
    int count;

    //DFS
    private void dfs(int[][] grid, int i, int j) {
        //递归结束条件
        if (isVisited[i][j] || grid[i][j] != 1) return;

        //标记为已访问
        isVisited[i][j] = true;
        count++;//岛屿面积+1
        //向四周移动
        for (int k = 0; k < 4; k++) {
            int newI = i + directions[k][0];
            int newJ = j + directions[k][1];
            if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length) {
                dfs(grid, newI, newJ);
            }
        }
    }

    /**
     * BFS
     */
    public int maxAreaOfIsland2(int[][] grid) {
        isVisited = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                count = 0;
                if (!isVisited[i][j] && grid[i][j] == 1) {
                    bfs(grid, i, j);
                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }

    private void bfs(int[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        //设置为已访问
        isVisited[i][j] = true;
        //面积+1
        count++;
        //处理岛屿的每部分
        while (!queue.isEmpty()) {
            //获取坐标
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            //遍历四周
            for (int k = 0; k < 4; k++) {
                int newX = x + directions[k][0];
                int newY = y + directions[k][1];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                    if (!isVisited[newX][newY] && grid[newX][newY] == 1) {
                        count++;//面积+1
                        isVisited[newX][newY] = true;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
    }
}
