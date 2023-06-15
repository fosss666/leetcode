package com.fosss.a02_sort;

/**
 * @author: fosss
 * Date: 2023/6/15
 * Time: 18:48
 * Description: 归并排序
 */
public class B08_MergeSort {
    /**
     * 重载
     */
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 1, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        //先将数组二分
        if (left < right) {
            int mid = (right - left) / 2 + left;
            //向左二分
            mergeSort(arr, left, mid);
            //向右二分
            mergeSort(arr, mid + 1, right);
            //合并
            merge(arr, left, mid, right);
        }
    }

    /**
     * 将两部分各自有序数组合并成一个有序数组
     *
     * @param arr   总数组
     * @param left  第一个数组左边界
     * @param mid   两数组交界处
     * @param right 第二个数组右边界
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        //第一个数组范围为：left~mid-1
        //第二个数组范围为：mid+1~right
        //这两部分数组总长度为right-left+1
        int l1 = left, r1 = mid, l2 = mid + 1, r2 = right;
        //用一个数组暂存合并的数组
        int[] temp = new int[right - left + 2];
        int index = 1;
        while (l1 <= r1 && l2 <= r2) {//为了将两个数组最后一个数也能放到temp中，应加上等号
            if (arr[l1] < arr[l2]) {
                temp[index++] = arr[l1++];
            } else {
                temp[index++] = arr[l2++];
            }
        }
        //将剩余没有合并的部分合并
        //数组1有剩余
        while (l1 <= r1) {
            temp[index++] = arr[l1++];
        }
        //数组2有剩余
        while (l2 <= r2) {
            temp[index++] = arr[l2++];
        }

        //将合并的数组赋值到原数组中
        index = 1;
        while (index < temp.length) {
            arr[index + left - 1] = temp[index++];
        }

    }
}











