package com.fosss.a54_二叉搜索树的第k大节点;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author fosss
 * @date 2023/2/21
 * @description： 给定一棵二叉搜索树，请找出其中第 k 大的节点的值
 * 例：输入: root = [3,1,4,null,2], k = 1  输出：4
 * 限制：1 ≤ k ≤ 二叉搜索树元素个数
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        node1.left = node2;
        node2.right = node4;
        node1.right = node3;

        Solution solution = new Solution();
        int res = solution.kthLargest(node1, 3);
        System.out.println("res = " + res);
    }


    /**
     * 中序遍历
     */
    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        middle(root, list);
        //第k大，就是正数第（n-k）个数
        for (int i = 0; i < list.size(); i++) {
            if (list.size() - k == i) {
                return list.get(i);
            }
        }
        return -1;
    }

    private void middle(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            middle(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            middle(root.right, list);
        }
    }
}















