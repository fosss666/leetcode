package com.fosss.a40_最小的k个数;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author fosss
 * @date 2023/2/4
 * @description： 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4
 * 例：输入：arr = [3,2,1], k = 2  输出：[1,2] 或者 [2,1]
 * 限制：0 <= k <= arr.length <= 10000    0 <= arr[i] <= 10000
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        Solution solution = new Solution();
        int[] res = solution.getLeastNumbers(arr, 2);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 自解，排序
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        //Arrays.sort(arr);
        quickSort(arr, 0, arr.length - 1);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 快排
     */
    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left, r = right;
        int key = arr[left];
        while (l < r) {
            while (l < r && arr[r] > key) {
                r--;
            }
            if (l < r) {
                arr[l] = arr[r];
                l++;
            }
            while (l < r && arr[l] < key) {
                l++;
            }
            if (l < r) {
                arr[r] = arr[l];
                r--;
            }
        }
        arr[l] = key;
        quickSort(arr, left, l - 1);
        quickSort(arr, l + 1, right);

    }
}



























