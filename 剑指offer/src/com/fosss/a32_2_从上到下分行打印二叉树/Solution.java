package com.fosss.a32_2_从上到下分行打印二叉树;

import java.util.*;

/**
 * @author fosss
 * @date 2023/1/25
 * @description： 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 例：给定二叉树: [3,9,20,null,null,15,7]  输出：[
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 思路：
 * 遍历树的思路和上一题一致，区别在于输出时需要分行，所以要将二叉树每一层分别存储到一个集合中，再将每一层的集合存储到结果集合中
 * 在while循环中，每一个for循环就是一层，所以将for循环中要存储的值放到一个集合中，for循环结束后，将集合存储到结果集合中
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int l = queue.size();//使用for循环来根据<最初>queue的大小规定循环的次数是关键!!注意提前记录下来，不能直接将queue.size()放到for判断条件中，因为queue的大小会变化
            for (int i = 0; i < l; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}




















