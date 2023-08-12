package a08_回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/8/12
 * Time: 21:47
 * Description:
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 示例：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class B01_组合 {

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    private void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            //路径元素数等于k时将路径放入返回集合并结束回溯
            //注意集合中添加集合时，由于集合是引用类型，所以要new一个新集合，否则一直都是在同一个集合上操作
            res.add(new ArrayList<Integer>(path));
            // path.push(startIndex);
            return;
        }
        //剪枝优化
        //来举一个例子，n = 4，k = 4的话，那么第一层for循环的时候，从元素2开始的遍历都没有意义了。 在第二层for循环，从元素3开始的遍历都没有意义了。
        //还需要的元素个数：a=(k-path.size())  当前还剩下的元素个数：b=(n-i+1) b>=a循环才有必要进行，即i<=n+path.size()-k
        for (int i = startIndex; i <= n + 1 + path.size() - k; i++) {
            path.add(i);
            backtracking(n, k, i + 1);//下个添加的数从i+1开始
            //回溯
            path.remove(path.size() - 1);
        }
/*        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i + 1);//下个添加的数从i+1开始
            //回溯
            path.remove(path.size() - 1);
        }*/
    }
}
