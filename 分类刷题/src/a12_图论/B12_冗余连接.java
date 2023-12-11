package a12_图论;

/**
 * @author: fosss
 * Date: 2023/12/11
 * Time: 19:27
 * Description: https://leetcode.cn/problems/redundant-connection/
 * 树可以看成是一个连通且 无环 的 无向 图。
 * 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。
 * 图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的边。
 */
public class B12_冗余连接 {

    /**
     * 并查集
     * 树的所有节点只有一个根结点，所以遍历每一条边，如果根结点不同，则添加两个节点之间的边；否则，说明再添加这条边的话，必定成环。
     * 如果题目要求有多个答案就返回最先出现的边，则逆序遍历edges
     */
    public int[] findRedundantConnection(int[][] edges) {
        init(edges.length);
        for (int i = 0; i < edges.length; i++) {
            if (isSame(edges[i][0], edges[i][1])) {
                return edges[i];
            } else {
                join(edges[i][0], edges[i][1]);
            }
        }
        return null;
    }

    //并查集模板
    int[] father;

    private void init(int n) {
        father = new int[n + 1];
        for (int i = 0; i < n; i++) father[i] = i;
    }

    //找根结点
    private int find(int u) {
        if (father[u] == u) return u;
        father[u] = find(father[u]);
        return father[u];
    }

    //判断根结点是否相同
    private boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    //插入边
    private void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        father[v] = u;
    }
}
