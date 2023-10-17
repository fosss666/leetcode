package com.fosss.kamaCoder.a_练习acm模式;

import java.util.Scanner;

/**
 * 题目描述：
 * 每门课的成绩分为A、B、C、D、F五个等级，为了计算平均绩点，规定A、B、C、D、F分别代表4分、3分、2分、1分、0分。
 * <p>
 * 输入：
 * 有多组测试样例。每组输入数据占一行，由一个或多个大写字母组成，字母之间由空格分隔。
 * <p>
 * 输出：
 * 每组输出结果占一行。如果输入的大写字母都在集合｛A,B,C,D,F｝中，则输出对应的平均绩点，结果保留两位小数。否则，输出“Unknown”。
 * <p>
 * 样例输入：
 * A B C D F
 * B F F C C A
 * D C E F
 * <p>
 * 样例输出：
 * 2.00
 * 1.83
 * Unknown
 */
public class B07_平均绩点 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int sum = 0;
            int count = 0;

            String line = sc.nextLine();
            String[] cs = line.split(" ");
            for (String c : cs) {
                int num = getNum(c);
                if (num == -1) {
                    System.out.println("Unknown");
                    count = -1;//标记一下
                    break;//退出循环！
                } else {
                    sum += num;
                    count++;
                }
            }
            //别忘了换行，和将商转成小数
            if (count != -1) System.out.printf("%.2f\n", sum * 1.0 / count);
        }
    }

    private static int getNum(String c) {
        switch (c) {
            case "A":
                return 4;
            case "B":
                return 3;
            case "C":
                return 2;
            case "D":
                return 1;
            case "F":
                return 0;
            default:
                return -1;
        }
    }
}