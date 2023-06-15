package com.fosss.a02_sort;

/**
 * @author: fosss
 * Date: 2023/6/15
 * Time: 11:07
 * Description:简单选择排序
 * 时间复杂度O(n^2) 空间复杂度O(1) 稳定
 * 没有利用到上次选择的结果，导致速度慢，可以用树形选择排序优化
 */
public class B06_SelectSort {

    public static void selectSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] < arr[j] ? minIndex : j;
            }
            //交换
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
