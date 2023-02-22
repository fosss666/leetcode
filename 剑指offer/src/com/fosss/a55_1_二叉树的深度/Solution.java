package com.fosss.a55_1_二叉树的深度;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author fosss
 * @date 2023/2/22
 * @description： 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度
 * 例：给定二叉树 [3,9,20,null,null,15,7] 返回最大深度3
 * 提示：节点总数 <= 10000
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
        int res = solution.maxDepth(node1);
        System.out.println("res = " + res);
    }


    /**
     * 自解， 集合记录深度 19.38%  97.51%
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        getMaxDepth(root, list);
        int max = -1;
        for (Integer integer : list) {
            if (integer > max) {
                max = integer;
            }
        }
        return max;
    }

    int count = 1;

    private void getMaxDepth(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            count++;
            getMaxDepth(root.left, list);
            count--;
        }
        if (root.right != null) {
            count++;
            getMaxDepth(root.right, list);
            count--;
        }
        list.add(count);
    }

}














