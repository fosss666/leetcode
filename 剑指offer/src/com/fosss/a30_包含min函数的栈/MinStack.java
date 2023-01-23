package com.fosss.a30_包含min函数的栈;

import java.util.*;

/**
 * @author fosss
 * @date 2023/1/23
 * @description： 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)
 * 示例：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * 提示：各函数的调用总次数不超过 20000 次
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();   //   --> 返回 0.
        System.out.println(minStack.min());
    }


    /**
     * ===============自解，双栈
     */
    LinkedList<Integer> stack;
    LinkedList<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    //调用 min、push 及 pop 的时间复杂度都是 O(1)
    public void push(int x) {
        if (minStack.size() == 0) {
            minStack.addFirst(x);
        } else if (x <= minStack.getFirst()) {
            minStack.addFirst(x);
        } else {
            minStack.addLast(x);//根据k神代码，这里根本不需要存储大于minStack.getFirst()的值，例如先添加3和4，pop的时候3永远是在4后面被pop
        }

        stack.push(x);
    }

    public void pop() {
        Integer pop = stack.pop();
        //此题如果用==将会无法通过 Integer的equals重写过，比较的是内部value的值， ==如果在[-128,127]会被cache缓存,超过这个范围则比较的是对象是否相同
        if (pop.equals(minStack.getFirst())) {
            minStack.removeFirst();
        }
    }

    public int top() {
        return stack.getFirst();
    }

    public int min() {
        return minStack.getFirst();
    }
}


























