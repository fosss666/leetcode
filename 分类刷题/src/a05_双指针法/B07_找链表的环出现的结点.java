package a05_双指针法;

/**
 * @author: fosss
 * Date: 2023/7/30
 * Time: 14:21
 * Description:
 * leetcode位置：https://leetcode.cn/problems/linked-list-cycle-ii/
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 */
public class B07_找链表的环出现的结点 {

    /**
     * fast每次走两步，slow每次走一步
     * 第一次相遇后fast重新设置为头结点，再同时一步一步走，第二次相遇的位置即为环的起始点
     * 具体原因看
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                //说明没有环
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
