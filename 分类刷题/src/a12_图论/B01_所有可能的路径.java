package a12_图论;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/11/21
 * Time: 20:01
 * Description: https://leetcode.cn/problems/all-paths-from-source-to-target/description/
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 * graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 */
public class B01_所有可能的路径 {

    public static void main(String[] args) {
        B01_所有可能的路径 test = new B01_所有可能的路径();
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        test.allPathsSourceTarget(graph);
    }

    //保存所有符合条件的路径
    List<List<Integer>> res = new ArrayList<>();
    //保存单条路径
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //放入起点0
        path.add(0);
        dfs(graph, 0);
        return res;
    }

    public void dfs(int[][] graph, int startIndex) {
        //深搜结束条件
        if (startIndex == graph.length - 1) {
            //存储路径，注意要new一个，因为之后path这个变量还会被使用
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < graph[startIndex].length; i++) {
            path.add(graph[startIndex][i]);
            dfs(graph, graph[startIndex][i]);
            //回溯
            path.remove(path.size() - 1);
        }
    }
}
