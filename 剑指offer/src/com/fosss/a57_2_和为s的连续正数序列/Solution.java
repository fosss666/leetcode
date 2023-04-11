package com.fosss.a57_2_和为s的连续正数序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fosss
 * @date 2023/2/27
 * @description： 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。序列内的数字由小到大排列，不同序列按照首个数字从小到大
 * 排列。例：输入：target = 9  输出：[[2,3,4],[4,5]]
 * 限制：1 <= target <= 10^5
 * <p>
 * 思路:
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] res = solution.findContinuousSequence(9);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

    /**
     * 滑动窗口  95%  58%
     */
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 2, sum = 3;
        List<int[]> res = new ArrayList<>();
        //循环退出条件：当sum>=target时，left不断+1，知道left==right时，触发结束条件
        while (left < right) {
            //取得所需结果，存入返回集合
            if (sum == target) {
                int[] ans = new int[right - left + 1];//这里数组长度的设定肥肠的巧妙，非常的值得学习！！
                for (int k = left; k <= right; k++)
                    ans[k - left] = k;//这里也非常的巧妙，k-i能够保证下标每次从0开始，秒啊
                res.add(ans);
            }
            //大于等于目标值，减去最左侧的值，并向右移动  注意s==目标值的是否，由于要寻找下一个符合的数组，所以也要进行处理
            if (sum >= target) {
                sum -= left;
                left++;
            } else {
                //小于目标值，最右侧的值向右移动，并加到和中
                right++;
                sum += right;
            }
        }
        return res.toArray(new int[0][]);
    }

}





















