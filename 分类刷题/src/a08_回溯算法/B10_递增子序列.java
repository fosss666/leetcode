package a08_回溯算法;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: fosss
 * Date: 2023/8/15
 * Time: 10:02
 * Description:
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * 示例:
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 */
public class B10_递增子序列 {

    public static void main(String[] args) {
        B10_递增子序列 test = new B10_递增子序列();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 1, 1};
        List<List<Integer>> res = test.findSubsequences(nums);
        System.out.println("res = " + res);
    }

    /**
     * 去重是个坑，一般我们子集去重直接 i>start && nums[i]==nums[i-1] 就行了，那么 [1,2,3,1,1,1,1] 这个用例就过不了，这是因为子集时我们排了序的，
     * 而这里不是有序的，所以得在每层循环中加 set 来去重
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    private void backtracking(int[] nums, int startIndex) {
        if (path.size() >= 2) res.add(new ArrayList<>(path));
        if (startIndex == nums.length) return;

        //用set标记不同组合间是否重复
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            //去重。不能像组合总和2和子集2那样去重，此题数组不能排序，可能出现多个相同的数但不同时存在的情况
            //!path.isEmpty() && nums[i] < path.get(path.size() - 1)  不符合递增
            //set.contains(nums[i])就是不同组合间重复了
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || set.contains(nums[i])) continue;

            set.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);

        }
    }
}
