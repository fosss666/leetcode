package com.fosss.a02_sort;

/**
 * @author: fosss
 * Date: 2023/6/15
 * Time: 10:08
 * Description: 冒泡排序-while循环
 * 复杂度同上
 */
public class B04_2_BubbleSort_while {
    /**
     * 优化，用一个变量记录是否存在无序现象，如果不存在，说明数组已经有序了，就不用再进行while循环了
     */
    public static void bubbleSort(int[] arr) {
        int m = arr.length - 1;//需要确定的较大数的下标
        //记录是否存在无序现象
        int flag = 1;
        while (m > 0 && flag == 1) {
            //每次初始值设置为0，即默认没有进入for
            flag = 0;
            for (int i = 1; i < m; i++) {
                if (arr[i] > arr[i + 1]) {
                    //进入了就标记
                    flag = 1;
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            //m处已经是数组的较大值了，下面确定m-1处的较大值
            m--;
        }
    }
}
