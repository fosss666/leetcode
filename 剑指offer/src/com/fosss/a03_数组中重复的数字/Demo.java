package com.fosss.a03_数组中重复的数字;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fosss
 * date 2023/1/2
 * description：
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * 例：输入：[2, 3, 1, 0, 2, 5, 3]   输出：2 或 3
 * 限制：2 <= n <= 100000
 */
public class Demo {
    public static void main(String[] args) {
        //int[] nums={2,3,1,0,2,5,3};
        int[] nums={3,4,2,1,1,0};
        Demo demo = new Demo();
        //int repeatNumber = demo.findRepeatNumber(nums);
        //int repeatNumber = demo.findRepeatNumber2(nums);
        int repeatNumber = demo.findRepeatNumber3(nums);
        System.out.println("repeatNumber = " + repeatNumber);
    }

    /**
     * 原地交换
     * 遍历数组并通过交换操作，使元素的索引与值一一对应（即 nums[i] = inums[i]=i ）
     * 遍历中，第一次遇到数字 xx 时，将其交换至索引 xx 处；而当第二次遇到数字 xx 时，一定有 nums[x] = xnums[x]=x ，此时即可得到一组重复数字
     * 利用到所有数字都在 0～n-1 的范围内保证nums数组不会越界
     */
    public int findRepeatNumber3(int[] nums){
        //只能用while循环，因为i不能每次循环都＋1，否则导致无法判断每个数字
        int i=0;
        while (i < nums.length){
            if(nums[i]==i){
                i++;
                continue;
            }
            if(nums[i]==nums[nums[i]]){
                //重复数字
                return nums[i];
            }
            //数字的交换
            int temp=nums[i];
            nums[i]=nums[nums[i]];
            nums[temp]=temp;
        }
        return -1;
    }

    /**
     * 利用set集合不可添加重复元素特性
     */
    public int findRepeatNumber2(int[] nums){
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            boolean isSuccess = set.add(num);
            if (!isSuccess) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 自解
     */
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int repeatNumber=nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if(repeatNumber==nums[j]){
                    return repeatNumber;
                }
            }
        }
        return -1;
    }
}


















