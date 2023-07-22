package a02_链表;

/**
 * @author: fosss
 * Date: 2023/7/22
 * Time: 19:19
 * Description:
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 例：输入：head = [1,2,3,4] 输出：[2,1,4,3]
 */
public class B04_两两交换链表中的节点 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        f1(node1);
    }

    /**
     * 虚拟头结点   一定要画图模拟!!!!
     */
    public static ListNode f1(ListNode head) {

        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode temp = newHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode t = temp.next.next;
            temp.next.next = temp.next.next.next;
            t.next = temp.next;
            temp.next = t;
            //更新temp
            temp = temp.next.next;


            //ListNode t1 = temp.next.next;
            //ListNode t2 = temp.next.next.next;
            //temp.next.next = t2;
            //t1.next = temp.next;
            //temp.next = t1;
            ////更新temp
            //temp = temp.next.next;
        }
        return newHead.next;
    }
}














