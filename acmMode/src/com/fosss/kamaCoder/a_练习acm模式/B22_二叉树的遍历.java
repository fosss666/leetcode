package com.fosss.kamaCoder.a_练习acm模式;

import java.util.*;

/**
 * 题目描述：
 * 给出一个n个节点的二叉树，请求出二叉树的前序遍历，中序遍历和后序遍历。
 * 输入：第一位一个整数n(0<n<=26)，表示二叉树有n个节点，以下n行，每行第一个为一个大写字母表示节点，后面为两整数，第一个表示左儿子序号
 * 第二个表示右儿子序号，如果该序号为0表示没有。 (例如下面示例中，F序号为1，C序号为2，E序号为3，A序号为4，D序号为5，G序号为6，B序号为7)
 * 输出：共三行，第一行为二叉树的前序遍历，第二行为中序遍历，第三行为后序遍历
 * 样例输入：
 * 7
 * F 2 3
 * C 4 5
 * E 0 6
 * A 0 0
 * D 7 0
 * G 0 0
 * B 0 0
 * 样例输出：
 * FCADBEG
 * ACBDFEG
 * ABDCGEF
 */

public class B22_二叉树的遍历 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            //用数组存储数组节点,从1开始，0代表空节点
            Node22[] nodes = new Node22[n + 1];
            for (int i = 0; i < n; i++) {
                //每一行
                char c = sc.next().charAt(0);//字符
                int left = sc.nextInt();
                int right = sc.nextInt();
                nodes[i + 1] = new Node22(c, left, right);
            }
            preorder(nodes, 1);
            System.out.println();
            inorder(nodes, 1);
            System.out.println();
            postorder(nodes, 1);
        }
        sc.close();
    }

    //前序遍历
    public static void preorder(Node22[] nodes, int rootIndex) {
        if (rootIndex == 0) return;
        System.out.print(nodes[rootIndex].val);
        preorder(nodes, nodes[rootIndex].left);
        preorder(nodes, nodes[rootIndex].right);
    }

    //中序遍历
    public static void inorder(Node22[] nodes, int rootIndex) {
        if (rootIndex == 0) return;
        inorder(nodes, nodes[rootIndex].left);
        System.out.print(nodes[rootIndex].val);
        inorder(nodes, nodes[rootIndex].right);
    }

    //后序遍历
    public static void postorder(Node22[] nodes, int rootIndex) {
        if (rootIndex == 0) return;
        postorder(nodes, nodes[rootIndex].left);
        postorder(nodes, nodes[rootIndex].right);
        System.out.print(nodes[rootIndex].val);
    }
}

class Node22 {
    char val;
    int left;
    int right;

    public Node22(char val, int left, int right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}