package com.fosss.a29_顺时针打印矩阵;

import java.util.Arrays;

/**
 * @author fosss
 * @date 2023/1/22
 * @description： 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * 例：输入：matrix = [[1,2,3],[4,5,6],[7,8,9]] 输出：[1,2,3,6,9,8,7,4,5]
 * 限制：0 <= matrix.length <= 100  0 <= matrix[i].length <= 100
 * <p>
 * 1  2  3
 * 4  5  6
 * 7  8  9
 * <p>
 * 思路：
 * 设定上下左右边界 一个while,四个for循环判断
 * 1）从左边界向右，遇到右边界停止，上边界向下移动一行
 * 2）从上边界向下，遇到下边界停止，右边界向左移动一列
 * 3）从右边界向左，遇到左边界停止，下边界向上移动一行
 * 4）从下边界向上，遇到上边界停止，左边界向右移动一列
 */
public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Solution solution = new Solution();
        int[] arr = solution.spiralOrder(matrix);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    /**
     * 设定边界
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        //定义上下左右边界
        int u = 0, d = matrix.length - 1, l = 0, r = matrix[0].length - 1;
        //定义储存数据的数组
        int[] arr = new int[(d + 1) * (r + 1)];
        int x = 0;

        while (true) {
            //从左到右
            for (int i = l; i <= r; i++) {
                arr[x] = matrix[u][i];
                x++;
            }
            //上边界向下移动一个单位
            u++;
            //判断是否越界
            if (u > d) {
                break;
            }

            //从上到下
            for (int i = u; i <= d; i++) {
                arr[x] = matrix[i][r];
                x++;
            }
            //右边界向左移动一个单位
            r--;
            //判断是否越界
            if (r < l) {
                break;
            }
            //从右到左
            for (int i = r; i >= l; i--) {
                arr[x] = matrix[d][i];
                x++;
            }
            //下边界向上移动一个单位
            d--;
            //判断是否越界
            if (d < u) {
                break;
            }

            //从下到上
            for (int i = d; i >= u; i--) {
                arr[x] = matrix[i][l];
                x++;
            }
            //左边界向右移动一个单位
            l++;
            //判断是否越界
            if (l > r) {
                break;
            }
        }
        return arr;
    }
}



















