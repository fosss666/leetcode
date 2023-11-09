package com.fosss.kamaCoder.a_练习acm模式;

import java.util.*;

/**
 * 题目描述：
 * 现给定一棵二叉树的先序遍历序列和中序遍历序列，要求你计算该二叉树的高度。
 * 输入：输入包含多组测试数据，每组输入首先给出正整数N（<=50），为树中结点总数。下面2行先后给出先序和中序遍历序列，均是长度为N的不包含重复英文字母（区别大小写）的字符串。
 * 输出：对于每组输入，输出一个整数，即该二叉树的高度。
 * 样例输入：
 * 9
 * ABDFGHIEC
 * FDHGIBEAC
 * 7
 * Abcdefg
 * gfedcbA
 * 样例输出：
 * 5
 * 7
 */

public class B23_二叉树的高度 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            String preS = sc.next();
            String inS = sc.next();
            //先构造二叉树
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < inS.length(); i++) map.put(inS.charAt(i), i);
            Node23 root = buildTree(map, preS, 0, preS.length() - 1, inS, 0, inS.length() - 1);
            //再获取高度
            int height = getHeight(root);
            System.out.println(height);

        }
        sc.close();
    }

    public static int getHeight(Node23 root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left) + 1, getHeight(root.right) + 1);
    }

    /**
     * 构造二叉树
     */
    public static Node23 buildTree(Map<Character, Integer> map, String preS, int preL, int preR, String inS, int inL, int inR) {
        if (preL > preR) return null;

        //获取根结点
        char rootVal = preS.charAt(preL);
        Node23 root = new Node23(rootVal);
        //分割中序数组
        int inLL = inL;
        int inLR = map.get(rootVal) - 1;
        int inRL = map.get(rootVal) + 1;
        int inRR = inR;
        //分割前序数组
        int lSize = inLR - inLL + 1; //左子树结点数
        int preLL = preL + 1;
        int preLR = preLL + lSize - 1;
        int preRL = preLR + 1;
        int preRR = preR;

        //设置左右子树
        root.left = buildTree(map, preS, preLL, preLR, inS, inLL, inLR);
        root.right = buildTree(map, preS, preRL, preRR, inS, inRL, inRR);

        return root;
    }

}

class Node23 {
    char val;
    Node23 left;
    Node23 right;

    public Node23(char val) {
        this.val = val;
    }
}
