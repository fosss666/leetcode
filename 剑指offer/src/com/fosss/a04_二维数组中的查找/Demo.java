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
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}

                //{}
        };
        Demo demo = new Demo();
        int target = 10;
        //boolean numberIn2DArray = demo.findNumberIn2DArray(matrix, target);
        boolean numberIn2DArray = demo.findNumberIn2DArray2(matrix, target);
        System.out.println("numberIn2DArray = " + numberIn2DArray);
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

















