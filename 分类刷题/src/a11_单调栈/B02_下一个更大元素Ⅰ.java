package a11_单调栈;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: fosss
 * Date: 2023/11/12
 * Time: 16:03
 * Description:
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * 示例 1:
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 * 对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 * 对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 示例 2:
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 * 对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 * 对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出-1 。
 * 提示：
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 10^4
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 */
public class B02_下一个更大元素Ⅰ {

    public static void main(String[] args) {
        B02_下一个更大元素Ⅰ tes = new B02_下一个更大元素Ⅰ();
        tes.nextGreaterElement2(new int[]{1, 3, 5, 2, 4}, new int[]{5, 4, 3, 2, 1});
    }

    /**
     * 哈希表、单调栈
     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Map<Integer, Integer> map = new HashMap<>();
        //后面要对nums2进行遍历，判断是否在nums1中出现过，所以用map记录nums1的下标
        for (int i = 0; i < nums1.length; i++) map.put(nums1[i], i);

        //下面跟每日温度差不多
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= nums2[stack.peek()]) {
                //下标入栈，保持栈的递增性
                stack.push(i);
            } else {
                //当前元素比栈顶大时，持续处理
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                    Integer pop = stack.pop();
                    //如果是要求的nums1中的元素，则记录
                    if (map.containsKey(nums2[pop])) res[map.get(nums2[pop])] = nums2[i];
                }
                //当前元素下标入栈
                stack.push(i);
            }
        }
        return res;
    }

    /**
     * 哈希表、遍历查找
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            for (int j = map.get(nums1[i]); j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }
}










