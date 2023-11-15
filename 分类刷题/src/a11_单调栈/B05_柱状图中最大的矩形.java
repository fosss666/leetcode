package a11_单调栈;

import java.util.Stack;

/**
 * @author: fosss
 * Date: 2023/11/15
 * Time: 16:20
 * Description: https://leetcode.cn/problems/largest-rectangle-in-histogram/description/
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class B05_柱状图中最大的矩形 {

    public static void main(String[] args) {
        B05_柱状图中最大的矩形 test = new B05_柱状图中最大的矩形();
        test.largestRectangleArea3(new int[]{1, 1});
    }

    /**
     * 暴力解法
     */
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            //找i左边第一个比height[i]小的下标
            int left = i;
            for (; left >= 0; left--) {
                if (heights[left] < heights[i]) break;
            }
            //找i右边第一个比height[i]小的下标
            int right = i;
            for (; right < heights.length; right++) {
                if (heights[right] < heights[i]) break;
            }
            //高
            int h = heights[i];
            //宽
            int w = right - left - 1;
            //更新最大面积
            max = Math.max(max, h * w);
        }
        return max;
    }

    /**
     * 双指针法
     */
    public int largestRectangleArea2(int[] heights) {
        int max = 0;
        //提前计算每个i左右第一个比height[i]小的下标，注意是第一个
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        //初始化
        left[0] = -1;
        //求左侧第一个大的下标。 从左向右遍历
        for (int i = 1; i < heights.length; i++) {
            int l = i - 1;
            while (l >= 0 && heights[l] >= heights[i]) l = left[l];
            left[i] = l;
        }
        //求右侧第一个大的下标。 从右向左遍历
        right[heights.length - 1] = heights.length;
        for (int i = heights.length - 1; i >= 0; i--) {
            int r = i + 1;
            while (r < heights.length && heights[r] >= heights[i]) r = right[r];
            right[i] = r;
        }

        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int w = right[i] - left[i] - 1;
            max = Math.max(max, h * w);
        }
        return max;
    }

    /**
     * 单调栈
     * 《接雨水》是找每个柱子左右两边第一个大于该柱子高度的柱子，而本题是找每个柱子左右两边第一个小于该柱子的柱子，所以栈是单调减的
     */
    public int largestRectangleArea3(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();

        // 数组扩容，在头和尾各加入一个元素。原因？
        /**
         * 首先来说末尾为什么要加元素0？如果数组本身就是升序的，例如[2,4,6,8]，那么入栈之后 都是单调递减，一直都没有走 情况三 计算结
         * 果的哪一步，所以最后输出的就是0了。那么结尾加一个0，就会让栈里的所有元素，走到情况三的逻辑。
         * 开头为什么要加元素0？
         * 如果数组本身是降序的，例如 [8,6,4,2]，在 8 入栈后，6 开始与8 进行比较，此时我们得到 mid（8），rigt（6），但是得不到
         * left。（mid、left，right 都是对应版本一里的逻辑）因为 将 8 弹出之后，栈里没有元素了，那么为了避免空栈取值，直接跳过了
         * 计算结果的逻辑。之后又将6 加入栈（此时8已经弹出了），然后 就是 4 与 栈口元素 8 进行比较，周而复始，那么计算的最后结果resutl就是0
         */
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++) {
            newHeights[index + 1] = heights[index];
        }

        heights = newHeights;

        st.push(0);
        int result = 0;
        // 第一个元素已经入栈，从下标1开始
        for (int i = 1; i < heights.length; i++) {
            // 注意heights[i] 是和heights[st.top()] 比较 ，st.top()是下标
            if (heights[i] > heights[st.peek()]) {
                st.push(i);
            } else if (heights[i] == heights[st.peek()]) {
                st.pop(); // 这个可以加，可以不加，效果一样，思路不同
                st.push(i);
            } else {
                while (!st.isEmpty() && heights[i] < heights[st.peek()]) { // 注意是while
                    int mid = st.peek();
                    st.pop();
                    int left = st.peek();
                    int w = i - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                }
                st.push(i);
            }
        }
        return result;
    }
}
