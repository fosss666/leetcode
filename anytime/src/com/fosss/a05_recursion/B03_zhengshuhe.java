package com.fosss.a05_recursion;

/**
 * @author: fosss
 * Date: 2023/6/22
 * Time: 19:52
 * Description:输出一个正整数n的所有整数和形式
 */
public class B03_zhengshuhe {
    public static void main(String[] args) {
        zhengshuhe(4, k);
        System.out.println("s = " + s);
    }

    static int[] a = new int[100];
    static int s = 0;//记录不同的整数和个数
    static int k = 0;//数组下标从0开始

    public static void zhengshuhe(int n, int k) {
        if (n > 0) {
            for (int i = n; i >= 1; i--) {
                a[k] = i;

                zhengshuhe(n - i, k + 1);
            }
        } else {
            for (int i = 0; i < k; i++) {
                System.out.print(a[i] + " ");
            }
            s++;
            System.out.println();
        }

    }
}
