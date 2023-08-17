package a08_回溯算法;

/**
 * @author: fosss
 * Date: 2023/8/17
 * Time: 15:31
 * Description:
 * 编写一个程序，通过填充空格来解决数独问题。
 * 一个数独的解法需遵循如下规则： 数字 1-9 在每一行只能出现一次。 数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能
 * 出现一次。 空白格用 '.' 表示。
 * https://leetcode.cn/problems/sudoku-solver/
 */
public class B15_解数独 {

    /**
     * N皇后问题是因为每一行每一列只放一个皇后，只需要一层for循环遍历一行，递归来遍历列，然后一行一列确定皇后的唯一位置。
     * 本题就不一样了，本题中棋盘的每一个位置都要放一个数字（而N皇后是一行只放一个皇后），并检查数字是否合法，所以要做二维递归
     */
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    /**
     * @param board 数独盘
     * @return 返回是否得到解。因为解数独找到一个符合的条件（就在树的叶子节点上）立刻就返回，相当于找从根节点到叶子节点一条唯一路径，所以需要使用
     * bool返回值
     */
    private boolean backtracking(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {//说明是空的，需要进行填充
                    //从1~9找合适的数值
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)) {
                            //k这个数符合规则，则再去寻找下一个数
                            board[i][j] = k;
                            if (backtracking(board)) return true;
                            //回溯
                            board[i][j] = '.';
                        }
                    }
                    //如果1~9中没有找到合适的数，说明数独解不出来
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断值是否符合规则
     */
    private boolean isValid(char[][] board, int row, int col, char val) {
        //val在同行只能出现一次
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == val) return false;
        }
        //val在同列只能出现一次
        for (int i = 0; i < board[0].length; i++) {
            if (board[i][col] == val) return false;
        }
        // 3*3 方格内只能出现一次
        //先找到方格左上角的行列——相当巧妙
        int r = row / 3 * 3;
        int c = col / 3 * 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == val) return false;
            }
        }
        //以上没有放回false，说明找到了解
        return true;
    }

}









