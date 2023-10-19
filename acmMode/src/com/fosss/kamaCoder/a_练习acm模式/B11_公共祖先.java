package com.fosss.kamaCoder.a_练习acm模式;

import java.util.*;

/**
 * 题目描述：
 * 小明发现和小宇有共同祖先！现在小明想知道小宇是他的长辈，晚辈，还是兄弟。
 * <p>
 * 输入：输入包含多组测试数据。每组首先输入一个整数N（N<=10），接下来N行，每行输入两个整数a和b，表示a的父亲是b（1<=a,b<=20）。小明的编号为1，小宇的编号为2。
 * 输入数据保证每个人只有一个父亲。
 * <p>
 * 输出： 对于每组输入，如果小宇是小明的晚辈，则输出“You are my younger”，如果小宇是小明的长辈，则输出“You are my elder”，如果是同辈则输出“You are my brother”。
 * <p>
 * 样例输入：
 * 5
 * 1 3
 * 2 4
 * 3 5
 * 4 6
 * 5 6
 * 6
 * 1 3
 * 2 4
 * 3 5
 * 4 6
 * 5 7
 * 6 7
 * 样例输出：
 * You are my elder
 * You are my brother
 */
public class B11_公共祖先 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        while (sc.hasNext()) {
            int N = sc.nextInt();

            for (int i = 0; i < N; i++) {
                map.put(sc.nextInt(), sc.nextInt());
            }
            int xiaoming = 1, xiaoyu = 2;

            //记录小明和小宇长辈数
            int count1 = 0, count2 = 0;
            while (map.containsKey(xiaoming)) {
                xiaoming = map.get(xiaoming);
                count1++;
            }
            while (map.containsKey(xiaoyu)) {
                xiaoyu = map.get(xiaoyu);
                count2++;
            }

            if (count1 < count2) {
                System.out.println("You are my younger");
            } else if (count1 == count2) {
                System.out.println("You are my brother");
            } else {
                System.out.println("You are my elder");
            }
        }
        sc.close();
    }
}
