package a06_栈与队列;

import java.util.Stack;

/**
 * @author: fosss
 * Date: 2023/7/30
 * Time: 20:27
 * Description:
 * 使用栈实现队列的下列操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 */
public class B01_用栈实现队列 {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public B01_用栈实现队列() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        //如果2中有元素，则从2中出栈返回；否则，先将1中所有元素放到2中，再从2中出栈返回
        if (stack2.size() > 0) {
            return stack2.pop();
        } else {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public int peek() {
        //与pop操作差不多
        /**
         * if (stack2.size() > 0) {
         *             return stack2.peek();
         * } else {
         *     while (stack1.size() > 0) {
         *         stack2.push(stack1.pop());
         *     }
         *     return stack2.peek();
         * }
         */
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.size() == 0 && stack2.size() == 0;
    }
}
