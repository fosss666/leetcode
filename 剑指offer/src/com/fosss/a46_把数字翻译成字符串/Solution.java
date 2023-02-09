package com.fosss.a46_把数字翻译成字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fosss
 * @date 2023/2/9
 * @description： 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法
 * 例：
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * 限制：0 <= num < 231
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.translateNum2(12);
        System.out.println("res = " + res);
    }

    /**
     * 动态规划3-数字求余
     */
    public int translateNum3(int num) {
        int a = 1, b = 1;
        //num的最后一位数
        int y = num % 10;
        int x;
        while (num != 0) {
            num /= 10;
            x = num % 10;
            int n = x * 10 + y;
            int c = n >= 10 && n <= 25 ? a + b : a;
            //更新
            y = x;
            b = a;
            a = c;
        }
        return a;
    }

    /**
     * 动态规划2-优化空间及匹配规则判断
     * 因为动态规划数组中实际上只有两个数的位置有用，所以只要用两个变量就行，可以节省空间
     */
    public int translateNum2(int num) {
        String s = num + "";
        int a = 1, b = 1;
        //因为要截取i-2和i-1这两个下标处的数字，而subString这个方法截取的是左闭右开的，所以i<=s.length()
        for (int i = 2; i <= s.length(); i++) {
            String substring = s.substring(i - 2, i);
            //位于0~25之间的数即为符合匹配规则的数！！！！
            int n = Integer.parseInt(substring);
            int c = n > 9 && n < 26 ? a + b : a;
            //更新
            b = a;
            a = c;
        }
        return a;
    }

    /**
     * 动态规划1-又慢又大
     */
    public int translateNum(int num) {
        //只有一位数字的时候，直接返回1
        if ((num + "").length() == 1) {
            return 1;
        }

        //利用map集合判断是否符合匹配规则
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = 'a'; i <= 25; i++, j++) {
            map.put(i, j);
        }
        //System.out.println(map);
        //转成字符串
        String s = num + "";
        //动态规划数组
        int[] dp = new int[s.length()];
        dp[0] = 1;
        if (map.containsKey(Integer.parseInt(s.substring(0, 2)))) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < dp.length; i++) {
            String newS = s.charAt(i - 1) + "" + s.charAt(i);
            //要判断的数字必须>9,即不能是06这种情况的
            int n = Integer.parseInt(newS);
            if (n > 9 && map.containsKey(n)) {
                dp[i] = dp[i - 1] + dp[i - 2];//！！！！！！！！！！！！！！！！！！！！！！
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[dp.length - 1];
    }


}



























