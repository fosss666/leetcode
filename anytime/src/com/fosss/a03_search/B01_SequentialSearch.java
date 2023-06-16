package com.fosss.a03_search;

/**
 * @author: fosss
 * Date: 2023/6/16
 * Time: 12:57
 * Description: 顺序查找
 */
public class B01_SequentialSearch {
    public static int sequentialSearch(int[] arr, int value) {
        //下标为0处为哨兵
        arr[0] = value;
        int i;
        /**
         * 这样只能查找value必须在数组中
         */
        for (i = 1; arr[i] != arr[0]; i++) ;
        return i;
    }
}
