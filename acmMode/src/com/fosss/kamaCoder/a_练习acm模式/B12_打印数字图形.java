package com.fosss.kamaCoder.a_练习acm模式;

import java.util.*;

/**
 * 题目描述：
 * 先要求你从键盘输入一个整数n（1<=n<=9），打印出指定的数字图形。
 *
 * 输入：输入包含多组测试数据。每组输入一个整数n（1<=n<=9）。
 *
 * 输出： 对于每组输入，输出指定的数字图形。注意：每行最后一个数字后没有任何字符。
 *
 * 样例输入：
 * 5
 * 样例输出：
 *     1
 *    121
 *   12321
 *  1234321
 * 123454321
 *  1234321
 *   12321
 *    121
 *     1
 *
 */
public class B12_打印数字图形 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()) {
			int n=sc.nextInt();
			//共2n-1行，对第i行，每行有2*i+1个数字
			//从上到下前半部分
			for(int i=1;i<=n;i++) {
				//先输出n-i个空格，再输出数字
				for(int j=1;j<=n-i;j++) {
					System.out.print(" ");
				}
				//前半段
				for(int j=1;j<=i;j++) {
					System.out.print(j);
				}
				//后半段
				for(int j=i-1;j>=1;j--) {
					System.out.print(j);
				}
				//换行
				System.out.println();
			}
			//后半部分
			for(int i=n-1;i>=1;i--) {
				//先输出n-i个空格，再输出数字
				for(int j=1;j<=n-i;j++) {
					System.out.print(" ");
				}
				//前半段
				for(int j=1;j<=i;j++) {
					System.out.print(j);
				}
				//后半段
				for(int j=i-1;j>=1;j--) {
					System.out.print(j);
				}
				//换行
				System.out.println();
			}
		}
		sc.close();
	}
}