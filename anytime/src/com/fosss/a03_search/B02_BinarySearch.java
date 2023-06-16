package com.fosss.a03_search;

/**
 * @author: fosss
 * Date: 2023/6/16
 * Time: 13:16
 * Description:折半查找
 * 时间复杂度O(以2为底n的对数)
 */
public class B02_BinarySearch {
    /**
     * 使用whiel循环实现
     */
    public static int binarySearch_while(int[] arr, int value) {
        int left = 1, right = arr.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] == value) {
                return mid;
            } else if (value < arr[mid]) {
                //向左查找
                right = mid - 1;
            } else {
                //向右查找
                left = mid + 1;
            }
        }
        //找不到返回-1
        return -1;
    }
}
