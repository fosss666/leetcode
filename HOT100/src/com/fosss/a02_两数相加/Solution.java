package com.fosss.a02_两数相加;

/**
 * @author: fosss
 * Date: 2023/4/22
 * Time: 21:38
 * Description:给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class Solution {

    /**
     * 遍历，记录进位   100%  23%
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //头节点的前一位
        ListNode pre = new ListNode(0);
        //辅助节点
        ListNode cur = pre;
        //表示进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;//和要加上上一位的进位
            carry = sum / 10;//获取进位
            sum = sum % 10;//获取一位
            cur.next = new ListNode(sum);

            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        //判断最高位是否有进位
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }

        return pre.next;
    }
}












