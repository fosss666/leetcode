package com.fosss.a62_圆圈中最后剩下的数字;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/3/3
 * Time: 9:59
 * Description: 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩
 * 下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3
 * 限制：1 <= n <= 10^5  1 <= m <= 10^6
 * <p>
 * 思路：
 * 1.利用求模运算
 * 2.动态规划,求最终存下来的那个元素在最初所有元素中的下标,由题意下标和元素值是相等的,所以最后返回dp[n]即可,dp[i]表示存活的元素在有i个数字时的下标,比如1个
 * 元素时为0, (dp[i]+m)%i。可用一个变量代替dp数组来优化空间。
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.lastRemaining(5, 3);
        System.out.println("res = " + res);
    }

    /**
     * 数学解法  动态规划思想
     * https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
     * (当前index + m) % 上一轮剩余数字的个数
     * 最后只剩下一个元素，假设这个最后存活的元素为 num, 这个元素最终的的下标一定是0 （因为最后只剩这一个元素），
     * 所以如果我们可以推出上一轮次中这个num的下标，然后根据上一轮num的下标推断出上上一轮num的下标，
     * 直到推断出元素个数为n的那一轮num的下标，那我们就可以根据这个下标获取到最终的元素了。推断过程如下：
     * <p>
     * 首先最后一轮中num的下标一定是0， 这个是已知的。
     * 那上一轮应该是有两个元素，此轮次中 num 的下标为 (0 + m)%n = (0+3)%2 = 1; 说明这一轮删除之前num的下标为1；
     * 再上一轮应该有3个元素，此轮次中 num 的下标为 (1+3)%3 = 1；说明这一轮某元素被删除之前num的下标为1；
     * 再上一轮应该有4个元素，此轮次中 num 的下标为 (1+3)%4 = 0；说明这一轮某元素被删除之前num的下标为0；
     * 再上一轮应该有5个元素，此轮次中 num 的下标为 (0+3)%5 = 3；说明这一轮某元素被删除之前num的下标为3；
     * ....
     * <p>
     * 因为我们要删除的序列为0-n-1, 所以求得下标其实就是求得了最终的结果。比如当n为5的时候，num的初始下标为3，
     * 所以num就是3，也就是说从0-n-1的序列中， 经过n-1轮的淘汰，3这个元素最终存活下来了，也是最终的结果。
     * <p>
     * 总结一下推导公式：(此轮过后的num下标 + m) % 上轮元素个数 = 上轮num的下标
     */
    public int lastRemaining3(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }

    /**
     * 自解，字符串拼接   超时-_-!
     */
    public int lastRemaining4(int n, int m) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append(i);
        }
        while (s.length() > 1) {
            s.deleteCharAt((m - 1) % s.length());
            s.append(s.substring(0, (m - 1) % s.length()));
            s.delete(0, (m - 1) % s.length());
        }
        return Integer.parseInt(s.toString());
    }

    /**
     * 优化List    5%   12%
     */
    public int lastRemaining2(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        //n表示集合元素的个数
        while (n > 1) {
            //更新要删除的元素的下标(index+m-1)，%n是因为index+m-1可能大于n
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

    /**
     * 自解，List集合
     */
    public int lastRemaining(int n, int m) {
        /**
         *  5%  21%
         */
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
            //防止删除的是最后一个元素
        }
        return list.get(0);

        /**
         * 超时-_-!
         */
        //List<Integer> list = new ArrayList<>();
        //for (int i = 0; i < n; i++) {
        //    list.add(i);
        //}
        //int i = 1;
        //int index = 0;
        //while (list.size() > 1) {
        //    if (index == list.size()) {
        //        index = 0;
        //    }
        //    if (i % m == 0) {
        //        //如果删除了元素，则下标不用增加，直接指向了下一个值
        //        list.remove(index);
        //        i = 0;
        //    } else {
        //        index++;
        //    }
        //    i++;
        //
        //}
        //return list.get(0);
    }
}
























