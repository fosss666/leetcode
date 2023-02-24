package com.fosss.a56_1_数组中数字出现的次数;

import java.util.*;

/**
 * @author fosss
 * @date 2023/2/24
 * @description： 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间
 * 复杂度是O(1)
 * 例：输入：nums = [4,1,4,6] 输出：[1,6] 或 [6,1]
 * 限制：2 <= nums.length <= 10000
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {4, 1, 4, 6};
        Solution solution = new Solution();
        int[] res = solution.singleNumbers(nums);
        System.out.println("res = " + Arrays.toString(res));
    }

    /**
     * 自解，map, 12%  18%
     */
    public int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.remove(num);
            } else {
                map.put(num, num);
            }
        }
        int[] res = new int[2];
        int i = 0;
        for (Integer integer : map.keySet()) {
            res[i++] = integer;
        }
        return res;
    }
}


























