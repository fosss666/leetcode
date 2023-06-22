package com.fosss.a05_recursion;

/**
 * @author: fosss
 * Date: 2023/6/22
 * Time: 19:20
 * Description:汉诺塔问题
 */
public class B01_hanoi {

    public static void main(String[] args) {
        hanoi(3, 'A', 'B', 'C');
    }

    public static void hanoi(int n, char a, char b, char c) {
        if (n == 0) {
            return;
        }
        //1.将n-1个从a经c移动到b
        hanoi(n - 1, a, c, b);
        //2.将剩下的1个从a移动到c
        move(a, c);
        //将n-1个从b经a移动到c
        hanoi(n - 1, b, a, c);
    }

    /**
     * 模拟移动
     */
    private static void move(char x, char y) {
        System.out.println(x + "->" + y);
    }
}
