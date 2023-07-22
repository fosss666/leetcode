package a02_链表;

/**
 * @author: fosss
 * Date: 2023/7/22
 * Time: 20:32
 * Description:
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class B05_删除链表倒数第n个结点 {

    /**
     * 快慢指针法 O(n)
     * 快指针先走n步，然后快慢指针同时走，知道快指针的next为null，此时慢指针的next为要删除的结点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h = new ListNode(-1);
        h.next = head;

        ListNode fast = h;
        ListNode slow = h;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return h.next;
    }
}
