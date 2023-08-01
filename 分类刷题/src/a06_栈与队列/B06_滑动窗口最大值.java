package a06_栈与队列;

import java.util.LinkedList;

/**
 * @author: fosss
 * Date: 2023/8/1
 * Time: 8:52
 * Description:
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 提示：
 * 1 <= nums.length <= 105
 * -104<= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class B06_滑动窗口最大值 {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        maxSlidingWindow(nums, 3);
    }

    /**
     * 双端队列
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //队列用来存储数的下标，方便利用下标比较数是否在窗口内
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            //非空且当前元素比队列最后添加的元素大时，将队尾元素不断弹出
            while (list.size() > 0 && nums[list.peekLast()] < nums[i]) {
                list.pollLast();
            }
            //将当前元素的下标入队
            list.addLast(i);
            //队头存储的是暂时可能的最大值下标，但是这个元素可能不在窗口内，所以需要进行判断
            Integer headIndex = list.peekFirst();
            if (i - headIndex >= k) {
                //不在窗口内，直接将其弹出
                list.pollFirst();
                headIndex = list.peekFirst();
            }
            //窗口满（即需要先跳过开始的k-1个元素）时添加队列
            if (i >= k - 1) {
                res[index++] = nums[headIndex];
            }
        }
        return res;
    }
}



















