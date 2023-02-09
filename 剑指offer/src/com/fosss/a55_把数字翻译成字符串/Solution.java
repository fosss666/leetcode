package com.fosss.a55_把数字翻译成字符串;

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
        int res = solution.translateNum(12258);
        System.out.println("res = " + res);
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



























