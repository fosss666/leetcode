package a01_数组;

import java.util.Arrays;

/**
 * @author: fosss
 * Date: 2023/7/19
 * Time: 22:01
 * Description:
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class B02_移除元素 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        //int length = f1(nums, val);
        //int length = f2(nums, val);
        int length = f3(nums, val);
        System.out.println("length=" + length + " " + Arrays.toString(nums));
    }

    /**
     * 暴力解法 O(n^2)
     */
    public static int f1(int[] arr, int val) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (arr[i] == val) {
                for (int j = i + 1; j < length; j++) {
                    arr[j - 1] = arr[j];
                }
                length--;
                i--;//进入下个循环后i会+1
            }
        }
        return length;
    }

    /**
     * 快慢指针法
     */
    public static int f2(int[] arr, int val) {
        int slow = 0;
        //int length = arr.length;
        for (int fast = 0; fast < arr.length; fast++) {
            if (arr[fast] != val) {
                arr[slow++] = arr[fast];
            } /*else {
                length--;
            }*/
        }
        //return length;
        return slow;
    }


    /**
     * 相向双指针法
     */
    public static int f3(int[] arr, int val) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            //从左到右找第一个与val相等的值
            while (left <= right && arr[left] != val) {
                left++;
            }
            //从右到左找第一个与val不相等的值
            while (left <= right && arr[right] == val) {
                right--;
            }
            //交换
            if (left <= right) {
                arr[left] = arr[right];
                left++;
                right--;
            }
        }
        return left;
    }

}


















