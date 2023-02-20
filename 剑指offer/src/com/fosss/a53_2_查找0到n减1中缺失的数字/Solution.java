package com.fosss.a53_2_查找0到n减1中缺失的数字;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fosss
 * @date 2023/2/20
 * @description： 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字
 * 例：输入: [0,1,3]  输出: 2
 * 限制：1 <= 数组长度 <= 10000
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0};
        int res = solution.missingNumber(nums);
        System.out.println("res = " + res);
    }

    /**
     * 自解，100%  99%
     */
    public int missingNumber(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i != num) {
                return i;
            }
            i++;
        }
        //例如：长度为2的数组，元素应为【0，1】，所以他不包含0~2中的2
        if(i==nums.length){
            return i;
        }
        return -1;
    }
}


























