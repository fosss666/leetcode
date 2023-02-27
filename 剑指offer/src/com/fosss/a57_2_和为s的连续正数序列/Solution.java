package com.fosss.a57_2_和为s的连续正数序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fosss
 * @date 2023/2/27
 * @description： 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。序列内的数字由小到大排列，不同序列按照首个数字从小到大排列
 * 例：输入：target = 9  输出：[[2,3,4],[4,5]]
 * 限制：1 <= target <= 10^5
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
        int i = 1, j = 2, s = 3;
        List<int[]> res = new ArrayList<>();
        while (i < j) {
            //取得所需结果，存入返回集合
            if (s == target) {
                int[] ans = new int[j - i + 1];//这里数组长度的设定肥肠的巧妙，非常的值得学习！！
                for (int k = i; k <= j; k++)
                    ans[k - i] = k;//这里也非常的巧妙，k-i能够保证下标每次从0开始，秒啊
                res.add(ans);
            }
            //大于等于目标值，减去最左侧的值，并向右移动  注意s==目标值的是否，由于要寻找下一个符合的数组，所以也要进行处理
            if (s >= target) {
                s -= i;
                i++;
            } else {
                //小于目标值，最右侧的值向右移动，并加到和中
                j++;
                s += j;
            }
        }
        return res.toArray(new int[0][]);
    }

}





















