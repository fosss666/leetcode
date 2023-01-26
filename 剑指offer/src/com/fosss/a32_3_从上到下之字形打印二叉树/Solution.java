package com.fosss.a32_3_从上到下之字形打印二叉树;

import java.util.*;

/**
 * @author fosss
 * @date 2023/1/26
 * @description： 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推
 * 例：给定二叉树: [3,9,20,null,null,15,7]  输出：[
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.levelOrder(node1);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    /**
     * 自解，辅助队列，LinkedList，取模
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //用来分单双层
        int index = 1;
        while (!queue.isEmpty()) {
            //保存当前层的元素
            LinkedList<Integer> list = new LinkedList<>();
            //记录当前队列的长度
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (index % 2 == 1) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            index++;

            result.add(list);
        }
        return result;
    }
}



















