package com.fosss.kamaCoder.a_练习acm模式;

import java.util.*;

/**
 * 题目描述：
 * 把一个字符三角形掏空，就能节省材料成本，减轻重量，但关键是为了追求另一种视觉效果。在设计的过程中，需要给出各种花纹的材料和大小尺寸的三角形样板，通过电脑临时做出来，以便看看效果。
 *
 * 输入：每行包含一个字符和一个整数n(0<n<41)，不同的字符表示不同的花纹，整数n表示等腰三角形的高。显然其底边长为2n-1。如果遇到@字符，则表示所做出来的样板三角形已经够了。
 *
 * 输出： 每个样板三角形之间应空上一行，三角形的中间为空。行末没有多余的空格。每条结果后需要再多输出一个空行。
 *
 * 样例输入：
 * X 2
 * A 7
 * @
 * 样例输出：
 *  X
 * XXX
 *
 *       A
 *      A A
 *     A   A
 *    A     A
 *   A       A
 *  A         A
 * AAAAAAAAAAAAA
 *
 */
public class B13_镂空三角形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String c = sc.next();
            if ("@".equals(c)) break;
            int n = sc.nextInt();
            //第一行单独处理
            //空格
            for (int i = 1; i <= n - 1; i++) System.out.print(" ");
            //字符
            System.out.println(c);

            //中间部分
            for (int i = 2; i < n; i++) {
                //空格
                for (int j = 1; j <= n - i; j++) System.out.print(" ");
                //字符
                System.out.print(c);
                //空格
                for (int j = 1; j <= (2 * i - 3); j++) System.out.print(" ");
                //字符
                System.out.print(c);
                //换行
                System.out.println();
            }
            //处理最后一行，如果有的话
            if (n > 1) {
                for (int i = 1; i <= 2 * n - 1; i++) System.out.print(c);
                //换行，防止影响下组数据的输出
                System.out.println();
            }
            //每个样板三角形之间应空上一行，所以给个空行
            System.out.println();
        }
        sc.close();
    }
}