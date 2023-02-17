package com.fosss.a51_数组中的逆序对;

/**
 * @author fosss
 * @date 2023/2/17
 * @description： 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数
 * 例：输入: [7,5,6,4]  输出: 5
 * 限制：0 <= 数组长度 <= 50000
 * 提示：先写出归并排序，再在代码中添加计数代码
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 1};
        Solution solution = new Solution();
        int res = solution.reversePairs2(nums);
        System.out.println("res = " + res);
    }

    /**
     * 归并排序
     */
    public int reversePairs2(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    //统计逆序对数
    int count = 0;

    //归并排序
    private int mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = (r - l) / 2 + l;
            //向左递归，统计左边的逆序对数
            mergeSort(nums, 0, mid);
            //向右递归，统计右边的逆序对数
            mergeSort(nums, mid + 1, r);
            //合并，统计整体的逆序对数
            merge(nums, l, mid, mid + 1, r);
            return this.count;
        }
        return 0;
    }

    //合并
    private void merge(int[] nums, int l1, int r1, int l2, int r2) {
        //进行复制
        int[] temp = new int[r2 - l1 + 1];
        int i = l1, j = l2;
        int t = 0;
        while (i <= r1 && j <= r2) {
            if (nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                //统计逆序对数,当左边的数大于右边的数时，则这个数到中间位置的数的个数即为逆序对数
                count += j - i;
                temp[t++] = nums[j++];
            }
        }
        //将没有复制的元素进行复制
        while (i <= r1) {
            temp[t++] = nums[i++];
        }
        while (j <= r2) {
            temp[t++] = nums[j++];
        }
        //复制到原数组
        t = 0;
        while (l1 <= r2) {
            nums[l1++] = temp[t++];
        }
    }

    /**
     * 冒泡排序，交换了多少次，就有多少个逆序对,时间复杂度和上一个一样O(n^2),也会超出时间限制
     */
    //public int reversePairs2(int[] nums) {
    //    for (int i = 0; i < nums.length; i++) {
    //        for (int j = i+1; j < nums.length; j++) {
    //            if(nums[i] > nums[j]){
    //                //实行交换操作
    //
    //               //count++;
    //            }
    //        }
    //    }
    //}

    /**
     * 自解，不管怎么样，先暴力一下,超出时间限制
     */
    public int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}










