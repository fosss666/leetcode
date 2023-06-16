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
        int[] arr = {0, 1, 4, 2, 4, 9, 43, 34};
        int value = 9;

        //1.顺序查找
        int i = B01_SequentialSearch.sequentialSearch(arr, value);
        System.out.println("i = " + i);

    }
}
