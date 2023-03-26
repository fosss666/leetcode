package com.fosss.a31_栈的压入弹出序列;

import java.util.Stack;

/**
 * @author fosss
 * @date 2023/1/24
 * @description： 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列
 * {1,2,3,4,5}是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列
 * 示例： 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * <p>
 * 思路：
 * 借助一个栈，遍历pushed数组，向栈中添加元素，while循环判断如果 “!stack.isEmpty() && stack.peek() == popped[i]”，则出栈，i++
 * 返回栈是否为空或i是否等于popped.length
 */
public class Solution {
    public static void main(String[] args) {
        int[] pushed = {1, 0, 2};
        int[] popped = {2, 1, 0};
        Solution solution = new Solution();
        boolean result = solution.validateStackSequences(pushed, popped);
        System.out.println("result = " + result);
    }

    /**
     * 辅助栈
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int p : pushed) {
            stack.push(p);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}




















