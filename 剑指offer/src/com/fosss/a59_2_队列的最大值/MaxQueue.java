package com.fosss.a59_2_队列的最大值;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @author: fosss
 * Date: 2023/3/13
 * Time: 20:20
 * Description:请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value需要返回 -1
 * 示例：
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出:[null,null,null,2,1,2]
 * 限制：1 <= push_back,pop_front,max_value的总操作数 <= 10000  1 <= value <= 10^5
 */
public class MaxQueue {

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        int max = maxQueue.max_value();
        System.out.println("max = " + max);
        int pop = maxQueue.pop_front();
        System.out.println("pop = " + pop);
        int max2 = maxQueue.max_value();
        System.out.println("max2 = " + max2);
    }


    /**
     * 自解 LinkedList+TreeMap   6%  59%
     */
    private LinkedList<Integer> queue;
    private TreeMap<Integer, Integer> map;

    public MaxQueue() {
        queue = new LinkedList<>();
        map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public int max_value() {
        for (Integer key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }
        return -1;
    }

    public void push_back(int value) {
        queue.add(value);
        if (map.get(value) == null || map.get(value) == 0) {
            map.put(value, 1);
        } else {
            map.put(value, map.get(value) + 1);
        }
    }

    public int pop_front() {
        if (queue.size() == 0) {
            return -1;
        }
        map.put(queue.peek(), map.get(queue.peek()) - 1);
        return queue.poll();
    }
}























