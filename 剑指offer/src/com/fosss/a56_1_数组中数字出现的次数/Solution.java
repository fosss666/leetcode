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
        int[] res = solution.singleNumbers2(nums);
        System.out.println("res = " + Arrays.toString(res));
    }

    /**
     * 自解，先排序再判断 17%  18%
     */
    public int[] singleNumbers2(int[] nums) {
        //先排序
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 1;
        while (list.size() < 2 && i < nums.length && j < nums.length) {
            if (nums[i] != nums[j]) {
                //相邻两个数不同的话，说明前一个数时符合要求的
                list.add(nums[i]);
                //判断下一个数
                i++;
                j++;
            } else {
                //这两个数是不符合要求的，跳过这两个数
                i += 2;
                j = i + 1;
            }
        }
        //如果是这种情况 【1，4，4，6】，需要将最后一个数添加到集合中
        if (list.size() < 2) {
            list.add(nums[nums.length - 1]);
        }
        int[] res = new int[2];
        for (int i1 = 0; i1 < list.size(); i1++) {
            res[i1] = list.get(i1);
        }
        return res;
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


























