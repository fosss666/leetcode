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
        int[] numbers = {2, 2, 2, 0, 1};
        int i = solution.minArray(numbers);
        System.out.println("i = " + i);

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































