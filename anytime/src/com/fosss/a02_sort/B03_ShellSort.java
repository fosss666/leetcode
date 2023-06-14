package com.fosss.a02_sort;

/**
 * @author: fosss
 * Date: 2023/6/14
 * Time: 21:11
 * Description:希尔排序
 * 插入排序在序列基本有序时效率较高，希尔排序就是插入排序的优化，先将序列按照一定增量进行分组（每相隔一定值的数为一组），这个增量不断缩小
 */
public class B03_ShellSort {
    /**
     * 以增量为数组长度每次除以2为例，数据结构课中是用一个增量数组，每次调用其中一个值
     */
    public static void shellSort(int[] arr) {
        for (int zengliang = arr.length / 2; zengliang > 0; zengliang /= 2) {
            //每个分组都进行插入排序，这里用直接插入排序
            for (int i = zengliang + 1; i < arr.length; i++) {
                arr[0] = arr[i];
                int j;
                //!!!注意：j现在每次-zengliang，所以可能导致循环无法进入else从而无法插入，所以应该把插入操作放在循环外边
                for (j = i - zengliang; j > 0; j -= zengliang) {
                    if (arr[0] < arr[j]) {
                        //移动
                        arr[j + zengliang] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + zengliang] = arr[0];

            }
        }

    }
}




















