package a05_双指针法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/7/30
 * Time: 15:39
 * Description:
 * 题意：给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与
 * target 相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 * 示例： 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。 满足要求的四元组集合为：
 * [ [-1, 0, 0, 1], [-2, -1, 1, 2],[-2, 0, 0, 2] ]
 */
public class B09_四数之和 {

    public static void main(String[] args) {
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        List<List<Integer>> res = fourSum(nums, -294967296);
    }

    /**
     * 整体思路与三数之和是相似的，区别主要在于对于和的要求从0变成了任意target；需要多一层循环来找第二个数，同时多一次去重及剪枝操作
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        //先排序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            //第一次剪枝,需要注意不能只判断nums[i]>target，因为后边的书可能是负数，即可能越加越小
            if (nums[i] > target && nums[i] >= 0) {
                break;
            }
            //对a去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                //第二次剪枝
                if (nums[j] + nums[i] > target && nums[j] + nums[i] >= 0) {
                    break;
                }
                //对b去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        //对c，d去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}















