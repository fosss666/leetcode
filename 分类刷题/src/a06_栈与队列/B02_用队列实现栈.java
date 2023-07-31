package a06_栈与队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: fosss
 * Date: 2023/7/31
 * Time: 11:06
 * Description:
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 */
public class B02_用队列实现栈 {
    /**
     * 单队列实现  通过观察发现双队列方法中第二个队列完全不需要，非常奈斯
     */
    Queue<Integer> queue;

    public B02_用队列实现栈() {
        queue = new LinkedList<Integer>();
    }

    public void push(int x) {
        queue.add(x);
        //将这个新加入的数放到队列出队的位置
        int size = queue.size();
        while (size > 1) {
            queue.add(queue.poll());
            size--;
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }


    /**
     * ====================双队列实现=======================
     */
   /*
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public B02_用队列实现栈() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    //双队列但优化了一点。在push操作中就将出栈顺序整理好
    public void push(int x) {
        //加入队列1
        queue1.add(x);
        //将队列2中所有元素放入队列1
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        //将队列1的所有元素放入队列2，可以用while循环或者直接交换
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue2.poll();
    }

    public int top() {
        return queue2.peek();
    }

    public boolean empty() {
        return queue2.isEmpty();
    }

    //双队列，第二个队列用来备份
    //public void push(int x) {
    //    queue1.add(x);
    //}
    //
    //public int pop() {
    //    while (queue1.size() > 1) {
    //        queue2.add(queue1.poll());
    //    }
    //    while (!queue2.isEmpty()) {
    //        queue1.add(queue2.poll());
    //    }
    //    return queue1.poll();
    //}
    //
    //public int top() {
    //    while (queue1.size() > 1) {
    //        queue2.add(queue1.poll());
    //    }
    //    int res = queue1.peek();
    //    queue2.add(queue1.poll());
    //    while (!queue2.isEmpty()) {
    //        queue1.add(queue2.poll());
    //    }
    //    return res;
    //}
    //
    //public boolean empty() {
    //    return queue1.isEmpty();
    //}

    */
}














