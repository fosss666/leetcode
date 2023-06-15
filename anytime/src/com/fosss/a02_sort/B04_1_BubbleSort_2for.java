package com.fosss.a02_sort;

/**
 * @author: fosss
 * Date: 2023/6/15
 * Time: 9:53
 * Description:冒泡排序-两层for循环
 */
public class B04_1_BubbleSort_2for {
    /**
     * 每次循环将较大的值放到后面
     */
    public static void bubbleSort(int[] arr) {
        //如果有意义的值有9个，则需要8趟比较。这个数组有arr.length-1个有效数字，所以需要arr.length-1-1趟
        for (int i = 1; i < arr.length - 1; i++) {
            //每趟比较arr.length-i-1次
            for (int j = 1; j < arr.length - i; j++) {
                //交换
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
