package com.fosss.a15_二进制中1的个数;

import java.util.Scanner;

/**
 * @author fosss
 * date 2023/1/10
 * description：
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）
 * 例：输入：n = 11 (控制台输入 00000000000000000000000000001011)
 * 输出：3
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.hammingWeight(11);
        System.out.println("result = " + result);
    }

    /**
     * 移位
     */
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            //进行无符号右移
            n = n >>> 1;
        }
        return count;
    }
}
