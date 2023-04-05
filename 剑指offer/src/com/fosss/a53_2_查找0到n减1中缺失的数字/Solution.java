package com.fosss.a53_2_查找0到n减1中缺失的数字;

/**
 * @author fosss
 * @date 2023/2/20
 * @description： 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，
 * 请找出这个数字
 * 例：输入: [0,1,3]  输出: 2
 * 限制：1 <= 数组长度 <= 10000
 * <p>
 * 思路：
 * 根据题意，数组长度为n，则数字的范围为0,1,2,……,n，共有n+1个元素，则必有一个元素是不在数组中的，因为数组下标为0~n-1，所以数组中首先必须包含和下标相等的数字，
 * 1.因此先遍历数组检查是否如此，如果下标和元素不匹配的话，下标就是那个缺失的数字，如果下标和元素全部匹配的话，说明长度n就是那个缺失的数字。
 * 2.数组是排序的，所以可以用二分法来处理。如果nums[mid]==mid，证明该数及左边的数都是符合的，left++;否则，right=mid-1去够left<=right这个条件
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        int res = solution.missingNumber2(nums);
        System.out.println("res = " + res);
    }

    /**
     * 二分法
     * 数组是升序的，所以一个下标处没有问题的话，证明他左边的元素也没有问题，根据这个
     * 左子数组是符合规则的，右子树组是不符合规则的， 跳出时，变量 left 和 right 分别指向 “右子数组的首位元素” 和 “左子数组的末位元素” 。因此
     * 返回 left 即可
     */
    public int missingNumber2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return left;
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
        if (i == nums.length) {
            return i;
        }
        return -1;
    }
}


























