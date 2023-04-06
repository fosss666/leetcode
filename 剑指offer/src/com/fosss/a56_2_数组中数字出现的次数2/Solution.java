package com.fosss.a56_2_数组中数字出现的次数2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fosss
 * @date 2023/2/25
 * @description： 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字
 * 例：输入：nums = [3,4,3,3] 输出：4
 * 限制：1 <= nums.length <= 10000  1 <= nums[i] < 2^31
 *
 * 思路：
 * 老老实实用哈希表或先排序后遍历判断,牛逼的办法看不懂
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 4, 3, 3};
        int res = solution.singleNumber2(nums);
        System.out.println("res = " + res);
    }

    /**
     * 自解，先排序后判断  47%  61%
     */
    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = 1;

        while (i < nums.length && j < nums.length) {
            if (nums[i] == nums[j]) {
                i += 3;
                j = i + 1;
            } else {
                return nums[i];
            }
        }
        //循环走完说明符合条件的值是数组的最后一个元素，返回最后一个元素
        return nums[nums.length - 1];
    }

    /**
     * 自解，map  38%  79%
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                //map.put(num, map.get(num) + 1);
                map.put(num, -1);
            } else {
                map.put(num, 1);
            }
        }
        //返回值是1的键
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
























