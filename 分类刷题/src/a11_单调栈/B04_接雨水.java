package a11_单调栈;

import java.util.Stack;

/**
 * @author: fosss
 * Date: 2023/11/14
 * Time: 16:53
 * Description: https://leetcode.cn/problems/trapping-rain-water/description/
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class B04_接雨水 {

    public static void main(String[] args) {
        B04_接雨水 test = new B04_接雨水();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        test.trap3(height);
    }

    /**
     * 暴力解法，按照每列可以接多少水来计算
     */
    public int trap(int[] height) {
        //记录接水量
        int sum = 0;
        //遍历需要接水的列，第一列和最后一列不可能接水，所以不必遍历
        for (int i = 1; i < height.length - 1; i++) {
            //分别找到i左右比i高且最高的列的高度
            int left = 0, right = 0;
            //左侧
            for (int j = 0; j < i; j++) if (height[j] > left) left = height[j];
            //右侧
            for (int j = i + 1; j < height.length; j++) if (height[j] > right) right = height[j];
            //计算第i列可以接水的量  左右较低的高度减去第i列的高度
            int quantity = Math.min(left, right) - height[i];
            //为正数则进行统计
            if (quantity > 0) sum += quantity;
        }
        return sum;
    }

    /**
     * 双指针法
     */
    public int trap2(int[] height) {
        //暴力解法中，每个i都要求一边i左右的最高值，可以提前计算出来并分别放到一个数组中，避免重复计算
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        //计算每个i左侧的最大值
        for (int i = 1; i < height.length; i++) leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        //计算每个i右侧的最大值 主要从右向左遍历
        for (int i = height.length - 2; i >= 0; i--) rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);

        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int quantity = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (quantity > 0) sum += quantity;
        }
        return sum;
    }

    /**
     * 单调栈法
     * 与以上解法区别，单调栈法是按照行方向计算
     * 从栈头（元素从栈头弹出）到栈底的顺序应该是从小到大的顺序。因为一旦发现添加的柱子高度大于栈头元素了，此时就出现凹槽了，栈头元素就是
     * 凹槽底部的柱子，栈头第二个元素就是凹槽左边的柱子，而添加的元素就是凹槽右边的柱子。
     * 遇到相同的元素，更新栈内下标，就是将栈里元素（旧下标）弹出，将新元素（新下标）加入栈中。
     */
    public int trap3(int[] height) {
        //栈中存储高度下标
        Stack<Integer> stack = new Stack<>();
        //将第一个高度的下标先入栈，下一个高度与其比较
        stack.push(0);

        int sum = 0;
        //遍历高度
        for (int i = 1; i < height.length; i++) {
            //如果当前高度<栈顶元素高度，则入栈
            if (height[i] < height[stack.peek()]) {
                stack.push(i);
            } else if (height[i] == height[stack.peek()]) {
                //如果高度相等，则不能出现凹槽，更新新下标
                stack.pop();
                stack.push(i);
            } else {
                //当前高度>栈顶高度
                //则当前高度为凹槽的右界
                //一行一行地寻找左界
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    Integer mid = stack.pop();//凹槽的中间位置
                    //计算行方向的量，即矩形面积
                    // 有左界的时候才需要计算，才能够构成凹槽，即至少三个高度才能构成凹槽
                    if (!stack.isEmpty()) {
                        //获取左界，注意不需要出栈
                        Integer left = stack.peek();
                        //计算行方向的面积
                        int width = i - left - 1;//左右宽度
                        int h = Math.min(height[left], height[i]) - height[mid];//上下高度
                        int quantity = width * h;
                        if (quantity > 0) sum += quantity;
                    }
                }
                //处理完之后，将当前高度的下标入栈
                stack.push(i);
            }
        }
        return sum;
    }
}
