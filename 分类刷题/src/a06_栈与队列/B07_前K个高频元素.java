package a06_栈与队列;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: fosss
 * Date: 2023/8/1
 * Time: 9:29
 * Description:
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 提示：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 $O(n \log n)$ , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 */
public class B07_前K个高频元素 {

    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        //int[] res = topKFrequent(nums, 2);
        int[] res = topKFrequent2(nums, 2);
    }

    /**
     * 哈希表+小顶堆（自定义排序） 85%  62%
     * 用小根堆，维护堆大小不超过 k 即可。每次压入堆前和堆顶元素比较，如果比堆顶元素还小，直接扔掉，否则压入堆。检查堆大小是否超过 k，如果超过，弹出堆顶。复杂度是 nlogk
     * 避免使用大根堆，因为你得把所有元素压入堆，复杂度是 nlogn，而且还浪费内存。如果是海量元素，那就挂了
     */
    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //记录每个值出现的次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //返回次数出现最多的前k种，维护小顶堆中k个元素，如果多余k个，将堆顶（最小的）弹出
        int[] res = new int[k];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];//按照第二个值从小到大排序
            }
        });
        for (Integer key : map.keySet()) {
            priorityQueue.add(new int[]{key, map.get(key)});
            //如果堆中元素数>k，弹出堆顶
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = priorityQueue.poll()[0];
        }

        return res;
    }

    /**
     * 哈希表+大顶堆（自定义排序） 85%  39%
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //记录每个值出现的次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //返回次数出现最多的前k种，出现次数按从队头到队尾的顺序是从大到小排,出现次数最多的在队头(相当于大顶堆)
        int[] res = new int[k];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];//按照数组第二个元素进行从大到小排序
            }
        });
        for (Integer key : map.keySet()) {
            priorityQueue.add(new int[]{key, map.get(key)});
        }
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll()[0];
        }

        return res;
    }
}

















