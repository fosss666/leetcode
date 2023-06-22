package com.fosss.a05_recursion;

/**
 * @author: fosss
 * Date: 2023/6/22
 * Time: 19:26
 * Description:找出从自然数1、2、3、……、m中任取k个数的所有组合
 */
public class B02_zuhe {

    public static void main(String[] args) {
        //用a[0]来存储最初的k值，因为k在递归中是会变化的
        a[0] = 3;
        zuhe(5, a[0]);
    }

    static int[] a = new int[100];

    public static void zuhe(int m, int k) {
        for (int i = m; i >= k; i--) {
            a[k] = i;
            if (k > 1) {
                zuhe(i - 1, k - 1);
            } else {
                for (int j = a[0]; j > 0; j--) {
                    System.out.print(a[j] + " ");
                }
                System.out.println();
            }
        }
    }
}

















