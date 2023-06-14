package com.fosss.a02_sort;

/**
 * @author: fosss
 * Date: 2023/6/14
 * Time: 19:43
 * Description:直接插入排序
 * 从第一个数开始，假定他为有序数组，从下一个数开始向这个有序数组中选择合适位置插入
 * 最好情况下每趟只需要比较1次，即原数组有序，总比较次数为n-1
 * 时间复杂度O(n^2) 空间复杂度O(1) 稳定
 */
public class B01_InsertSort {
    /**
     * @param arr 要排序的数从下标1开始，下标0处为哨兵
     */
    public static void insertSort(int[] arr) {
        //假定第一个数（下标为1处）已经有序，从下一处开始排序
        for (int i = 2; i < arr.length; i++) {

            //设置哨兵为要向有序数组中插入的数
            arr[0] = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[0] < arr[j]) {
                    //向后移动
                    arr[j + 1] = arr[j];
                } else {
                    arr[j + 1] = arr[0];
                    break;//退出循环
                }
            }

        }
    }
}
















