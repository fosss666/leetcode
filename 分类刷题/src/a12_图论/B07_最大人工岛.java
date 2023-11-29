package a12_图论;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: fosss
 * Date: 2023/11/29
 * Time: 17:26
 * Description: https://leetcode.cn/problems/making-a-large-island/description/
 * 给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。
 * 返回执行此操作后，grid 中最大的岛屿面积是多少？
 * 岛屿 由一组上、下、左、右四个方向相连的 1 形成。
 * 示例 1:
 * 输入: grid = [[1, 0], [0, 1]]
 * 输出: 3
 * 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
 * 示例 2:
 * 输入: grid = [[1, 1], [1, 0]]
 * 输出: 4
 * 解释: 将一格0变成1，岛屿的面积扩大为 4。
 * 示例 3:
 * 输入: grid = [[1, 1], [1, 1]]
 * 输出: 4
 * 解释: 没有0可以让我们变成1，面积依然为 4。
 */
public class B07_最大人工岛 {

    //标记岛屿面积
    int count;
    //标记各个位置是否被访问
    boolean[][] isVisited;
    //四个方向
    int[][] directions = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    public int largestIsland(int[][] grid) {
        //1.先统计未将一个0变成1时，各个岛屿的面积。这里我们将每个岛屿赋予一个编号，并在地图上将其范围内的地区由1变成这个编号，方便后续统计
        //所以这个编号应该从2开始
        isVisited = new boolean[grid.length][grid[0].length];
        //用map记录各个岛屿的面积
        Map<Integer, Integer> map = new HashMap<>();
        //岛屿编号，自增
        int index = 2;
        //标记是否出现过0
        boolean flag = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) flag = true;
                if (grid[i][j] == 1 && !isVisited[i][j]) {
                    count = 0;//初始化面积为0
                    dfs(grid, i, j, index);
                    map.put(index++, count);
                }
            }
        }

        //判断是不是没出现过0
        if (!flag) return grid.length * grid[0].length;

        //2. 遍历所有的0，统计将其变成1后加上相邻四个方向岛屿的面积后所得的总面积，取最大值
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //有一种可能，本来所有位置就都是岛屿，那么就不需要0变1，下边这个判断就进不去，所以在进行步骤2之前，应该先判断是不是这种情况。可以提前用一个变量记录整个区域中是否有0，如果遍历完整个区域后，这个变量未发生变化，说明直接返回整个区域的面积即可
                if (grid[i][j] == 0) {
                    //用set防止四个方向的岛屿有重复的
                    Set<Integer> set = new HashSet<>();
                    //记录当前面积
                    int temp = 1;//默认是当前由0变1的大小
                    //遍历四周
                    for (int k = 0; k < 4; k++) {
                        int newI = i + directions[k][0];
                        int newJ = j + directions[k][1];
                        //超出范围的跳过，不是岛屿的跳过
                        if (newI < 0 || newI >= grid.length || newJ < 0 || newJ >= grid[0].length || grid[newI][newJ] <= 1)
                            continue;
                        //已经统计的，跳过
                        if (set.contains(grid[newI][newJ])) continue;
                        Integer area = map.get(grid[newI][newJ]);
                        temp += area;
                        //加入已遍历集合
                        set.add(grid[newI][newJ]);
                    }
                    res = Math.max(res, temp);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int x, int y, int index) {
        //面积+1
        count++;
        //标记为已访问
        isVisited[x][y] = true;
        //将此处标记为岛屿的编号
        grid[x][y] = index;
        //遍历四个方向
        for (int k = 0; k < 4; k++) {
            int newX = x + directions[k][0];
            int newY = y + directions[k][1];
            if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) continue;
            if (!isVisited[newX][newY] && grid[newX][newY] == 1) {
                dfs(grid, newX, newY, index);
            }
        }
    }
}
