package com.fosss.a01_kmp;

import java.util.Arrays;

/**
 * @author: fosss
 * Date: 2023/4/30
 * Time: 21:45
 * Description:
 * kmp算法 参考教程 https://www.cnblogs.com/zzuuoo666/p/9028287.html
 */
public class Solution {

    public static void main(String[] args) {
        String searchString = "abababaabab";
        String modeString = "ababaabab";
        int[] next = getNext(modeString);
        System.out.println("next = " + Arrays.toString(next));
        int[] nextVal = getNextVal(modeString);
        System.out.println("nextVal = " + Arrays.toString(nextVal));
        int res = kmp(searchString, modeString);
        System.out.println("res = " + res);
    }

    /**
     * 进行字符匹配
     */
    public static int kmp(String searchString, String modeString) {
        int n1 = searchString.length();
        int n2 = modeString.length();
        if (n1 == 0 || n2 == 0) {
            return -1;
        }
        int[] next = getNext(modeString);
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (j == -1 || searchString.charAt(i) == modeString.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return j == n2 ? i - j : -1;
    }

    /**
     * 获取nextVal数组
     */
    public static int[] getNextVal(String modeString) {
        int n = modeString.length();
        char[] chars = modeString.toCharArray();
        int[] next = new int[n];
        next[0] = -1;
        int k = -1, j = 0;
        //下面要用到j++后的索引，所以要判断j<n-1
        while (j < n - 1) {
            //因为后面要对j++后的
            if (k == -1 || chars[k] == chars[j]) {
                k++;
                j++;
                if (chars[k] != chars[j]) {
                    next[j] = k;
                } else {
                    //chars[k] == chars[j]的话，next[j]和主串不匹配，next[k]肯定也不匹配，所以直接对next[next[k]]进行匹配判断
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }

    /**
     * 获取next数组
     */
    public static int[] getNext(String modeString) {
        int n = modeString.length();
        char[] chars = modeString.toCharArray();
        int[] next = new int[n];
        next[0] = -1;
        int k = -1, j = 0;
        //下面要用到j++后的索引，所以要判断j<n-1
        while (j < n - 1) {
            //因为后面要对j++后的
            if (k == -1 || chars[k] == chars[j]) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
















