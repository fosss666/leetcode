package com.fosss.a03_search;

/**
 * @author: fosss
 * Date: 2023/6/16
 * Time: 12:58
 * Description:
 */
public class A_main {

    public static void main(String[] args) {
        //从下标为1开始存储数据
        int[] arr = {0, 1, 2, 4, 9, 34, 43};
        int value = 9;

        /**
         * 1.顺序查找
         */
        //int i = B01_SequentialSearch.sequentialSearch(arr, value);

        /**
         * 折半查找
         */
        //int i = B02_BinarySearch.binarySearch_while(arr, value);
        int i = B02_BinarySearch.binarySearch_recursion(arr, value);

        System.out.println("i = " + i);
    }
}
