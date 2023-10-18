package com.fosss.kamaCoder.a_练习acm模式;

import java.util.Scanner;

/**
 * 题目描述：
 * 小明很喜欢玩积木。一天，他把许多积木块组成了好多高度不同的堆，每一堆都是一个摞一个的形式。然而此时，他又想把这些积木堆变成高度相同的。
 * 但是他很懒，他想移动最少的积木块来实现这一目标，你能帮助他吗？
 * <p>
 * 输入： 输入包含多组测试样例。每组测试样例包含一个正整数n，表示小明已经堆好的积木堆的个数。
 * 接着下一行是n个正整数，表示每一个积木堆的高度h，每块积木高度为1。其中1<=n<=50,1<=h<=100。 测试数据保证积木总数能被积木堆数整除。
 * 当n=0时，输入结束。
 * <p>
 * 输出： 对于每一组数据，输出将积木堆变成相同高度需要移动的最少积木块的数量。在每组输出结果的下面都输出一个空行。
 * <p>
 * 样例输入：
 * 6
 * 5 2 4 1 7 5
 * 0
 * 样例输出： 5
 */
public class B08_摆平积木 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = sc.nextInt();
            if (n == 0) break;
            int[] arr = new int[n];
            int index = 0;
            int sum = 0;
            while (n-- > 0) {
                int num = sc.nextInt();
                sum += num;
                arr[index++] = num;
            }
            int avg = sum / arr.length;
            int count = 0;
            for (int num : arr) {
                count += Math.abs(num - avg);
            }
            System.out.println(count / 2);
            System.out.println();//注意题目要求输出结果后面输出一行空行
        }
        sc.close();
    }
}