package com.fosss.a24_反转链表;

import java.util.Stack;

/**
 * @author fosss
 * @date 2023/1/17
 * @description： 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 例：输入: 1->2->3->4->5->NULL  输出: 5->4->3->2->1->NULL
 * <p>
 * 思路：
 * 1.利用栈先进后出的特性重新组装一条链表，注意最后一个结点需要指向null，避免循环链表问题
 * 2.遍历链表，用头插法向新链表中插入数据，注意创建新链表的结点时应该new ListNode,不要直接引用原链表结点
 * 3.改变指针指向，定义两个结点，一个表示前一个结点pre=null,一个表示当前结点cur=head, 遍历链表，ListNode temp=cur.next;cur.next=pre;
 * pre=cur;cur=temp;
 */
public class Solution {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution solution = new Solution();
        ListNode newHead = solution.reverseList3(node);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }

    }

    /**
     * 改变指针指向
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null, cur = head;
        while (cur.next != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        //cur.next==null,pre指向倒数第二个结点，让cur.next指向pre
        cur.next = pre;
        return cur;

        /*if (head == null) {
            return null;
        }
        ListNode left=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode right=cur.next;
            cur.next=left;
            left=cur;
            cur=right;
        }
        return left;*/
    }

    /**
     * 自解，头插法
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode(head.val);
        while (head.next != null) {
            head = head.next;
            //进行头插
            ListNode temp = new ListNode(head.val);
            temp.next = newHead;
            newHead = temp;
        }
        return newHead;
    }

    /**
     * 自解，使用栈
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ListNode newHead = new ListNode(stack.pop());
        ListNode t = newHead;
        while (!stack.isEmpty()) {
            ListNode temp = new ListNode(stack.pop());
            t.next = temp;
            t = t.next;
        }
        return newHead;
    }
}



















