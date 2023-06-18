package com.fosss.a04_graph;

import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * 广度优先遍历
     */
    public void graphBfs() {
        bfs(0);
    }

    private void bfs(int index) {
        //借助队列
        Queue<Integer> queue = new LinkedList<>();
        //加入队列
        queue.add(index);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                Integer poll = queue.poll();
                //未访问
                if(isVisited[poll]==0) {
                    //设置为已访问
                    isVisited[poll] = 1;
                    //输出
                    System.out.print(vertexes[poll] + " ");

                    //将未访问过的邻接点入队
                    for (int j = 0; j < adjacencyMatrix[poll].length; j++) {
                        if (adjacencyMatrix[poll][j] == 1 && isVisited[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
            }
        }
    }
}























