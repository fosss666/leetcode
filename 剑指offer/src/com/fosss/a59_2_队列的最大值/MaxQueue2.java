package com.fosss.a59_2_队列的最大值;

import java.util.LinkedList;

/**
 * @author: fosss
 * Date: 2023/3/13
 * Time: 21:14
 * Description: 条件如上类
 */
public class MaxQueue2 {
    /**
     * 双队列   73%  97%
     */
    private LinkedList<Integer> res, max;

    public MaxQueue2() {
        res = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        return max.isEmpty() ? -1 : max.peekFirst();
    }

    public void push_back(int value) {
        res.addLast(value);
        while (!max.isEmpty() && max.peekLast() < value) {
            //如果max的最后一个数比要添加的值小，就不断地将最后一个数去除
            max.removeLast();
        }
        //入队
        max.addLast(value);
    }

    public int pop_front() {
        if (res.isEmpty()) {
            return -1;
        }
        Integer temp = res.removeFirst();
        if (!max.isEmpty() && temp.equals(max.peekFirst())) {
            max.removeFirst();
        }
        return temp;
    }
}


























