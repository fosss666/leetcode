package com.fosss.kamaCoder.a_练习acm模式;

import java.util.*;

/**
 * 题目描述：
 * 根据一个递增的整数序列构造有序单链表，删除其中的重复元素
 * <p>
 * 输入：输入包括多组测试数据，每组测试数据占一行，第一个为大于等于0的整数n，表示该单链表的长度，后面跟着n个整数，表示链表的每一个元素。整数之间用空格隔开
 * <p>
 * 输出：针对每组测试数据，输出包括两行，分别是删除前和删除后的链表元素，用空格隔开，如果链表为空，则只输出一行，list is empty
 * <p>
 * 样例输入：
 * 5 1 2 3 4 5
 * 5 1 1 2 2 3
 * 0
 * 样例输出：
 * 1 2 3 4 5
 * 1 2 3 4 5
 * 1 1 2 2 3
 * 1 2 3
 * list is empty
 */
public class B20_删除重复元素 {

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
            //输出原链表
            head.show();
            //去重
            head.distinct();
            //输出现链表
            head.show();

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
    Node tail;

    public ListNode() {
        this.head = new Node(-1);
        this.tail = this.head.next;
    }

    //尾插法
    public void insert(int val) {
        if (this.tail == null) {
            this.head.next = new Node(val);
            this.tail = this.head.next;
        } else {
            this.tail.next = new Node(val);
            this.tail = this.tail.next;
        }
    }

    //打印链表
    public void show() {
        Node tmp = head.next;
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    //去重
    public void distinct() {
        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (pre.val == cur.val) {
                //需要去重
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = pre.next;
                cur = pre.next;
            }
        }
    }
}