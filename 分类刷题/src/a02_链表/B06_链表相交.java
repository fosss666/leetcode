package a02_链表;

/**
 * @author: fosss
 * Date: 2023/7/22
 * Time: 20:35
 * Description:
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null
 */
public class B06_链表相交 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //设相交长度为k,headA总长度为A，独立结点数为a，headB总长度为B，独立结点数为b，则
        //A=k+a B=k+b   因为k+a+b =k+b+a  所以headA和headB同时出发，headA走完接着从headB走，headB走完接着从headA
        //走，比较两个同时出发的点，当结点相等时，就是相交的那个结点
        ListNode aNode = headA;
        ListNode bNode = headB;
        while (aNode != bNode) {
            aNode = aNode == null ? headB : aNode.next;
            bNode = bNode == null ? headA : bNode.next;
        }

        /*
        while (aNode != bNode) {
            //处理一条链表走完接着从另一条链表头部开始走这个逻辑
            //如果aNode和bNode同时为空，则说明两个链表没有交点
            if (aNode == null) {
                aNode = headB;
            } else {
                aNode = aNode.next;
            }
            if (bNode == null) {
                bNode = headA;
            } else {
                bNode = bNode.next;
            }
        }
        */

        return aNode;
    }
}
