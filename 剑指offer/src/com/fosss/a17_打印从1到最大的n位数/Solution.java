package com.fosss.a17_打印从1到最大的n位数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fosss
 * date 2023/1/12
 * description：
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999
 * 例：输入: n = 1  输出: [1,2,3,4,5,6,7,8,9]
 * 说明：用返回一个整数列表来代替打印
 * n 为正整数
 *
 * 思路：
 * 1.求10^n,然后用for循环给返回数组赋值
 * 2.字符串拼接，从一位数一直到n位数挨个拼接
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.printNumbers2(3);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 考虑大数问题！！！
     * 无论是 short / int / long ... 任意变量类型，数字的取值范围都是有限的。因此，大数的表示应用字符串 String 类型.
     */
    //定义全局集合储存所有的数
    List<String> list = new ArrayList<>();
    //定义用来拼接数字的字符串
    String s = "";
    //定义0~9这是个数字
    int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public int[] printNumbers2(int n) {
        //构造一位数，两位数，一直到n位数
        for (int i = 1; i <= n; i++) {
            dfs(0, i);
        }
        //将集合转为int数组
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = Integer.parseInt(list.get(i));
        }
        return arr;
    }

    private void dfs(int x, int len) {
        //每一次循环，都在对第x+1位进行拼接
        if (x == len) {
            //说明拼接完毕,存入集合
            list.add(s);
            //结束递归
            return;
        }
        //根据x是否为零判断最左边的位是不是0，是0的话应跳过这一位！！！！！！！
        int start = x == 0 ? 1 : 0;
        //x==0 -> start==1 -> i==1  ->跳过了nums[0](0)
        for (int i = start; i < 10; i++) {
            //拼接字符串
            s += nums[i];
            //拼接后进行递归
            dfs(x + 1, len);//x+1表示接下来拼接下一位（右边）
            //将s刚才添加的那一位删掉，以便继续表示后面的数（比如现在是10，为了表示11，则应该先把0删掉）
            s = s.substring(0, s.length() - 1);
        }
    }

    /**
     * 自解    75%  28%
     */
    public int[] printNumbers(int n) {
        if (n == 0) {
            return new int[0];
        }
        int s = (int) Math.pow(10.0, n);
        int[] arr = new int[s - 1];
        for (int i = 0; i < s - 1; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
}
















