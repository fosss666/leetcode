package a01_数组;

/**
 * @author: fosss
 * Date: 2023/7/20
 * Time: 13:48
 * Description:
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 提示：
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 */
public class B04_长度最小的子数组 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        //int res = f1(nums, 7);
        int res = f2(nums, 7);
        System.out.println("res = " + res);
    }

    /**
     * 暴力解法 O(n^2)
     */
    public static int f1(int[] arr, int val) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum >= val) {
                    int length = j - i + 1;
                    res = res < length ? res : length;
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    /**
     * 滑动窗口
     */
    public static int f2(int[] arr, int val) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        //i为窗口左边界，j为窗口右边界
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            while (sum >= val) {
                int length = j - i + 1;
                res = res < length ? res : length;
                //左边界向右滑动
                sum -= arr[i++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}

















