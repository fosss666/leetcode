package a01_数组;

import java.util.Arrays;

/**
 * @author: fosss
 * Date: 2023/7/20
 * Time: 10:11
 * Description:
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
public class B03_有序数组的平方 {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] res = f(nums);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 暴力解法-先挨个平方，再排序，时间复杂度 O(n+nlogn)
     * 双指针法-平方后，数组的最大值从数组左边或右边挑选  时间复杂度 O(n)
     */
    public static int[] f(int[] arr) {
        int[] res = new int[arr.length];
        int left = 0, right = arr.length - 1;
        int index = right;

        while (left <= right) {
            int x = arr[left] * arr[left];
            int y = arr[right] * arr[right];
            if (x > y) {
                res[index--] = x;
                left++;
            } else {
                res[index--] = y;
                right--;
            }
        }
        return res;
    }
}
























