package a08_回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/8/15
 * Time: 11:23
 * Description:
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出： [[1,1,2], [1,2,1], [2,1,1]]
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 提示：
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class B12_全排列2 {

    /**
     * 全排列只是在遍历时去掉自己，这个题数组中有重复的元素，所以每个排列可以有重复，但是不同排列不可以重复
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        //used用来记录数组每个位置的元素是否被使用
        boolean[] used = new boolean[nums.length];
        //先排序
        Arrays.sort(nums);
        backtracking(nums, used);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    private void backtracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //去重  同一树层
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) continue;

            //还要去掉本身
            if (used[i] == false) {
                used[i] = true;
                path.add(nums[i]);
                backtracking(nums, used);
                //回溯
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
