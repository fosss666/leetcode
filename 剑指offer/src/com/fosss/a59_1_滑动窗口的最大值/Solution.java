package com.fosss.a59_1_滑动窗口的最大值;

import java.util.*;

/**
 * @author: fosss
 * Date: 2023/3/1
 * Time: 20:06
 * Description:给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值
 * 示例：
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 提示：你可以假设 k 总是有效的，在输入数组 不为空 的情况下，1 ≤ k ≤ nums.length
 * <p>
 * 思路：
 * 借助LinkedList能够对首尾的元素进行处理的特性，LinkedList中存储数组下标，对每个窗口较大值的下标进行存储，队头为最大值，如果队头不在窗口内则需要删除
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-6, -10, -7, -1, -9, 9, -8, -4, 10, -5, 2, 9, 0, -7, 7, 4, -2, -10, 8, 7};
        int[] res = solution.maxSlidingWindow2(nums, 7);
        System.out.println("res = " + Arrays.toString(res));
    }

    /**
     * 大顶堆+map  不能解决数组中出现重复数字的情况，小丑
     */
    //public int[] maxSlidingWindow3(int[] nums, int k) {
    //    int[] res = new int[nums.length - k + 1];
    //    int index = 0;
    //    //大顶堆-由大到小
    //    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
    //        @Override
    //        public int compare(Integer o1, Integer o2) {
    //            return o2 - o1;
    //        }
    //    });
    //    Map<Integer, Integer> map = new HashMap<>();
    //    for (int i = 0; i < nums.length; i++) {
    //        map.put(nums[i], i);
    //    }
    //    for (int i = 0; i < nums.length; i++) {
    //        //判断队头是不是在窗口内，不在的话就弹出
    //        while (queue.size() > 0 && map.get(nums[i]) - map.get(queue.peek()) >= k) {
    //            queue.poll();
    //        }
    //        queue.add(nums[i]);
    //        if (i >= k - 1) {
    //            res[index++] = queue.peek();
    //        }
    //    }
    //    return res;
    //}

    /**
     * 队列LinkedList   93%   35%
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        //队列中存放下标，目的是判断队头是否再窗口内
        LinkedList<Integer> queue = new LinkedList<>();
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //判断队尾和新元素的大小，如果比新元素小，则将队尾一直出队列
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            //新元素入队
            queue.addLast(i);

            //队头是最大值的下标，需要先判断队头是否在窗口内  这里是关键！！  i- queue.peek()>=k
            //每次只会添加一个元素，所以最多只有一个元素在窗口外，所以用if就可以
            if (i - queue.peek() >= k) {
                //说明队头不在窗口内，则先将其剔除
                queue.poll();
            }

            //此时队头就是窗口最大元素的下标了
            //注意i要大于等于k-1后才开始添加结果值
            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.peek()];
            }
        }

        return res;
    }

    /**
     * 自解，两个while  超时
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        //i为滑动窗口左边界，j为滑动窗口右边界
        int i = 0, j = k - 1;
        int[] res = new int[nums.length - k + 1];
        int m = 0;
        while (j < nums.length) {
            int max = nums[i];
            i++;
            //找到窗口中的最大值
            while (i <= j) {
                if (max < nums[i]) {
                    max = nums[i];
                }
                i++;
            }
            res[m++] = max;
            //更新j和i
            j++;
            i = j - (k - 1);
        }

        return res;
    }
}























