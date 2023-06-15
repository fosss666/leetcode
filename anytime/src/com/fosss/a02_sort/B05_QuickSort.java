package com.fosss.a02_sort;

/**
 * @author: fosss
 * Date: 2023/6/15
 * Time: 10:22
 * Description: 快速排序
 * 时间复杂度O(n*以2为底n的对数) 空间复杂度O(以2为底n的对数) 不稳定
 */
public class B05_QuickSort {
    /**
     * 重载
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 1, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int key = arr[left];
            int l = left, r = right;
            while (l < r) {
                while (l < r && key < arr[r]) {
                    r--;
                }
                if (l < r) {
                    arr[l] = arr[r];
                    l++;
                }
                while (l < r && key > arr[l]) {
                    l++;
                }
                if (l < r) {
                    arr[r] = arr[l];
                    r--;
                }
            }
            //循环结束时l==r
            arr[l] = key;
            //左序列排序
            quickSort(arr, left, l - 1);
            //右序列排序
            quickSort(arr, l + 1, right);
        }
    }
}











