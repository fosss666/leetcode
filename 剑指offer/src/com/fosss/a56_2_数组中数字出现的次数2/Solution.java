package com.fosss.a56_2_数组中数字出现的次数2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fosss
 * @date 2023/2/25
 * @description： 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字
 * 例：输入：nums = [3,4,3,3] 输出：4
 * 限制：1 <= nums.length <= 10000  1 <= nums[i] < 2^31
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 4, 3, 3};
        int res = solution.singleNumber(nums);
        System.out.println("res = " + res);
    }

    /**
     * 自解，map  38%  79%
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
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
























