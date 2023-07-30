package a05_双指针法;

/**
 * @author: fosss
 * Date: 2023/7/30
 * Time: 14:07
 * Description:
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null
 */
public class B06_链表相交 {

    /**
     * 双指针法
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }
}













