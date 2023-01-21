package com.fosss.a28_判断二叉树是不是对称的;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author fosss
 * @date 2023/1/21
 * @description：
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        //TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        //TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        //node2.left = node4;
        node2.right = node5;
        //node3.left = node6;
        node3.right = node7;

        Solution solution = new Solution();
        boolean result = solution.isSymmetric2(node1);
        System.out.println("result = " + result);
    }

        /**
     * 递归判断左右子树是否相等
     */
    public boolean isSymmetric2(TreeNode root) {
        return judgment(root, root);
    }

    private boolean judgment(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return judgment(root1.left, root2.right) && judgment(root1.right, root2.left);
    }

    /**
     * 自解，构造镜像树
     */
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        //先求出二叉树的对称，再进行比较
        List<Integer> rootList = new ArrayList<>();
        List<Integer> cloneRootList = new ArrayList<>();
        //获取二叉树的元素
        symmetry(root, rootList);
        //镜像
        getSymmetry(root);
        //获取二叉树的元素
        symmetry(root, cloneRootList);

        for (int i = 0; i < rootList.size(); i++) {
            if (!rootList.get(i).equals(cloneRootList.get(i))) {
                return false;
            }
        }
        return true;
    }

    //获得镜像树
    private static void getSymmetry(TreeNode cloneRoot) {
        List<TreeNode> list = new ArrayList<>();
        list.add(cloneRoot);
        while (!list.isEmpty()) {
            TreeNode node = list.remove(0);
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }

    private static void symmetry(TreeNode root, List<Integer> list) {
        list.add(root.val);
        if (root.left != null) {
            symmetry(root.left, list);
        } else {
            //左子树为空，右子树不为空
            if (root.right != null) {
                symmetry(new TreeNode(-1), list);
            }
        }
        if (root.right != null) {
            symmetry(root.right, list);
        }

    }

}














