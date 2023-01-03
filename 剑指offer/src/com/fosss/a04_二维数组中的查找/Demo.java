package com.fosss.a04_二维数组中的查找;

/**
 * @author fosss
 * date 2023/1/2
 * description：
 * 在一个 n * m 的二维数组中，每一行都按照从左到右非递减的顺序排序，每一列都按照从上到下非递减的顺序排序。请完成一个高效的函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 现有矩阵 matrix 如下：
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。  给定 target = 20，返回 false。
 * 限制：0 <= n <= 1000  0 <= m <= 1000
 */
public class Demo {
    public static void main(String[] args) {
        int[][] matrix = {
                //{1, 4, 7, 11, 15},
                //{2, 5, 8, 12, 19},
                //{3, 6, 9, 16, 22},
                //{10, 13, 14, 17, 24},
                //{18, 21, 23, 26, 30}

                //{}
        };
        Demo demo = new Demo();
        int target = 10;
        //boolean numberIn2DArray = demo.findNumberIn2DArray(matrix, target);
        //boolean numberIn2DArray = demo.findNumberIn2DArray2(matrix, target);
        boolean numberIn2DArray = demo.findNumberIn2DArray3(matrix, target);
        System.out.println("numberIn2DArray = " + numberIn2DArray);
    }

    /**
     * Z 字形查找
     * 我们可以从矩阵matrix 的右上角 (0, n-1)(0,n−1) 进行搜索。在每一步的搜索过程中，如果我们位于位置(x,y)，
     * 那么我们希望在以matrix 的左下角为左下角、以 (x, y)为右上角的矩阵中进行搜索，即行的范围为[x,m−1]，列的范围为 [0, y]
     * 如果 matrix[x, y] ==target，说明搜索完成；
     * 如果 matrix[x, y] >target，由于每一列的元素都是升序排列的，那么在当前的搜索矩阵中，所有位于第y列的元素都是严格大于target的，
     * 因此我们可以将它们全部忽略，即将y减少1；
     * 如果 matrix[x, y] <target，由于每一行的元素都是升序排列的，那么在当前的搜索矩阵中，所有位于第x行的元素都是严格小于target的，
     * 因此我们可以将它们全部忽略，即将x增加1。
     * 在搜索的过程中，如果我们超出了矩阵的边界，那么说明矩阵中不存在target。
     */
    public boolean findNumberIn2DArray3(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            //空数组
            return false;
        }
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                //向下找
                x++;
            } else if (matrix[x][y] > target) {
                //向左找
                y--;
            }
        }
        return false;
    }

    /**
     * 二分查找（数组从左到右是递增的）
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        for (int[] arr : matrix) {
            int result = getBinarySearch(arr, 0, arr.length - 1, target);
            if (result != -1) {
                return true;
            }
        }
        return false;
    }

    //二分查找算法
    private int getBinarySearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return getBinarySearch(arr, mid + 1, right, target);
        } else {
            return getBinarySearch(arr, left, mid - 1, target);
        }
    }


    /**
     * 自解
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = 0;
        for (i = 0; i < matrix.length; i++) {
            //防止二维数组中某一行中没有元素
            if (matrix[i].length < 1) {
                continue;
            }
            if (matrix[i][0] == target) {
                return true;
            }
            if (matrix[i][0] > target) {
                break;
            }
        }
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < matrix[j].length; k++) {
                if (matrix[j][k] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}

















