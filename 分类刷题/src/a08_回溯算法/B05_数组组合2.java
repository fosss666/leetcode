package a08_回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/8/13
 * Time: 18:07
 * Description:
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明： 所有数字（包括目标数）都是正整数。解集不能包含重复的组合。
 * 示例：
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
public class B05_数组组合2 {

    /**
     * 此题与数组组合1的区别在于candidates每个数字在每个组合中只能使用一次，就是说candidates中可能存在重复的数字，每个组合中可以存在重复的数字，但是
     * 不能有重复的组合。
     * 把所有组合求出来，再用set或者map去重，这么做很容易超时！所以要在搜索的过程中就去掉重复组合。
     * 组合是不可以重复的，但是组合中的元素是可以重复的，所以将数组排序后，只要保证不同组合不会同时出现两个相同的数就行，两种方式。
     */

    /**
     * 方式一：用一个布尔类型的数组isVisited[i]记录i这个元素是否访问过，同组合是可以重复的，for循环表示的是不同组合的，所以如果for中出现连续出现
     * 的数字就跳过
     */
    /*public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        isVisited = new boolean[candidates.length];//默认每个元素是false
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return res;
    }

    private List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] isVisited;

    private void backtracking(int[] candidates, int target, int startIndex) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            //重复且不是同组
            if (i > 0 && candidates[i] == candidates[i - 1] && isVisited[i-1] == false) {
                continue;
            }
            //true表示是同一个组合不同元素（可以重复）
            isVisited[i] = true;
            path.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);
            isVisited[i] = false;
        }
    }*/

    /**
     * 方式一剪枝：用一个布尔类型的数组isVisited[i]记录i这个元素是否访问过，同组合是可以重复的，for循环表示的是不同组合的，所以如果for中出现连续出现
     * 的数字就跳过
     */
    /*public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        isVisited = new boolean[candidates.length];//默认每个元素是false
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return res;
    }

    private List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] isVisited;

    private void backtracking(int[] candidates, int target, int startIndex) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && target - candidates[i] >= 0; i++) {
            //重复且不是同组
            if (i > 0 && candidates[i] == candidates[i - 1] && isVisited[i - 1] == false) {
                continue;
            }
            //true表示是同一个组合不同元素（可以重复）
            isVisited[i] = true;
            path.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);
            isVisited[i] = false;
        }
    }*/

    /**
     * 方式二：利用startIndex判断是否是同组
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return res;
    }

    private List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    private void backtracking(int[] candidates, int target, int startIndex) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && target - candidates[i] >= 0; i++) {
            //重复且不是同组。 ``这一个for循环内，是一个组合``，所以，这个for循环内不能出现连续的数字
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            //true表示是同一个组合不同元素（可以重复）
            path.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }

}
