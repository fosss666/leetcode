package a11_单调栈;

import java.util.Stack;

/**
 * @author: fosss
 * Date: 2023/11/11
 * Time: 16:11
 * Description:
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该
 * 位置用 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class B01_每日温度 {

    /**
     * 单调栈
     * 什么时候用单调栈呢？通常是一维数组，要寻找任一个元素的右边或者左边第一个比自己大或者小的元素的位置，此时我们就要想到可以用单调栈了。
     * 时间复杂度为O(n)。
     * 如果求一个元素右边第一个更大元素，单调栈就是递增的(从栈顶到栈底)，如果求一个元素右边第一个更小元素，单调栈就是递减的。
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int[] res = new int[temperatures.length];
        //栈中存储下标
        Stack<Integer> stack = new Stack<>();
        //将第一个元素的下标入栈，从第二个元素开始进行判断
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] <= temperatures[stack.peek()]) {
                //当前元素比栈顶小于等于，入栈
                stack.push(i);
            } else {
                //如果当前元素比栈顶元素大的话，将栈顶弹出，直到栈空或栈顶元素大于当前元素
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    Integer index = stack.pop();
                    //此时index的右边比他大的第一个元素已经找到
                    res[index] = i - index;
                }
                //将当前下标入栈
                stack.push(i);
            }
        }
        return res;
    }

    /**
     * 暴力循环——超时，呜呜呜
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i]++;
                    break;
                } else {
                    //如果都不比i大
                    if (j == temperatures.length - 1) {
                        res[i] = 0;
                    } else {
                        res[i]++;
                    }
                }
            }
        }
        return res;
    }
}
