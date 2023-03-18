package com.fosss.a09_用两个栈实现队列;

import java.util.Stack;

/**
 * @author fosss
 * date 2023/1/6
 * description：
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead操作返回 -1 )
 * 例：  输入：["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]
 * [[],[3],[],[],[]]
 * 输出：[null,null,3,-1,-1]
 * 限制：1 <= values <= 10000    最多会对 appendTail、deleteHead 进行 10000 次调用
 * <p>
 * 思路：
 * 队列特性，先添加的先删除；栈特性，先添加的后删除
 * 两个栈模拟队列，添加时将值添加到栈一；删除时，先判断栈2中是否有值，如果有值，则先从栈2移除，否则，将栈1的值添加到栈2中，再执行pop操作，这样做
 * 的目的是：防止执行一次删除操作后，又执行添加操作，保证顺序
 */
public class CQueue {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();

        cQueue.appendTail(3);
        cQueue.appendTail(2);
        cQueue.appendTail(1);

        int i = cQueue.deleteHead();
        System.out.println("i = " + i);
        int i1 = cQueue.deleteHead();
        System.out.println("i1 = " + i1);
        int i2 = cQueue.deleteHead();
        System.out.println("i2 = " + i2);
        int i3 = cQueue.deleteHead();
        System.out.println("i3 = " + i3);
    }

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            //直接从stack2中返回数据
            return stack2.pop();
        }
        //stack2中为空的话，从1中先存入数据，再返回
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        if (stack2.isEmpty()) {
            return -1;
        }
        return stack2.pop();
    }
}





























