package com.fosss.kamaCoder.a_练习acm模式;

import java.util.*;

/**
 * 题目描述：
 * 给你一棵二叉树的前序遍历和中序遍历结果，要求你写出这棵二叉树的后序遍历结果。
 * 输入：输入包含多组测试数据。每组输入包含两个字符串，分别表示二叉树的前序遍历和中序遍历结果。每个字符串由不重复的大写字母组成。
 * 输出：对于每组输入，输出对应的二叉树的后续遍历结果。
 * 样例输入：
 * DBACEGF ABCDEFG
 * BCAD CBAD
 * 样例输出：
 * ACBFGED
 * CDAB
 */

public class B21_构造二叉树 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //前序数组，从左到右分别为子树根结点
            String preS = sc.next();
            //中序数组，根结点左右的字符分别位于左右子树
            String inorderS = sc.next();
            Map<Character, Integer> map = new HashMap<>();
            //方便从数组中获取位置，用map记录中序遍历
            for (int i = 0; i < inorderS.length(); i++) {
                map.put(inorderS.charAt(i), i);
            }
            //调用递归函数构造二叉树
            Node21 root = buildTree(map, preS, 0, preS.length() - 1, inorderS, 0, inorderS.length() - 1);
            //后序遍历
            postPrint(root);
        }
        sc.close();
    }

    public static Node21 buildTree(Map<Character, Integer> map, String preS, int preLeft, int preRight, String inorderS, int inorderLeft, int inorderRight) {
        //递归结束条件，每个字符都遍历完
        if (preLeft > preRight) return null;
        //构造根结点
        char v = preS.charAt(preLeft);
        Node21 root = new Node21(v);

        //分割中序列表
        int inLL = inorderLeft;
        int inLR = map.get(v) - 1;
        int inRL = map.get(v) + 1;
        int inRR = inorderRight;
        //分割前序列表
        int preLL = preLeft + 1;
        int size = inLR - inLL + 1;//左子树的长度
        int preLR = preLL + size - 1;
        int preRL = preLR + 1;
        int preRR = preRight;

        //构造左右子树
        root.left = buildTree(map, preS, preLL, preLR, inorderS, inLL, inLR);
        root.right = buildTree(map, preS, preRL, preRR, inorderS, inRL, inRR);
        return root;
    }

    public static void postPrint(Node21 root) {
        if (root == null) {
            //换行，不影响下次数据的输出
            System.out.println();
            return;
        }
        postPrint(root.left);
        postPrint(root.right);
        System.out.print(root.val);
    }
}

//节点类
class Node21 {
    char val;
    Node21 left;
    Node21 right;

    public Node21(char val) {
        this.val = val;
    }
}