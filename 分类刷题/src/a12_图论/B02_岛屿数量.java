package a12_图论;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: fosss
 * Date: 2023/11/22
 * Time: 20:37
 * Description:
 * https://leetcode.cn/problems/number-of-islands/description/
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方
 * 向上相邻的陆地连接形成。此外，你可以假设该网格的四条边均被水包围。
 */
public class B02_岛屿数量 {

    /**
     * bfs
     * ！！！需要注意将某点设置为已访问的时间，是在加入队列后而不是弹出队列后，否则会导致重复访问一些位置从而导致超时
     */
    public int numIslands2(char[][] grid) {
        int res = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //未被访问且是陆地
                if (!visited[i][j] && grid[i][j] == '1') {
                    res++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, boolean[][] visited, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        //将当前位置放入队列
        queue.add(new int[]{i, j});
        //只要放入队列就设置已访问
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            //获取当前位置
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            //遍历四个方向
            for (int k = 0; k < 4; k++) {
                //获取新坐标
                //获取新坐标
                int newX = x + directions[k][0];
                int newY = y + directions[k][1];
                //如果没越界
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && !visited[newX][newY] && grid[newX][newY] == '1') {
                    //放入队列中，并设置为已访问
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
    }

    /**
     * dfs
     */
    public int numIslands(char[][] grid) {
        //首先要明白岛屿的定义，由相邻（横向和竖向，不包括斜向）的陆地组成，每找一个岛屿，就要将其所包含的陆地设置为已访问，找出有多少岛屿
        //就行
        //记录岛屿数量
        int res = 0;
        //记录每块陆地是否被访问过
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        //遍历每块陆地
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    //没被访问过且是陆地
                    //岛屿数+1
                    res++;
                    //将这块岛屿四周包含的陆地标记为已访问
                    dfs(grid, visited, i, j);
                }
            }
        }
        return res;
    }

    //定义四个方向
    int[][] directions = {
            {0, -1},//上
            {1, 0},//右
            {0, 1},//下
            {-1, 0}//左
    };

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        //如果当前陆地已访问或当前不是陆地，结束递归
        if (visited[i][j] || grid[i][j] == '0') return;

        //将当前陆地设置为已访问
        visited[i][j] = true;
        //遍历四个方向
        for (int k = 0; k < 4; k++) {
            //获取新坐标
            int newI = i + directions[k][0];
            int newJ = j + directions[k][1];
            //如果没越界
            if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length) {
                dfs(grid, visited, newI, newJ);
            }
        }
    }
}
