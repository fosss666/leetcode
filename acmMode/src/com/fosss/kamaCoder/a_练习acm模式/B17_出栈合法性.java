package com.fosss.kamaCoder.a_练习acm模式;

import java.util.*;

/**
 * 题目描述：
 * 已知自然数1，2，...，N（1<=N<=100）依次入栈，请问序列C1，C2，...，CN是否为合法的出栈序列。
 * <p>
 * 输入：输入包含多组测试数据。每组测试数据的第一行为整数N（1<=N<=100），当N=0时，输入结束。第二行为N个正整数，以空格隔开，为出栈序列。
 * <p>
 * 输出：对于每组输入，输出结果为一行字符串。如给出的序列是合法的出栈序列，则输出Yes，否则输出No。
 * <p>
 * 样例输入：
 * 5
 * 3 4 2 1 5
 * 5
 * 3 5 1 4 2
 * 0
 * 样例输出：
 * Yes
 * No
 */
public class B17_出栈合法性 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        while (sc.hasNext()) {
            //获取数量N
            int N = Integer.valueOf(sc.nextLine());
            //退出条件
            if (N == 0) break;
            //获取下一行
            String line = sc.nextLine();
            //分割出数字
            String[] nums = line.split(" ");
            int index = 0;

            for (int i = 1; i <= N; i++) {
                stack.push(i);
                while (!stack.isEmpty() && stack.peek() == Integer.valueOf(nums[index])) {
                    stack.pop();
                    index++;
                }
            }

            if (stack.isEmpty()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        sc.close();
    }
}