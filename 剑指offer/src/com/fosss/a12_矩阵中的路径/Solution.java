package com.fosss.a12_矩阵中的路径;


/**
 * @author fosss
 * date 2023/1/9
 * description：
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用
 * 例：输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"  输出：true
 * 提示： m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 *
 * 思路：遍历二维字符网格的每个字符，对符合word第一个字符的地方进行寻找
 *
 */
public class Solution {
    public static void main(String[] args) {
        char[][] board = {
                //{'A','B','C','E'},
                //{'S','F','C','S'},
                //{'A','D','E','F'}
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}

        };
        String word = "SEE";
        Solution solution = new Solution();
        boolean exist = solution.exist(board, word);
        System.out.println("exist = " + exist);
    }


    public boolean exist(char[][] board, String word) {
        int k = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //用来标记某一坐标是否被访问过
                boolean[][] isVisited = new boolean[board.length][board[i].length];
                boolean result = check(i, j, board, word, k, isVisited);
                //找到了该单词，则直接返回true,否则继续执行循环
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 判断从（i,j）开始的单词是否符合条件
     * @param i 第几行
     * @param j 第几列
     * @param board 二维字符网格
     * @param word 要查找的单词
     * @param k 已查找的符合条件的字母在单词中对应的下标，初始为0
     * @param isVisited 二维网格的每个位置是否已访问
     * @return 返回是否找到
     */
    private boolean check(int i, int j, char[][] board, String word, int k, boolean[][] isVisited) {
        if (board[i][j] != word.charAt(k)) {
            //说明字符不匹配，直接返回false
            return false;
        } else if (k == word.length() - 1) {
            //说明找到了
            return true;
        }
        //创建二维数组来进行上下左右的移动
        int[][] moving = {
                {-1, 0},//上
                {0, 1},//右
                {1, 0},//下
                {0, -1}//左
        };

        //到此处(i,j)的点为word中k处的字符，标记为已访问
        isVisited[i][j] = true;
        //记录是否找到单词
        boolean result = false;
        //下面对上下左右进行判断
        for (int x = 0; x < moving.length; x++) {
            int newI = i + moving[x][0];
            int newJ = j + moving[x][1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[i].length) {
                if (!isVisited[newI][newJ]) {
                    boolean check = check(newI, newJ, board, word, k + 1, isVisited);
                    if (check) {
                        //找到了
                        result = true;
                        break;
                    }
                }
            }
        }
        //如果程序进行到这一行，可能找到，也可能没有找到，没有找到的话为了避免后续寻找过程中会用到（i,j）这个字符，所以需要将此处设为未访问，
        isVisited[i][j] = false;
        return result;
    }
}
























