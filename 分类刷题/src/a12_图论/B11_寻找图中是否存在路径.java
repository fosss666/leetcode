package a12_图论;

/**
 * @author: fosss
 * Date: 2023/12/4
 * Time: 22:50
 * Description: https://leetcode.cn/problems/find-if-path-exists-in-graph/description/
 * 有一个具有 n个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。图中的边用一个二维整数数组 edges 表示，其中
 * edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。 每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。
 * 请你确定是否存在从顶点 start 开始，到顶点 end 结束的 有效路径 。
 * 给你数组 edges 和整数 n、start和end，如果从 start 到 end 存在 有效路径 ，则返回 true，否则返回 false 。
 */
public class B11_寻找图中是否存在路径 {
    /**
     * 并查集基础题目，只要在并查集模板上修改n就行
     */
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        init(n);//初始化
        //添加边
        for (int i = 0; i < edges.length; i++) {
            join(edges[i][0], edges[i][1]);
        }
        return isSame(source, destination);
    }

    //以下是并查集模板
    int[] father;

    //并查集初始化，每个顶点的根初始化为自己
    private void init(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) father[i] = i;
    }

    //并查集寻找顶点的根
    private int find(int u) {
        if (father[u] == u) {
            return u;
        } else {
            //在递归的过程中，让 father[u] 接住 递归函数 find(father[u]) 的返回结果，从而实现路径压缩
            father[u] = find(father[u]);
            return father[u];
        }
    }

    //判断根是否相同，即是否在同一个集合中
    private boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    //将u-v这条边进行添加
    private void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;//根相同
        //否则添加边
        father[v] = u;
    }
}
