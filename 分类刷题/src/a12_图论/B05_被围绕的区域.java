package a12_图论;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: fosss
 * Date: 2023/11/27
 * Time: 21:11
 * Description: https://leetcode.cn/problems/surrounded-regions/description/
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
public class B05_被围绕的区域 {
    /**
     * 与上题飞地的数量正好相反，先找到四周的O及与其相连的位置并做标记，然后
     * 遍历整个区域，将没做标记的O都改为X就行。这里采用做标记的方式为先将O改为A
     * 与上题一样，由于遍历到的地取改变了符号，所以就不会再被重复遍历，所以不需要isVisited
     */

    int[][] directions = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    /**
     * dfs
     */
    public void solve(char[][] board) {
        //找左右两侧
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][board[0].length - 1] == 'O') dfs(board, i, board[0].length - 1);
        }
        //找上下两侧
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') dfs(board, 0, i);
            if (board[board.length - 1][i] == 'O') dfs(board, board.length - 1, i);
        }
        //处理 将O改为X,将A改回O
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        board[x][y] = 'A';

        for (int k = 0; k < 4; k++) {
            int newX = x + directions[k][0];
            int newY = y + directions[k][1];
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) continue;
            if (board[newX][newY] == 'O') dfs(board, newX, newY);
        }
    }

    /**
     * bfs
     */
    public void solve2(char[][] board) {
        //找左右两侧
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') bfs(board, i, 0);
            if (board[i][board[0].length - 1] == 'O') bfs(board, i, board[0].length - 1);
        }
        //找上下两侧
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') bfs(board, 0, i);
            if (board[board.length - 1][i] == 'O') bfs(board, board.length - 1, i);
        }
        //处理 将O改为X,将A改回O
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        board[x][y] = 'A';

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int k = 0; k < 4; k++) {
                int newX = poll[0] + directions[k][0];
                int newY = poll[1] + directions[k][1];
                if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) continue;
                if (board[newX][newY] == 'O') {
                    queue.add(new int[]{newX, newY});
                    board[newX][newY] = 'A';
                }
            }
        }
    }
}
