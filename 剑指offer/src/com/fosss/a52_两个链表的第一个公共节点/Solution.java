package com.fosss.a52_两个链表的第一个公共节点;

import java.util.*;

/**
 * @author fosss
 * @date 2023/2/18
 * @description： 输入两个链表，找出它们的第一个公共节点
 * 例：listA = [0,9,1,2,4], listB = [3,2,4]  输出2
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存
 */
public class Solution {

    /**
     * 双指针，浪漫相遇
     * https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/jian-zhi-offer-52-liang-ge-lian-biao-de-gcruu/
     */
    ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode tA = headA;
        ListNode tB = headB;
        //双指针，一个指针遍历完A链表后再去遍历B链表，一个指针遍历完B后再去遍历A,当这两个指针所指向的结点相同时，即找到第一个共同节点
        while (tA != tB) {
            tA = tA == null ? headB : tA.next;
            tB = tB == null ? headA : tB.next;
        }
        return tA;
    }

    /**
     * 自解,LinkedHashMap  5.99% 5.06%
     */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> map = new LinkedHashMap<>();
        ListNode temp = headA;
        int i = 0;
        while (temp != null) {
            map.put(temp, i++);
            temp = temp.next;
        }
        temp = headB;
        int min = Integer.MAX_VALUE;
        while (temp != null) {
            if (map.containsKey(temp) && map.get(temp) < min) {
                min = map.get(temp);
            }
            temp = temp.next;
        }
        for (Map.Entry<ListNode, Integer> entry : map.entrySet()) {
            if (entry.getValue() == min) {
                return entry.getKey();
            }
        }

        return null;
    }
}
























