package a12_图论;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/11/28
 * Time: 17:30
 * Description: https://leetcode.cn/problems/pacific-atlantic-water-flow/description/
 * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格
 * 高于海平面的高度 。岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可
 * 以从海洋附近的任何单元格流入海洋。返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动
 * 既可流向太平洋也可流向大西洋 。
 */
public class B06_太平洋大西洋水流问题 {
    /**
     * 总体思路：左和上为太平洋，右和下是大西洋，用两个二维数组分别记录太平洋和大西洋分别从这两个洋的两边开始标记四周比当前位置高度高的地方，记为true，最后统计太平洋和大西洋均为true的位置
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int shuLen = heights.length;
        int hengLen = heights[0].length;
        //记录太平洋——左和上
        boolean[][] tai = new boolean[shuLen][hengLen];
        //记录大西洋——右和下
        boolean[][] da = new boolean[shuLen][hengLen];

        //左和右
        for (int i = 0; i < shuLen; i++) {
            //左，太平洋
            dfs(heights, i, 0, tai);
            //右，大西洋
            dfs(heights, i, hengLen - 1, da);
        }
        //上和下
        for (int i = 0; i < hengLen; i++) {
            //上，太平洋
            dfs(heights, 0, i, tai);
            //下，大西洋
            dfs(heights, shuLen - 1, i, da);
        }

        //记录两个洋都为true的点
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < shuLen; i++) {
            for (int j = 0; j < hengLen; j++) {
                if (tai[i][j] && da[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    int[][] directions = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    private void dfs(int[][] heights, int x, int y, boolean[][] isVisited) {
        isVisited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int newX = x + directions[k][0];
            int newY = y + directions[k][1];
            if (newX < 0 || newX >= heights.length || newY < 0 || newY >= heights[0].length) continue;
            //新的高度大于等于原高度并且未访问过，调用
            if (heights[newX][newY] >= heights[x][y] && !isVisited[newX][newY]) {
                dfs(heights, newX, newY, isVisited);
            }
        }
    }

    public static void main(String[] args) {
        B06_太平洋大西洋水流问题 test = new B06_太平洋大西洋水流问题();
        int[][] heights =
                {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        test.pacificAtlantic(heights);
    }


}
