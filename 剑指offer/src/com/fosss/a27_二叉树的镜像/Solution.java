package com.fosss.a27_二叉树的镜像;

/**
 * @author fosss
 * @date 2023/1/20
 * @description： 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;

        Solution solution = new Solution();
        System.out.println("原来的树：");
        TreeNode.indexOrder(node1);
        System.out.println("\n现在的树：");
        TreeNode treeNode = solution.mirrorTree(node1);
        TreeNode.indexOrder(treeNode);

    }

    /**
     * 递归!!
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //暂时存储root的左子节点
        TreeNode left = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(left);
        return root;
    }

}










