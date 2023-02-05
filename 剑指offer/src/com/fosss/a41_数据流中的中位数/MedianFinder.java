package com.fosss.a41_数据流中的中位数;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author fosss
 * @date 2023/2/5
 * @description： 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位
 * 数就是所有数值排序之后中间两个数的平均值。
 * 例如，[2,3,4]的中位数是 3   [2,3]的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 */
class MedianFinder {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        double res = medianFinder.findMedian();
        System.out.println("res = " + res);
    }

    Queue<Integer> A, B;

    /**
     * 借助大顶堆和小顶堆
     * https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/solution/mian-shi-ti-41-shu-ju-liu-zhong-de-zhong-wei-shu-y/
     */
    public MedianFinder() {
        //根据它们的自然顺序进行排序，或者由队列构造时提供的Comparator器排序
        //小顶堆-每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆
        A = new PriorityQueue<>();
        //大顶堆-每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆, 注意 : 没有要求结点的左孩子的值和右孩子的值的大小关系。
        B = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        //设元素总数为N=m+n,m和n分别为A和B中的元素个数
        int m = A.size();
        int n = B.size();
        int N = m + n;
        if (N % 2 == 0) {
            //当N为偶数：需向A添加一个元素。实现方法：将新元素 num插入至 B，再将B堆顶元素插入至A ；
            B.add(num);
            A.add(B.poll());
        } else {
            //当N为奇数：需向 B添加一个元素。实现方法：将新元素 num插入至 A，再将A堆顶元素插入至B ；
            A.add(num);
            B.add(A.poll());
        }
    }

    /**
     * 寻找中位数
     */
    public double findMedian() {

        //当N为奇数：则中位数为A的堆顶元素。
        int m = A.size();
        int n = B.size();
        int N = m + n;
        if (N % 2 == 0) {
            //当N为偶数：则中位数为 (A的堆顶元素 + B的堆顶元素 )/2.0,注意这里返回的是double类型，除数必须为小数，否则结果就无法出现小数情况
            return (A.peek() + B.peek()) / 2.0;
        } else {
            return A.peek();
        }

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


















