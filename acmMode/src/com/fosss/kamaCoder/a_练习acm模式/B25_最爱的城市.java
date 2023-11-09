package com.fosss.kamaCoder.a_练习acm模式;

import java.util.*;

/**
 * 题目描述：
 * 一天小明捧着一本世界地图在看，突然小明拿起笔，将他最爱的那些城市标记出来，并且随机的将这些城市中的某些用线段两两连接起来。
 * 小明量出了每条线段的长度，现在小明想知道在这些线段组成的图中任意两个城市之间的最短距离是多少。
 * 输入：输入包含多组测试数据。
 * 每组输入第一行为两个正整数n（n<=10）和m（m<=n*(n-1)/2），n表示城市个数，m表示线段个数。
 * 接下来m行，每行输入三个整数a，b和l，表示a市与b市之间存在一条线段，线段长度为l。（a与b不同）
 * 每组最后一行输入两个整数x和y，表示问题：x市与y市之间的最短距离是多少。（x与y不同）
 * 城市标号为1~n，l<=20。
 * 输出：对于每组输入，输出x市与y市之间的最短距离，如果x市与y市之间非连通，则输出“No path”。
 * 样例输入：
 * 4 4
 * 1 2 4
 * 1 3 1
 * 1 4 1
 * 2 3 1
 * 2 4
 * 样例输出：
 * 3
 */

public class B25_最爱的城市 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //城市个数
            int n = sc.nextInt();
            //线段个数
            int m = sc.nextInt();
            //用二维数组记录,graph[i][j]表示i和j之间的距离，用int最大值表示不连通
            int[][] graph = new int[n + 1][n + 1];
            //初始化为各自都不连通
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
            //下面的m行记录更新城市之间的距离关系，注意距离是双向的
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int distance = sc.nextInt();
                graph[a][b] = distance;
                graph[b][a] = distance;
            }
            //下面一行表示要求哪两个城市之间的距离
            int x = sc.nextInt();
            int y = sc.nextInt();
            //记录城市i是否访问过
            boolean[] isVisited = new boolean[n + 1];
            //sum记录最小距离
            //查找距离
            int res = dfs(graph, isVisited, x, y, 0);
            if (res == Integer.MAX_VALUE) {
                System.out.println("No path");
            } else {
                System.out.println(res);
            }
        }
        sc.close();
    }

    //深度优先dfs，还可以用其他最短距离求法，如弗洛依达、迪杰斯特拉等，但本题目的是练习输入输出，其他解法在图论中会学到
    public static int dfs(int[][] graph, boolean[] isVisited, int start, int end, int sum) {
        if (start == end) return sum;//搜索完毕
        //标记当前start已经访问过
        isVisited[start] = true;
        //记录距离最小值
        Integer min = Integer.MAX_VALUE;
        //深搜，遍历与start相通的城市
        for (int i = 1; i < graph[start].length; i++) {
            //start和i相通且i没有被访问过
            if (graph[start][i] != Integer.MAX_VALUE && !isVisited[i]) {
                //标记已访问
                isVisited[i] = true;
                sum += graph[start][i];
                int res = dfs(graph, isVisited, i, end, sum);
                if (res != Integer.MAX_VALUE) {
                    //找到了x到y相通的路，更新一下最短距离
                    min = Math.min(min, res);
                }
                //回溯
                sum -= graph[start][i];
                isVisited[i] = false;
            }
        }
        return min;
    }
}