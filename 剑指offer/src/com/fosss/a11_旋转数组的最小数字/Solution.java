package com.fosss.a11_旋转数组的最小数字;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fosss
 * date 2023/1/8
 * description：
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，
 * 数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 例：输入：numbers = [3,4,5,1,2]  输出：1
 * 提示：
 * n == numbers.length
 * 1 <= n <= 5000
 * -5000 <= numbers[i] <= 5000
 * numbers 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {3, 1};
        //int i = solution.minArray(numbers);
        int i = solution.minArray2(numbers);
        System.out.println("i = " + i);

    }

    /**
     * 二分查找法
     */
    public int minArray2(int[] numbers) {

        int left = 0;
        int right = numbers.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;//之所以不写成(left+right+/2是防止left+right后的值太大超出int范围！！！！！！！！！
            if (numbers[mid] < numbers[right]) {
                //向左找，抛弃查找right右边的数
                right = mid;//注意这里不能-1，否则最小值的下标为此次循环的mid的时候，导致下一次循环跳过了此次mid,mid的值发生改变，而不能返回此次循环正确的mid
            } else if (numbers[mid] > numbers[right]) {
                //向右找，抛弃查找right左边的数
                left = mid + 1;//注意这里要+1，否则可能出现mid始终等于left的情况
            } else {
                //numbers[mid]==numbers[right],不能保证mid左边没有更小的值，所以不能直接结束，
                // 因为此时numbers[right]有numbers[mid]这个替代值，所以可以忽略right代表的下标
                right--;
            }
        }
        return numbers[mid];
    }

    /**
     * 自解_倒着比较大小
     */
    public int minArray(int[] numbers) {
        //numbers是已经经过旋转的数组
        int n = numbers.length - 1;
        for (int i = n; i > 0; i--) {
            if (numbers[i - 1] > numbers[i]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }
}































