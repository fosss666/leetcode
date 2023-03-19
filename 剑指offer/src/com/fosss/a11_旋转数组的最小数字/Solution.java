package com.fosss.a11_旋转数组的最小数字;

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
 *
 * 思路：
 * 1.二分法：mid=(right-left)/2+left  以left<right为循环条件，  如果nums[mid]>右边的值，则以mid+1为左边界向右查找；如果nums[mid]<右边的值，nums[mid]可能是最小
 * 值，也可能不是，以mid为右边界进行查找；如果存在重复数字，nums[mid]==右边的值，则令右边界--。最后left==right，nums[left]为最小值
 * 2.另外，倒序寻找最小值也不失为一种思路，只是旋转数组越接近原升序数组，所需时间越多
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

        int left=0,right=numbers.length-1;
        int mid=0;
        while(left<right){
            mid=(right-left)/2+left;
            if(numbers[mid]>numbers[right]){
                left=mid+1;
            }else if(numbers[mid]<numbers[right]){
                right=mid;
            }else if(numbers[mid]==numbers[right]){
                right--;
            }
        }
        return numbers[left];

/*
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
        return numbers[mid];*/
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































