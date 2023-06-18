package com.fosss.a04_graph;

/**
 * @author: fosss
 * Date: 2023/6/18
 * Time: 19:07
 * Description:
 */
public class A_main {

    public static void main(String[] args) {
        char[] vertexes = {'1', '2', '3', '4', '5', '6'};
        int[][] adjacencyMatrix =
                {
                        {0, 1, 1, 1, 0, 0},
                        {1, 0, 0, 0, 1, 0},
                        {1, 0, 0, 0, 1, 0},
                        {1, 0, 0, 0, 0, 1},
                        {0, 1, 1, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0}
                };
        Graph graph = new Graph(vertexes, adjacencyMatrix);

        //深度优先
        //graph.graphDfs();

        //广度优先
        graph.graphBfs();
    }

}























