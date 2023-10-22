package com.fosss.kamaCoder.a_练习acm模式;

import java.util.*;

/**
 * 题目描述：
 * 本题考察链表的基本操作。温馨提示：本题较为复杂，需要细心多花一些时间。
 * <p>
 * 输入：
 * 输入数据只有一组，第一行有n+1个整数，第一个整数是这行余下的整数数目n，后面是n个整数。
 * 这一行整数是用来初始化列表的，并且输入的顺序与列表中的顺序相反，也就是说如果列表中是1、2、3那么输入的顺序是3、2、1。
 * 第二行有一个整数m，代表下面还有m行。每行有一个字符串，字符串是“get”，“insert”，“delete”，“show”中的一种。
 * 如果是“get”，代表获得第a个元素。（a从1开始计数）
 * 如果是“delete”，代表删除第a个元素。（a从1开始计数）
 * 如果是“insert”，则其后跟着两个整数a和e，代表在第a个位置前面插入e。（a从1开始计数）
 * “show”之后没有正数，直接打印链表全部内容。
 * <p>
 * 输出：
 * 如果获取成功，则输出该元素；
 * 如果删除成功，则输出“delete OK”；
 * 如果获取失败，则输出“get fail”
 * 如果删除失败，则输出“delete fail”
 * 如果插入成功，则输出“insert OK”，否则输出“insert fail”。
 * 如果是“show”，则输出列表中的所有元素，如果列表是空的，则输出“Link list is empty”
 * 注：所有的双引号均不输出。
 * <p>
 * 样例输入：
 * 3 3 2 1
 * 21
 * show
 * delete 1
 * show
 * delete 2
 * show
 * delete 1
 * show
 * delete 2
 * insert 2 5
 * show
 * insert 1 5
 * show
 * insert 1 7
 * show
 * insert 2 5
 * show
 * insert 3 6
 * show
 * insert 1 8
 * show
 * get 2
 * 样例输出：
 * 1 2 3
 * delete OK
 * 2 3
 * delete OK
 * 2
 * delete OK
 * Link list is empty
 * delete fail
 * insert fail
 * Link list is empty
 * insert OK
 * 5
 * insert OK
 * 7 5
 * insert OK
 * 7 5 5
 * insert OK
 * 7 5 6 5
 * insert OK
 * 8 7 5 6 5
 * 7
 * 提示：初始化链表的元素是倒序的，这个使用题目中创建列表的方法（从头部插入）就可以了。
 */
public class B18_链表的基本操作 {
    //节点
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    //链表
    static class ListNode {
        Node head;

        public ListNode() {
            this.head = new Node(-1);
        }

        //判断链表是否为空
        public boolean isNull(Node head) {
            return head.next == null;
        }

        //获取第a个节点的值
        public int get(int a) {
            Node tmp = head;
            while (a-- > 0) {
                tmp = tmp.next;
                if (tmp == null) return -1;//没找到
            }
            return tmp.val;
        }

        //删除第a个节点的值，返回是否删除成功
        public boolean delete(int a) {
            Node tmp = head;
            //需要找到第a个节点左边的节点
            while (a-- > 1) {
                tmp = tmp.next;
                if (tmp == null) return false;//没找到
            }
            tmp.next = tmp.next.next;
            return true;
        }

        //向第a个节点左边插入值e
        public boolean insert(int a, int e) {
            Node tmp = head;
            //需要找到左边的节点
            while (a-- > 1) {
                tmp = tmp.next;
                if (tmp == null) return false;
            }
            Node node = new Node(e);
            node.next = tmp.next;
            tmp.next = node;
            return true;
        }

        //打印链表
        public void show() {
            if (head.next == null) {
                System.out.println("Link list is empty");
                return;
            }
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
                System.out.print(tmp.val + " ");
            }
            //换行
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head = new ListNode();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                head.insert(1, num);
            }

            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                String s = sc.next();
                int a;
                switch (s) {
                    case "get":
                        a = sc.nextInt();
                        int val = head.get(a);
                        if (val == -1) {
                            System.out.println("get fail");
                        } else {
                            System.out.println(val);
                        }
                        break;
                    case "delete":
                        a = sc.nextInt();
                        if (head.delete(a)) {
                            System.out.println("delete OK");
                        } else {
                            System.out.println("delete fail");
                        }
                        break;
                    case "insert":
                        a = sc.nextInt();
                        int e = sc.nextInt();
                        if (head.insert(a, e)) {
                            System.out.println("insert OK");
                        } else {
                            System.out.println("insert fail");
                        }

                        break;
                    case "show":
                        head.show();
                        break;
                }
            }
        }
    }
}