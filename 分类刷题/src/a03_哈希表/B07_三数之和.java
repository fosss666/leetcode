package a03_哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/7/24
 * Time: 9:18
 * Description:
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意： 答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 */
public class B07_三数之和 {

    /**
     * 双指针法
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        //先排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //排序后数组从左到右递增，只有nums[i]<小于零才可能出现符合条件的三数
            if (nums[i] > 0) {
                break;
            }
            //去重，注意这里不能是nums[i]==nums[i+1]，否则：因为left从i+1开始，正确结果会漏掉[-1,-1,2]这种情况
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //i，left，right分别为要找的三个数，所以left不能=right
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    //将结果放到返回结果
                    res.add(list);
                    //对另外两个数去重
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    //两边收缩
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}














