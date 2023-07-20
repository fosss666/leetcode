package a01_数组;

import java.util.Arrays;

/**
 * @author: fosss
 * Date: 2023/7/20
 * Time: 14:15
 * Description:
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 */
public class B05_螺旋矩阵 {
    public static void main(String[] args) {
        int[][] res = f(3);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

    /**
     * 限定边界
     */
    public static int[][] f(int n) {
        int[][] res = new int[n][n];
        //限定上下左右边界
        int left = 0, up = 0, right = n - 1, down = n - 1;
        int t = 1;
        while (t <= n * n) {
            //按照向右，向下，向左，向上的顺序循环打印
            int l = left;
            while (l <= right) {
                res[up][l++] = t++;
            }
            up++;//上边界向下移动一行

            int u = up;
            while (u <= down) {
                res[u++][right] = t++;
            }
            right--;//右边界向左移动

            int r = right;
            while (r >= left) {
                res[down][r--] = t++;
            }
            down--;//下边界向上移动

            int d = down;
            while (d >= up) {
                res[d--][left] = t++;
            }
            left++;//左边界向右移动
        }
        return res;
    }
}

























