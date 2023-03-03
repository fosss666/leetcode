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
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.lastRemaining4(5, 3);
        System.out.println("res = " + res);
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
            s.append(s.substring(0, (m-1) % s.length()));
            s.delete(0,(m-1) % s.length());
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
     * 自解，List集合，超时-_-!
     */
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int i = 1;
        int index = 0;
        while (list.size() > 1) {
            if (index == list.size()) {
                index = 0;
            }
            if (i % m == 0) {
                //如果删除了元素，则下标不用增加，直接指向了下一个值
                list.remove(index);
                i = 0;
            } else {
                index++;
            }
            i++;

        }
        return list.get(0);
    }
}
























