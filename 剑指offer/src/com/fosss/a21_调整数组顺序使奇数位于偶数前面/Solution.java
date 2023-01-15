package com.fosss.a21_调整数组顺序使奇数位于偶数前面;

import java.util.*;

/**
 * @author fosss
 * date 2023/1/15
 * description：
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分
 * 例：输入：nums = [1,2,3,4] 输出：[1,3,2,4]   注：[3,1,2,4] 也是正确的答案之一。
 * 提示：0 <= nums.length <= 50000  0 <= nums[i] <= 10000
 */
public class Solution {

    public static void main(String[] args) {
        //int[] nums = {2, 16, 3, 5, 13, 1, 16, 1, 12, 18, 11, 8, 11, 11, 5, 1};
        int[] nums = {1,2,3,4};
        Solution solution = new Solution();
        int[] arr = solution.exchange(nums);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 自解-调换顺序
     */
    public int[] exchange(int[] nums) {
        //记录偶数下标
        Queue<Integer> oIndex=new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (isOod(num)) {
                //和偶数交换
                //弹出偶数下标
                Integer index = oIndex.poll();
                if (index!=null) {
                    int t = nums[i];
                    nums[i] = nums[index];
                    nums[index] = t;
                    //存入现在的偶数坐标(在确实已经发生交换的前提下)
                    oIndex.add(i);
                }
            } else {
                oIndex.add(i);
            }
        }
        return nums;
    }

    /**
     * 判断是奇数还是偶数的工具方法 奇数返回true 偶数返回false
     */
    private boolean isOod(int num) {
        if (num % 2 == 0) {
            return false;
        }
        return true;
    }
}























