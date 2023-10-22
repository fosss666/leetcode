package com.fosss.kamaCoder.a_练习acm模式;

import java.util.*;

/**
 * 题目描述：
 * 根据一个整数序列构造一个单链表，然后将其反转。例如：原单链表为 2 3 4 5 ，反转之后为5 4 3 2
 * <p>
 * 输入：输入包括多组测试数据，每组测试数据占一行，第一个为大于等于0的整数n，表示该单链表的长度，后面跟着n个整数，表示链表的每一个元素。整数之间用空格隔开
 * <p>
 * 输出：针对每组测试数据，输出包括两行，分别是反转前和反转后的链表元素，用空格隔开。如果链表为空，则只输出一行，list is empty
 * <p>
 * 样例输入：
 * 5 1 2 3 4 5
 * 0
 * 样例输出：
 * 1 2 3 4 5
 * 5 4 3 2 1
 * list is empty
 * 提示：本题用数组，也是可有过的，输入一遍数组，然后倒叙输出。不过建议大家用本题来链表操作
 */
public class B19_单链表反转 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            ListNode head = new ListNode();
            int n = sc.nextInt();
            if (n == 0) {
                System.out.println("list is empty");
                continue;
            }
            while (n-- > 0) {
                int val = sc.nextInt();
                head.insert(val);
            }
            head.show();
            head.reverse();
        }
        sc.close();
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

class ListNode {
    Node head;

    public ListNode() {
        this.head = new Node(-1);
    }

    //尾插法
    public void insert(int val) {
        Node tmp = head;
        while (tmp.next != null) tmp = tmp.next;
        tmp.next = new Node(val);
    }

    //打印链表
    public void show() {
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            System.out.print(tmp.val + " ");
        }
        System.out.println();
    }

    //将链表反转
    public void reverse() {
        Node pre = null;
        Node cur = head.next;
        while (cur != null) {
            Node tmp = cur.next;
            cur.next = pre;//倒转指针方向
            pre = cur;
            cur = tmp;
        }
        head.next = pre;
        this.show();
    }
}