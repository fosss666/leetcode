package a02_链表;

/**
 * @author: fosss
 * Date: 2023/7/22
 * Time: 17:22
 * Description:
 * 题意：反转一个单链表。
 * 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 */
public class B03_翻转链表 {

    /**
     * 虚拟头指针+头插法
     */
    public ListNode f1(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = temp;
        }
        return newHead.next;
    }

    /**
     * 前后指针，改变链表中结点的指向
     */
    public ListNode f2(ListNode head) {
        //一个前指针，一个当前指针
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * f3 栈   略
     * f4 递归
     */
    public ListNode f3(ListNode head) {
        //参照双指针法写
        return reverse(null, head);
    }

    private ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }

        ListNode temp = cur.next;
        cur.next = pre;
        pre = cur;
        cur = temp;
        return reverse(pre, cur);
    }
}














