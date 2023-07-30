package a03_哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/7/24
 * Time: 10:46
 * Description:
 * 题意：给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与
 * target 相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 * 示例： 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。 满足要求的四元组集合为： [ [-1, 0, 0, 1], [-2, -1, 1, 2],
 * [-2, 0, 0, 2] ]
 */
public class B08_四数之和 {
    /**
     * 思路大体与三数之和一直，区别在于多了一层循环(多了一层剪枝和一层去重)，以及剪枝操作有区别
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        //先排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //剪枝  避免target=-5  [-4,-1,0,0]这种类似情况
            if (nums[i] > target && nums[i] >= 0) {
                break;
            }
            //对nums[i]去重
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                //二级剪枝
                int t = nums[i] + nums[j];
                if (t > target && t >= 0) {
                    break;
                }
                //对nums[j]去重
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = t + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        //对nums[left]、nums[right]去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        //两边收缩------为了不死循环！！！！！！
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}




















