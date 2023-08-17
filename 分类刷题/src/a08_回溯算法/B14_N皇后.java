package a08_回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/8/17
 * Time: 10:49
 * Description:
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼
 * 此之间不能相互攻击。给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 示例：
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：4 皇后问题存在两个不同的解法。
 */
public class B14_N皇后 {

    public static void main(String[] args) {
        B14_N皇后 test = new B14_N皇后();
        test.solveNQueens(4);
    }

    /**
     * n*n棋盘，row为n时表示遍历结束；添加参数行表示点位于第几行，for循环中的i为第几列，这样(行，i)就行表示一个点的位置
     * 每次for应该从0开始，找合适的位置，用一个方法判断是否符合放置条件
     */
    public List<List<String>> solveNQueens(int n) {
        //初始化棋盘
        chessboard = new char[n][n];
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[i].length; j++) {
                chessboard[i][j] = '.';
            }
        }
        backtracking(n, 0, chessboard);
        return res;
    }

    List<List<String>> res = new ArrayList<>();
    //按理说应该用List<String>存储合适的棋盘，但是java中List<String>表示二维数组不容易改变每个位置的值，所以用char类型的二维数组代替
    char[][] chessboard;

    /**
     * @param n          共有几个皇后，
     * @param row        第几排
     * @param chessboard 棋盘
     */
    private void backtracking(int n, int row, char[][] chessboard) {
        //结束条件——遍历完每一行后，结束递归。能遍历完所有行，说明找到了合适的摆法，加入res
        if (row == n) {
            //将char二维数组转为List<String>
            res.add(change(chessboard));
            return;
        }

        //这里的i表示的是第几列
        for (int i = 0; i < n; i++) {
            if (canPlace(row, i, chessboard)) {
                //合适，则放入棋盘，并开始寻找下一行皇后的位置
                chessboard[row][i] = 'Q';
                backtracking(n, row + 1, chessboard);
                //回溯，恢复棋盘
                chessboard[row][i] = '.';
            }
        }
    }

    /**
     * 将char[][] 转为 List<String>
     */
    private List<String> change(char[][] chessboard) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < chessboard.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chessboard[i].length; j++) {
                sb.append(chessboard[i][j]);
            }
            res.add(sb.toString());
        }
        return res;
    }

    /**
     * 判断这个点能否放到当前棋盘中
     *
     * @param row 第几行
     * @param col 第几列
     */
    private boolean canPlace(int row, int col, char[][] chessboard) {
        //传来的点都是非同行的，所以不用判断同一行上是否有Q

        //判断是否同列，对已经做了修改的棋盘位置，同一列进行判断
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') return false;
        }

        //判断左对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') return false;
        }
        //判断有对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j < chessboard.length; i--, j++) {
            if (chessboard[i][j] == 'Q') return false;
        }
        return true;
    }
}









