package a05_双指针法;

/**
 * @author: fosss
 * Date: 2023/7/30
 * Time: 13:56
 * Description:
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 * 示例 1：
 * 19.删除链表的倒数第N个节点
 * 输入：head = [1,2,3,4,5], n = 2 输出：[1,2,3,5] 示例 2：
 * 输入：head = [1], n = 1 输出：[] 示例 3：
 * 输入：head = [1,2], n = 1 输出：[1]
 */
public class B05_删除链表倒数第N个结点 {

    /**
     * 可以画图模拟一下，使用虚拟头结点，设置两个指针，从虚拟头结点开始，快指针先走n步，然后快慢指针同时走，快指针为空时，慢指针此时指到的结点
     * 就是要删除的结点。因为要删除这个结点需要知道这个节点的上个结点，所以用fast.next进行判断
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode slow = pre;
        ListNode fast = pre;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //此时slow.next就是要删除的结点
        slow.next = slow.next.next;
        return pre.next;
    }
}

















