package com.fosss.kamaCoder.a_练习acm模式;

import java.util.*;

/**
 * 题目描述：
 * 输出一个词组中每个单词的首字母的大写组合。
 * <p>
 * 输入：输入的第一行是一个整数n，表示一共有n组测试数据。（输入只有一个n，没有多组n的输入）
 * 接下来有n行，每组测试数据占一行，每行有一个词组，每个词组由一个或多个单词组成；每组的单词个数不超过10个，每个单词有一个或多个大写或小写字母组成；
 * 单词长度不超过10，由一个或多个空格分隔这些单词。
 * <p>
 * 输出： 请为每组测试数据输出规定的缩写，每组输出占一行。
 * <p>
 * 样例输入：
 * 1
 * ad dfa     fgs
 * 样例输出：
 * ADF
 */
public class B14_句子缩写 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            //注意：接受完n后，应该在下一行再去接受数据，所以要换行
            //next()：将空格和换行符都看作分割
            //nextLine():只将换行符看作分割，所以要另起一行的话，要调用nextLine()方法
            sc.nextLine();
            while (n-- > 0) {
                String line = sc.nextLine();
                String[] arr = line.split(" ");
                List<Character> list = new ArrayList<>();
                for (String s : arr) {
                    if (s.length() == 0) continue;
                    list.add(s.toUpperCase().charAt(0));
                }
                for (int i = 0; i < list.size(); i++) System.out.print(list.get(i));
                //每组输出要换行
                System.out.println();
            }
        }
        sc.close();
    }
}