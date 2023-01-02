package com.fosss.a03_数组中重复的数字;

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
        int[] nums={2,3,1,0,2,5,3};
        Demo demo = new Demo();
        int repeatNumber = demo.findRepeatNumber(nums);
        System.out.println("repeatNumber = " + repeatNumber);
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


















