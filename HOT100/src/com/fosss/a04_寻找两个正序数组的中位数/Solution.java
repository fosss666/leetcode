package com.fosss.a04_寻找两个正序数组的中位数;

import java.util.Arrays;

/**
 * @author: fosss
 * Date: 2023/5/1
 * Time: 12:28
 * Description:给定两个大小分别为m和n的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的中位数。算法的时间复杂度应该为 O(log (m+n))
 * 示例1：输入：nums1 = [1,3], nums2 = [2] 输出：2.00000 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例2：输入：nums1 = [1,2], nums2 = [3,4] 输出：2.50000 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println("res = " + res);
    }

    /**
     * 双指针，时间复杂度为O(m+n)
     * 无论总数是奇数还是偶数，都需要遍历到第n/2+1个数，区别在于，偶数的话需要记录第n/2个数然后求平均值
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int n = length1 + length2;
        //定义两个指针i,j
        int i = 0, j = 0;
        //right记录第n/2+1个数，left记录right前面一个数
        int left = -1, right = -1;
        //n/2+1次循环
        for (int k = 0; k <= n / 2; k++) {
            left = right;
            //需要避免数组越界问题
            if (i < length1 && (j >= length2 || nums1[i] <= nums2[j])) {
                right = nums1[i];
                i++;
            } else {
                right = nums2[j];
                j++;
            }
        }
        return n % 2 == 0 ? (left + right) / 2.0 : right;
    }

    /**
     * 合并数组，时间复杂度为O(m+n)
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int i = 0;
        for (int num : nums1) {
            arr[i++] = num;
        }
        for (int num : nums2) {
            arr[i++] = num;
        }
        Arrays.sort(arr);
        int length = arr.length;
        //注意除数要为浮点数，结果才能是浮点数
        return length % 2 == 1 ? arr[length / 2] : (arr[length / 2 - 1] + arr[length / 2]) / 2.0;
    }
}











