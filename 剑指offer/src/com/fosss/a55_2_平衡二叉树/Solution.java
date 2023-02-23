package com.fosss.a55_2_平衡二叉树;

/**
 * @author fosss
 * @date 2023/2/23
 * @description： 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树
 * 例：给定二叉树 [3,9,20,null,null,15,7] 返回true
 * 限制：0 <= 树的结点个数 <= 10000
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        Solution solution = new Solution();
        boolean res = solution.isBalanced(node1);
        System.out.println("res = " + res);
    }

    /**
     * 自解，获取左右子树深度，递归判断左右子树的深度差是否符合要求  53%  47%
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        //判断左右子树的深度差是否小于等于1
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1) {
            //继续判断子树的左右子树是否同时符合要求
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;

    }

    //获取子树最大深度（深度优先）
    private int getDepth(TreeNode root) {
        return root == null ? 0 : Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}




















