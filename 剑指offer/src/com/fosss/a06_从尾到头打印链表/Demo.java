package com.fosss.a06_从尾到头打印链表;

import java.util.*;

/**
 * @author fosss
 * date 2023/1/4
 * description：
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 例：输入：head = [1,3,2]
 *    输出：[2,3,1]
 * 限制： 0 <= 链表长度 <= 10000
 */
public class Demo {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3=new ListNode(2);
        head.next=node2;
        node2.next=node3;

        Demo demo = new Demo();
        //int[] ints = demo.reversePrint(head);
        //int[] ints = demo.reversePrint2(head);
        int[] ints = demo.reversePrint3(head);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 辅助栈
     */
    public int[] reversePrint3(ListNode head){
        LinkedList<Integer> stack=new LinkedList<>();
        while (head!=null){
            stack.addFirst(head.val);
            head=head.next;
        }
        int[] arr=new int[stack.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=stack.get(i);
        }
        return arr;
    }

    /**
     * 利用栈
     */
    public int[] reversePrint2(ListNode head){
        Stack<Integer> stack=new Stack<>();
        while (head!=null){
            stack.push(head.val);
            head=head.next;
        }
        int[] arr=new int[stack.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=stack.pop();
        }
        return arr;
    }

    /**
     * 自解-利用List集合
     */
    public int[] reversePrint(ListNode head) {
        List<Integer> list=new ArrayList<>();
        while (head!= null) {
            list.add(head.val);
            head=head.next;
        }
        int[] arr=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i]=list.get(list.size()-i-1);
        }
        return arr;
    }
}
























