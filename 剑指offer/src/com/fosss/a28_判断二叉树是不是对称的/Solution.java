package com.fosss.a28_判断二叉树是不是对称的;

import java.util.ArrayList;
import java.util.List;

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
        boolean result = solution.isSymmetric(node1);
        System.out.println("result = " + result);
    }

    /**
     * 自解
     */
    public boolean isSymmetric(TreeNode root) {

        if(root==null){
            return true;
        }
        //先求出二叉树的对称，再进行比较
        List<Integer> rootList = new ArrayList<>();
        List<Integer> cloneRootList = new ArrayList<>();

        symmetry(root, rootList);
        getSymmetry(root);
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














