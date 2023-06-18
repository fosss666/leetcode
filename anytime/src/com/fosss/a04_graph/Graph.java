package com.fosss.a04_graph;

/**
 * @author: fosss
 * Date: 2023/6/18
 * Time: 19:11
 * Description: 数据结构图
 */
public class Graph {
    /**
     * 顶点
     */
    public char[] vertexes;
    /**
     * 邻接矩阵，标记顶点间的关系
     */
    public int[][] adjacencyMatrix;

    /**
     * 顶点数
     */
    public int vertexCount;

    /**
     * 边数
     */
    public int edgeCount = 0;

    /**
     * 标记某个顶点是否被访问过 1:访问了 0：没访问
     */
    public int[] isVisited;

    //构造方法
    public Graph(char[] vertexes, int[][] adjacencyMatrix) {
        this.vertexes = vertexes;
        this.adjacencyMatrix = adjacencyMatrix;
        this.vertexCount = vertexes.length;
        for (int[] matrix : adjacencyMatrix) {
            for (int i : matrix) {
                if (i == 1) {
                    this.edgeCount++;
                }
            }
        }
        isVisited = new int[this.vertexCount];
    }

    /**
     * 深度优先遍历，类似于树的前序遍历
     */
    public void graphDfs() {
        dfs(0);
    }

    private void dfs(int index) {
        //标记一下该顶点已经访问过
        isVisited[index] = 1;
        System.out.print(vertexes[index] + " ");
        for (int i = 0; i < adjacencyMatrix[index].length; i++) {
            //相连且未被访问
            if (adjacencyMatrix[index][i] == 1 && isVisited[i] == 0) {
                dfs(i);
            }
        }
    }
}























