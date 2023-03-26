package com.fosss.a32_1_从上到下打印二叉树;

import java.util.*;

/**
 * @author fosss
 * @date 2023/1/25
 * @description： 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例：给定二叉树: [3,9,20,null,null,15,7]  输出：[3,9,20,15,7]
 * 提示：节点总数 <= 1000
 * <p>
 * 思路：
 * 分层打印，想到借助辅助队列
 * 创建队列，将根节点放入到队列中，循环判断当队列不为空时，取得队列大小，for循环取出队列每个元素，将其值添加到集合中，将元素的子节点添加到队列中，
 * 以供树下一层遍历。最后将集合转为结果数组返回。
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
        int[] arr = solution.levelOrder(node1);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    /**
     * 自解，辅助队列
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        //用来装数值
        List<Integer> list = new ArrayList<>();
        //用来装结点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        function(list, queue);
        int[] arr = list.stream().mapToInt(x -> x).toArray();
        return arr;
    }

    private void function(List<Integer> list, Queue<TreeNode> queue) {
        TreeNode root = null;
        while (queue.size() > 0) {
            root = queue.poll();
            list.add(root.val);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
    }
}























