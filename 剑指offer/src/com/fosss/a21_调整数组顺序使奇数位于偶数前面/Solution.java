package com.fosss.a21_调整数组顺序使奇数位于偶数前面;


import java.util.*;

/**
 * @author fosss
 * date 2023/1/15
 * description：
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分
 * 例：输入：nums = [1,2,3,4] 输出：[1,3,2,4]   注：[3,1,2,4] 也是正确的答案之一。
 * 提示：0 <= nums.length <= 50000  0 <= nums[i] <= 10000
 * <p>
 * 思路：
 * 1.创建新数组，两次遍历原数组，第一次将奇数放到新数组，第二次将偶数放到新数组
 * 2.用双指针法对上个方法进行改进乘一次遍历，创建新数组(长度为arr.length)，创建left=0,right=arr.length-1，遍历原数组，奇数则newArr[left++]=arr[i],偶数则
 * newArr[right--]=arr[i]
 * 3.原地交换，left=0,right=arr.length-1  while(left<right)时，从左到右找偶数，从右到左找偶数，进行交换
 * 4.借助队列进行奇偶数的调换：创建队列存储偶数的下标，遍历数组，如果是偶数，则将下标放入队列，如果是奇数，则判断队列是否为空，不为空，则弹出一个
 * 下标，进行交换后，将偶数新的下标存入队列
 */
public class Solution {

    public static void main(String[] args) {
        //int[] nums = {2, 16, 3, 5, 13, 1, 16, 1, 12, 18, 11, 8, 11, 11, 5, 1};
        int[] nums = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        int[] arr = solution.exchange(nums);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 原地交换
     */
    public int[] exchange5(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            //从左往右找到偶数
            while (left < right && isOod(nums[left])) {
                left++;
            }
            //从右往左找到奇数
            while (left < right && !isOod(nums[right])) {
                right--;
            }
            if (left < right) {
                //进行交换
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
                left++; //!!
                right--;//!!
            }
        }
        return nums;
    }

    /**
     * 双指针+一次遍历
     */
    public int[] exchange4(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = n - 1;
        for (int num : nums) {
            if (num % 2 == 1) {
                res[left++] = num;
            } else {
                res[right--] = num;
            }
        }
        return res;
    }

    /**
     * 两次遍历
     */
    public int[] exchange3(int[] nums) {
        int n = nums.length, index = 0;
        int[] res = new int[n];
        for (int num : nums) {
            if (num % 2 == 1) {
                res[index++] = num;
            }
        }
        for (int num : nums) {
            if (num % 2 == 0) {
                res[index++] = num;
            }
        }
        return res;
    }

    /**
     * 自解-挑选奇数-超时。。。
     */
    public int[] exchange2(int[] nums) {
        //将数组转为集合
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
            if (isOod(num)) {
                list2.add(num);
            }
        }
        list.removeAll(list2);
        list2.addAll(list);
        for (int i = 0; i < list2.size(); i++) {
            nums[i] = list2.get(i);
        }
        return nums;
    }

    /**
     * 自解-调换顺序
     */
    public int[] exchange(int[] nums) {
        //记录偶数下标
        Queue<Integer> oIndex = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (isOod(num)) {
                //和偶数交换
                //弹出偶数下标
                Integer index = oIndex.poll();
                if (index != null) {
                    int t = nums[i];
                    nums[i] = nums[index];
                    nums[index] = t;
                    //存入现在的偶数坐标(在确实已经发生交换的前提下)
                    oIndex.add(i);
                }
            } else {
                oIndex.add(i);
            }
        }
        return nums;
    }

    /**
     * 判断是奇数还是偶数的工具方法 奇数返回true 偶数返回false
     */
    private boolean isOod(int num) {
        if (num % 2 == 0) {
            return false;
        }
        return true;
    }
}























