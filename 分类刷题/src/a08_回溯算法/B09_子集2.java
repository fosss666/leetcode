package a08_回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/8/14
 * Time: 17:49
 * Description:
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: [1,2,2]
 * 输出: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 */
public class B09_子集2 {

    /**
     * 关键在于去重，与数组组合2类似。先排序，再在for循环中去重
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    private void backtracking(int[] nums, int startIndex) {
        //将添加路径操作放在一开始
        res.add(new ArrayList<>(path));
        if (startIndex == nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) continue;
            int num = nums[i];
            path.add(num);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

}
