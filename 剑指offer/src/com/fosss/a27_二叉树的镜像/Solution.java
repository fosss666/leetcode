package com.fosss.a27_二叉树的镜像;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fosss
 * @date 2023/1/20
 * @description： 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 思考：
 * 镜像即左右子树交换
 * 1.辅助栈（队列、集合），将root结点放到栈中，当栈不为空时，弹出结点，（将结点的左右结点放入栈），将结点的左右结点交换
 * 2.递归，root==null 为退出条件，暂时存储左结点（或右节点），将左结点赋值为递归右结点。将右结点赋值为递归暂存结点，返回root
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
     * 使用集合或栈或队列,将每棵树的左右子树进行交换
     */
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) return null;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode node = list.remove(0);
            if (node.left != null) list.add(node.left);
            if (node.right != null) list.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
        //if (root == null) return null;
        //Stack<TreeNode> stack = new Stack<>();
        //stack.push(root);
        //while (!stack.isEmpty()) {
        //    TreeNode node = stack.pop();
        //    if (node.left != null) stack.add(node.left);
        //    if (node.right != null) stack.add(node.right);
        //    TreeNode tmp = node.left;
        //    node.left = node.right;
        //    node.right = tmp;
        //}
        //return root;
    }


    /**
     * 递归!!
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //！！暂时存储root的左子节点：再递归右子节点后，root.left值已经发生改变
        TreeNode left = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(left);
        return root;
    }

}










