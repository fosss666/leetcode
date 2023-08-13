package a08_回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/8/13
 * Time: 17:42
 * Description:
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为： [ [7], [2,2,3] ]
 * 示例 2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为： [ [2,2,2,2], [2,3,3], [3,5] ]
 */
public class B04_数组组合 {

    private List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int startIndex) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        //数组元素均为正且递归第三个参数为本身，所以出现target<0结束是没有问题的且必须有这个结束条件
        if (target < 0) return;

        //剪枝优化，对于升序排列的数组，如果target - candidates[i]<0，由于i后边的数都大于i所以就不用进行后面的循环了
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            //注意每个path中是可以有重复元素的，所以第三个参数从i开始就行，不用从下一个开始
            backtracking(candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }


    //==================剪枝优化版本========================
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //改变1：将数组排序
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return res;
    }

    //剪枝优化
    private void backtracking2(int[] candidates, int target, int startIndex) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        //数组元素均为正且递归第三个参数为本身，所以出现target<0结束是没有问题的且必须有这个结束条件
        //if (target < 0) return;

        //改变2：对于升序排列的数组，如果target - candidates[i]<0，由于i后边的数都大于i所以就不用进行后面的循环了
        for (int i = startIndex; i < candidates.length && target - candidates[i] >= 0; i++) {
            path.add(candidates[i]);
            //注意每个path中是可以有重复元素的，所以第三个参数从i开始就行，不用从下一个开始
            backtracking2(candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }

}
