package com.fosss.a02_sort;

/**
 * @author: fosss
 * Date: 2023/6/14
 * Time: 19:35
 * Description:测试类
 */
public class A_main {
    public static final int MAXSIZE = 8;//要排序的顺序表的最大长度

    public static void main(String[] args) {
        int[] arr = new int[MAXSIZE + 1];//从下标1处开始存储数据，下标为0处用来做哨兵（相当于一个临时变量存储要插入的值）
        arr[1] = 13;
        arr[2] = 6;
        arr[3] = 3;
        arr[4] = 31;
        arr[5] = 9;
        arr[6] = 27;
        arr[7] = 5;
        arr[8] = 11;
        System.out.println("原数组：");
        print(arr);
        System.out.println("排序后的数组：");
        //调用排序算法

        /**
         *  1.直接插入排序
         */
        //B01_InsertSort.insertSort(arr);
        //print(arr);

        /**
         * 2.折半插入排序
         */
        //B02_BinaryInsertSort.binaryInsertSort(arr);
        //print(arr);

        /**
         * 3.希尔排序
         */
        B03_ShellSort.shellSort(arr);
        print(arr);

    }

    /**
     * 输出除哨兵外的数组的值
     */
    public static void print(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

















