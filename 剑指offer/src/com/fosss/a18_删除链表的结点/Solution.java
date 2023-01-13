package com.fosss.a18_删除链表的结点;

/**
 * @author fosss
 * date 2023/1/13
 * description：
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点.
 * 例：输入: head = [4,5,1,9], val = 5  输出: [4,1,9]
 * 说明：题目保证链表中节点的值互不相同
 */
public class Solution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Solution solution = new Solution();
        ListNode head = solution.deleteNode(node1, 1);
        //遍历
        ListNode t = head;
        while (t != null) {
            System.out.print(t.val + " ");
            t = t.next;
        }
    }

    /**
     * 自解
     */
    public ListNode deleteNode(ListNode head, int val) {
        //明确要想删除单链表的结点，需要找到要删除的结点的前一个结点
        //先判断头结点是不是要删除的结点
        if (head.val == val) {
            head = head.next;
            return head;
        }
        //头结点不是要删除的结点，则进行对下一个结点的判断
        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == val) {
                //进行删除操作
                //要判断node.next.next是否为空，即node.next是否为尾结点
                if (node.next.next == null) {
                    node.next = null;
                } else {
                    node.next = node.next.next;
                }
                break;
            }
            node = node.next;
        }
        return head;
    }
}





















