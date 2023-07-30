package a05_双指针法;


/**
 * @author: fosss
 * Date: 2023/7/30
 * Time: 13:42
 * Description:
 * 题意：反转一个单链表。
 * 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 */
public class B04_反转链表 {

    /**
     * 前驱指针和当前指针
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;

            //更新 pre 和 cur
            pre = cur;
            cur = temp;
        }
        return pre;
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










