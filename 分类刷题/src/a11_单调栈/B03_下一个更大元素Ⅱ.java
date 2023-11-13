package a11_单调栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: fosss
 * Date: 2023/11/13
 * Time: 18:57
 * Description:
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，
 * 这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * 示例 1:
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；数字 2 找不到下一个更大的数；第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 提示:
 * 1 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 */
public class B03_下一个更大元素Ⅱ {

    public static void main(String[] args) {
        B03_下一个更大元素Ⅱ test = new B03_下一个更大元素Ⅱ();
        int[] res = test.nextGreaterElements2(new int[]{1, 2, 1});
        System.out.println("res = " + Arrays.toString(res));
    }

    /**
     * 方法一 将数组复制拼接在一起
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] newNums = new int[nums.length * 2];
        for (int i = 0; i < newNums.length; i++) {
            newNums[i] = nums[i % nums.length];
        }
        //后面跟《每日温度》一样
        int[] res = new int[newNums.length];
        Arrays.fill(res, -1);//初始化为-1
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < newNums.length; i++) {

            while (!stack.isEmpty() && newNums[i] > newNums[stack.peek()]) {
                Integer pop = stack.pop();
                res[pop] = newNums[i];
            }
            stack.push(i);

            //if (newNums[i] <= newNums[stack.peek()]) {
            //    //直接入栈
            //    stack.push(i);
            //} else {
            //    while (!stack.isEmpty() && newNums[i] > newNums[stack.peek()]) {
            //        Integer pop = stack.pop();
            //        res[pop] = newNums[i];
            //    }
            //    //最后入栈
            //    stack.push(i);
            //}
        }
        //截取
        return Arrays.copyOfRange(res, 0, nums.length);
    }

    /**
     * 方法二，循环中模拟数组复制成两份的状态。上面res中一半是浪费掉的
     */
    public int[] nextGreaterElements2(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);//初始化为-1
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                Integer pop = stack.pop();
                res[pop] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return res;
    }

}















