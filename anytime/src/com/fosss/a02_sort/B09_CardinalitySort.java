package com.fosss.a02_sort;

/**
 * @author: fosss
 * Date: 2023/6/15
 * Time: 20:02
 * Description: 基数排序
 *
 */
public class B09_CardinalitySort {

    public static void cardinalitySort(int[] arr) {
        int[][] buckets = new int[10][arr.length - 1];
        //求最大数的位数
        int max = arr[1];
        for (int i = 2; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        int k = 0;
        while (max > 0) {
            max /= 2;
            k++;
        }
        for (int i = 0, n = 1; i < k; i++, n *= 10) {
            //用来记录相同的数有几个了
            int[] count = new int[10];
            //个位、十位、百位……
            for (int j = 1; j < arr.length; j++) {
                //取到当前位
                int t = arr[j] / n % 10;
                buckets[t][count[t]] = arr[j];
                count[t]++;
            }
            //挨个复制到原数组
            int index = 1;
            for (int z = 0; z < 10; z++) {
                for (int m = 0; m < count[z]; m++) {
                    arr[index++] = buckets[z][m];
                }
            }
        }

    }
}



















