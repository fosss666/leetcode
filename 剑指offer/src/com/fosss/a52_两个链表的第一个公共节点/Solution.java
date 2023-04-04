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
 *
 * 思路：
 * 1.LinkedHashMap或LinkedHashSet ：遍历一个链表，将节点存入map或set中，遍历另一个链表，如果节点值重复则返回
 * 2.双指针：链表A的长度为a，链表B的长度为B，已知两个链表从某一节点开始重复（节点值相同），寻找第一个重复的节点，设重复的部分长度为c，则A中剩余(a-c)，B中剩余
 * (b-c) ,定义两个指针，一个指针遍历完A链表后再去遍历B链表，一个指针遍历完B后再去遍历A，这样第一个指针遍历的总节点数为 a+(b-c)，第二个指针遍历的总结点数为
 * b+(a-c)，即两指针遍历的总节点数相等。
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
























