package com.fosss.a13_机器人的运动范围;

/**
 * @author: fosss
 * Date: 2023/3/11
 * Time: 20:25
 * Description:地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、
 * 下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为
 * 3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子?
 * 示例：输入：m = 2, n = 3, k = 1  输出：3
 * 提示：1 <= n,m <= 100         0 <= k <= 20
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.movingCount(2, 3, 1);
        System.out.println("res = " + res);
    }

    /**
     * 深度优先    64%   76%
     * 100%  54%
     */
    public int movingCount(int m, int n, int k) {
        //用二维数组记录是否被访问过
        boolean[][] isVisited = new boolean[m][n];
        return dfs(0, 0, m, n, k, isVisited);
    }

    private int dfs(int row, int col, int m, int n, int k, boolean[][] isVisited) {
        //判断是否在界外或是否访问过或是否符合条件
        if (row < 0 || col < 0 || row >= m || col >= n || isVisited[row][col] || k < (sums(row) + sums(col))) {
            return 0;
        }
        //将当前位置设置为已访问
        isVisited[row][col] = true;
        //向逆时针判断    由符合条件的值的特点会得出只需要向下向右判断就行，这样能够节省时间
        //return 1 + dfs(row + 1, col, m, n, k, isVisited) + dfs(row, col + 1, m, n, k, isVisited) + dfs(row - 1, col, m, n, k, isVisited) + dfs(row, col - 1, m, n, k, isVisited);
        return 1 + dfs(row + 1, col, m, n, k, isVisited) + dfs(row, col + 1, m, n, k, isVisited);
    }

    //计算数位和
    private int sums(int n) {
        int res = 0;
        while (n != 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}


























