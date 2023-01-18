package com.fosss.a25_合并两个排序的链表;

/**
 * @author fosss
 * @date 2023/1/18
 * @description： 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的
 * 例：输入：1->2->4, 1->3->4  输出：1->1->2->3->4->4
 */
public class Solution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;

        ListNode node11 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node33 = new ListNode(4);
        node11.next = node22;
        node22.next = node33;

        Solution solution = new Solution();
        ListNode newHead = solution.mergeTwoLists3(node1, node11);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

    /**
     * 自解，逐个插入，优化版，从上一个插入的地方作为链表起始地方进行遍历插入，速度并没有显著提高，舍弃舍弃
     */
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode newHead=l1;
        //遍历一个链表，将其结点的数值插入到另一个链表中
        while (l2 != null) {
            newHead = insertVal2(newHead, l2.val);
            l2 = l2.next;
        }
        return newHead;
    }

    //插入结点的位置
    public static ListNode insertNode = null;
    //向链表中插入数值
    private ListNode insertVal2(ListNode head, int val) {
        if (head.val >= val) {
            ListNode listNode = new ListNode(val);
            listNode.next = head;
            return listNode;
        }
        ListNode temp = null;
        if (insertNode != null) {
            temp = insertNode;
        } else {
            temp = head;
        }
        while (temp.next != null) {
            if (temp.next.val >= val) {
                ListNode listNode = new ListNode(val);
                listNode.next = temp.next;
                temp.next = listNode;
                //插入完毕，返回插入结点的位置
                return head;
            }
            temp = temp.next;
        }
        //走到这一步，说明要插入的值比链表中所有节点的值都要大
        temp.next = new ListNode(val);
        return head;
    }

    /**
     * 自解，逐个插入（太慢了，舍弃舍弃）
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        //遍历一个链表，将其结点的数值插入到另一个链表中
        ListNode newHead = l1;
        while (l2 != null) {
            newHead = insertVal(newHead, l2.val);
            l2 = l2.next;
        }
        return newHead;
    }

    //向链表中插入数值
    private ListNode insertVal(ListNode head, int val) {
        if (head.val >= val) {
            ListNode listNode = new ListNode(val);
            listNode.next = head;
            return listNode;
        }
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.val >= val) {
                ListNode listNode = new ListNode(val);
                listNode.next = temp.next;
                temp.next = listNode;
                //插入完毕，返回链表头
                return head;
            }
            temp = temp.next;
        }
        //走到这一步，说明要插入的值比链表中所有节点的值都要大
        temp.next = new ListNode(val);
        return head;
    }

    /**
     * 自解，借用第三个链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        int l1Val = l1.val;
        int l2Val = l2.val;
        ListNode head = null;
        if (l1Val > l2Val) {
            head = new ListNode(l2Val);
            l2 = l2.next;
        } else {
            head = new ListNode(l1Val);
            l1 = l1.next;
        }
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            temp = temp.next;
        }
        while (l1 != null) {
            //则应该将l1剩余的值放到新链表的后面
            temp.next = new ListNode(l1.val);
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            //则应该将l2剩余的值放到新链表的后面
            temp.next = new ListNode(l2.val);
            temp = temp.next;
            l2 = l2.next;
        }
        return head;
    }
}













