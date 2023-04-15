package com.fosss.a61_扑克牌中的顺子;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: fosss
 * Date: 2023/3/14
 * Time: 21:23
 * Description:从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而
 * 大、小王为 0 ，可以看成任意数字。A 不能视为 14
 * 示例：输入: [1,2,3,4,5]   输出: True
 * 限制：数组长度为 5    数组的数取值为 [0, 13]
 * 解题思路：此5张牌是顺子的充分条件是：1.除大小王外，所有牌无重复 2.设此5张牌中最大的牌为max,最小的牌为min(大小王除外)，则需满足：max-min<5
 * <p>
 * 思路：
 * 按照这个条件进行求解：1.除大小王外，所有牌无重复 2.设此5张牌中最大的牌为max,最小的牌为min(大小王除外)，则需满足：max-min<5
 * 1.先从小到大排序，在遍历对上面两个条件进行判断，注意最小值不一定是数组的第一个值，因为可能为0，所以最小值为第一个不为0的值
 * 2.不排序直接遍历，记录最大值和最小值在最后判断差，用set判断是否有不为0的重复
 */
public class Solution {

    /**
     * 排序+遍历    100%  48%
     */
    public boolean isStraight2(int[] nums) {
        Arrays.sort(nums);
        int min = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //寻找min的下标
            if (nums[i] == 0) {
                min++;
            } else if (nums[i] == nums[i + 1]) {
                //判断有没有重复的数字
                return false;
            }
        }
        return nums[nums.length - 1] - nums[min] < 5;
    }

    /**
     * set+遍历    100%  61%
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = 14, max = -1;
        for (int num : nums) {
            if (num != 0 && !set.contains(num)) {
                set.add(num);
            } else if (set.contains(num)) {
                return false;
            }
            min = num < min && num != 0 ? num : min;
            max = num > max && num != 0 ? num : max;
        }
        return max - min < 5;
    }
}



























