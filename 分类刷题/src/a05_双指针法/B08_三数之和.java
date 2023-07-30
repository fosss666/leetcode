package a05_双指针法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/7/30
 * Time: 15:04
 * Description:
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意： 答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 */
public class B08_三数之和 {

    /**
     * 双指针法
     * 题目要求不可包含重复的三元组，所以要做好去重操作
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //如果排序nums[i]是正数的话，肯定不存在后面几个数与他的和为0的情况了
            if (nums[i] > 0) {
                break;
            }
            //对a去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //寻找另外两个数
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    //对b,c去重
                    while (left < right && (nums[left] == nums[left + 1])) {
                        left++;
                    }
                    while (left < right && (nums[right] == nums[right - 1])) {
                        right--;
                    }
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
















