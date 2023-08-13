package a08_回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/8/13
 * Time: 11:08
 * Description:
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]
 * 示例 2: 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class B02_组合总和3 {

    /**
     * 现在不仅要找组合，还要有限定条件和为n，元素范围为1~9且没有重复的数字
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    /**
     * 回溯算法
     *
     * @param k          共k个元素
     * @param n          和为n
     * @param startIndex 起始数字
     */
    private void backtracking(int k, int n, int startIndex) {
        if (path.size() == k) {
            //n减为0了，说明此时path的元素符合要求，加入返回集合。注意要将新集合加入返回集合。
            if (n == 0) res.add(new ArrayList<>(path));
            //path个数达到k就结束
            return;
        }

        //数字范围是startIndex~9
        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            backtracking(k, n - i, i + 1);//n-i作为第二个参数
            //回溯
            path.remove(path.size() - 1);
        }
    }

    /**
     * 回溯算法
     * 经两个剪枝优化
     *
     * @param k          共k个元素
     * @param n          和为n
     * @param startIndex 起始数字
     */
    private void backtracking2(int k, int n, int startIndex) {
        //剪枝2：当n已经<0时，没必要再进行了
        if (n < 0) return;
        if (path.size() == k) {
            //n减为0了，说明此时path的元素符合要求，加入返回集合。注意要将新集合加入返回集合。
            if (n == 0) res.add(new ArrayList<>(path));
            //path个数达到k就结束
            return;
        }

        //剪枝1：与组合问题一样，也可以做剪枝：还需元素个数：a=(k-path.size())   还剩下未使用的数字个数：b=(9-i+1)  b>=a时才有必要进行循环 即
        // i<=9+1+path.size()-k
        for (int i = startIndex; i <= 10 + path.size() - k; i++) {
            path.add(i);
            backtracking2(k, n - i, i + 1);//n-i作为第二个参数
            //回溯  n-i也暗中做了回溯
            path.remove(path.size() - 1);
        }
    }
}









