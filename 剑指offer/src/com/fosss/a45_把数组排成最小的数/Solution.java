package com.fosss.a45_把数组排成最小的数;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: fosss
 * Date: 2023/3/12
 * Time: 12:15
 * Description:输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 * 示例：输入: [10,2]  输出: "102"
 * 限制：0 < nums.length <= 100
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 10, 2};
        String res = solution.minNumber2(nums);
        System.out.println("res = " + res);
    }

    /**
     * 自定义排序，Arrays.sort  97%   53%
     */
    public String minNumber2(int[] nums) {
        String[] strings = new String[nums.length];
        //转为字符串数组
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string);
        }
        return sb.toString();
    }

    /**
     * 自定义排序，快速排序  99%  43%
     */
    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        //转为字符串数组
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        //自定义快排
        quickSort(strings, 0, strings.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string);
        }
        return sb.toString();

    }

    private void quickSort(String[] strings, int left, int right) {
        if (left < right) {
            String mid = strings[left];
            int l = left, r = right;
            while (l < r) {
                //x+y>y+x时，交换
                while (l < r && (mid + strings[r]).compareTo(strings[r] + mid) <= 0) {
                    r--;
                }
                if (l < r) {
                    strings[l] = strings[r];
                    l++;
                }
                while (l < r && (mid + strings[l]).compareTo(strings[l] + mid) > 0) {
                    l++;
                }
                if (l < r) {
                    strings[r] = strings[l];
                    r--;
                }
            }
            //循环退出时 l==r
            strings[l] = mid;

            quickSort(strings, left, r - 1);
            quickSort(strings, l + 1, right);
        }
    }

}
























