package a08_回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/8/14
 * Time: 17:37
 * Description:
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例: 输入: nums = [1,2,3] 输出: [ [3],   [1],   [2],   [1,2,3],   [1,3],   [2,3],   [1,2],   []
 */
public class B08_子集 {

    /**
     * 将空集提前添加，收集路径操作放在路径改变之后
     */
    /*public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());// 空集也是一种情况
        backtracking(nums, 0);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    private void backtracking(int[] nums, int startIndex) {
        if (startIndex == nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            int num = nums[i];
            path.add(num);
            //路径一边就加到res里，这样可以就加到所有的子集
            res.add(new ArrayList<>(path));
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }*/

    /**
     * 同意在回溯算法中添加
     */
    public List<List<Integer>> subsets(int[] nums) {
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
            int num = nums[i];
            path.add(num);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}













