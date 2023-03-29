package com.fosss.a39_数组中出现次数超过一半的数字;

import java.util.*;

/**
 * @author fosss
 * @date 2023/2/3
 * @description： 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。你可以假设数组是非空的，并且给定的数组总是存在多数元素
 * 例：输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]  输出: 2
 * 限制：1 <= 数组长度 <= 50000
 * <p>
 * 思路：
 * 1.直接遍历数组，借助map来记录重复数字出现的次数，找到出现次数超过数组长度一半的数字
 * 2.先排序，再遍历数组，连续出现超过数组长度一半则直接返回
 * 3.若数组中一定有一个数字出现次数超过数组长度一半，则先对数组进行排序，返回中间的数即可
 * 4.摩尔投票法：极限一换一，设变量x，votes，x用来保存要找的数，votes用来标记，当votes==0时，更新x。遍历数组，当num==x时，votes+1;否则votes-1;
 * 最后的x就是要寻找的数字
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        Solution solution = new Solution();
        int res = solution.majorityElement2(arr);
        System.out.println("res = " + res);
    }

    /**
     * 摩尔投票法
     * https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
     */
    public int majorityElement3(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }

    /**
     * 排序取中间，因为此题中一定存在一个个数超过长度一半的数，所以进行排序后中间的那个数就是所要找的数
     * 57.41%  81.81%
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 自解，遍历查找,map记录
     * 执行用时：13 ms, 在所有 Java 提交中击败了19.97%的用户
     * 内存消耗：45.1 MB, 在所有 Java 提交中击败了45.53%的用户
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            boolean flag = false;
            for (Integer key : map.keySet()) {
                //map中有这个数，就让这个key的个数加一
                if (key == num) {
                    map.put(key, map.get(key) + 1);
                    flag = true;
                }
            }
            if (!flag) {
                //map中没有这个数，就添加进去
                map.put(num, 1);
            }
        }
        //找到map中value>长度一般的返回
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        //没有的话返回-1
        return -1;
    }
}



















