package a02_链表;

/**
 * @author: fosss
 * Date: 2023/7/21
 * Time: 11:28
 * Description:
 * 题意：删除链表中等于给定值 val 的所有节点。
 * 示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
 * 示例 2： 输入：head = [], val = 1 输出：[]
 * 示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]
 */
public class B01_移除链表元素 {

    /**
     * 不带虚拟头结点
     */
    public ListNode f1(ListNode head, int val) {

        //头结点值==val
        while (head != null && head.val == val) {
            head = head.next;
        }

        //普通结点
        ListNode temp = head;
        while (temp != null) {
            if (temp.next != null && temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }

        }
        return head;
    }

    /**
     * 带虚拟头结点
     */
    public ListNode f2(ListNode head, int val) {

        ListNode pre = new ListNode(-1);
        pre.next = head;

        //普通结点
        ListNode temp = pre;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }

        }
        return pre.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}