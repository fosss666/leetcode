package com.fosss.a22_链表中倒数第k个节点;

/**
 * @author fosss
 * @date 2023/1/16
 * @description： 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有 6 个节点，从
 * 头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点
 * 例：给定一个链表: 1->2->3->4->5, 和 k = 2.   返回链表 4->5.
 */
public class Solution {

    /**
     * 自解
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        //得到链表的长度
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        //将head向后移动 (length-k) 位
        for (int i = 0; i < (length - k); i++) {
            head = head.next;
        }
        return head;
    }
}






















