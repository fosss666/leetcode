package com.fosss.a02_sort;

/**
 * @author: fosss
 * Date: 2023/6/14
 * Time: 20:03
 * Description:折半插入排序
 * 在查找插入的位置时采用二分法
 * 减少了查找次数，没有减少移动次数，平均性能由于直接插入排序
 * 时间复杂度O(n^2) 空间复杂度)(1) 稳定
 */
public class B02_BinaryInsertSort {
    public static void binaryInsertSort(int[] arr) {
        for (int i = 2; i < arr.length; i++) {
            //设置哨兵
            arr[0] = arr[i];
            //下面用二分法找arr[i]应该插入到哪里
            int left = 1, right = i - 1;
            while (left <= right) {//！！！
                int m = (right - left) / 2 + left;
                if (arr[0] < arr[m]) {
                    //应该继续向左找
                    right = m - 1;
                } else {
                    //应该向右找
                    left = m + 1;
                }
            }
            //此时right+1是应该插入的位置！！！，将其位置即后边的数向后移动
            for (int j = i - 1; j >= right + 1; j--) {
                arr[j + 1] = arr[j];
            }
            //将哨兵放到应该插入的位置
            arr[right + 1] = arr[0];
        }

    }
}








