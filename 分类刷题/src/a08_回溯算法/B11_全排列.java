package a08_回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/8/15
 * Time: 10:47
 * Description:
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 */
public class B11_全排列 {

    /**
     * 排列问题，每次都要从头开始搜索，例如元素1在[1,2]中已经使用过了，但是在[2,1]中还要再使用一次1。
     */
    /*public List<List<Integer>> permute(int[] nums) {
        //used用来记录数组每个位置的元素是否被使用
        boolean[] used = new boolean[nums.length];
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
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums, used);
            //回溯
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }*/


    /**
     * 直接用path的内置方法判断是否使用过
     */
    public List<List<Integer>> permute(int[] nums) {
        //used用来记录数组每个位置的元素是否被使用
        boolean[] used = new boolean[nums.length];
        backtracking(nums);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    private void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) continue;
            path.add(nums[i]);
            backtracking(nums);
            //回溯
            path.remove(path.size() - 1);
        }
    }
}
