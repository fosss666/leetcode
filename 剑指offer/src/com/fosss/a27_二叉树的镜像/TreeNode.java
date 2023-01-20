package com.fosss.a27_二叉树的镜像;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    /**
     * 前序遍历
     */
    public static void indexOrder(TreeNode node) {
        System.out.print(node.val + " ");
        if (node.left != null) {
            indexOrder(node.left);
        }
        if (node.right != null) {
            indexOrder(node.right);
        }
    }
}