package com.fosss.a55_1_二叉树的深度;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author fosss
 * @date 2023/2/22
 * @description： 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度
 * 例：给定二叉树 [3,9,20,null,null,15,7] 返回最大深度3
 * 提示：节点总数 <= 10000
 * <p>
 * 思路：
 * 1.深度优先：
 * ① 以root==null为递归结束条件，返回0
 * ② 依次调用左子树递归和右子树递归，每次递归深度+1，返回较大的那个
 * 2.广度优先：
 * ① 创建记录深度的变量depth，初始化为0，对root进行非空判断，为空直接返回depth；
 * ② 利用队列记录每一层的节点，第一层放入root；
 * ③ 以队列不为空为while循环条件，每一个while循环代表一层，depth++，记录此时队列长度，遍历并将子树（下一层）加入队列；
 * ④ 循环结束后返回depth。
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
        int res = solution.maxDepth3(node1);
        System.out.println("res = " + res);
    }

    /**
     * 广度优先/层序遍历，使用队列  19.38%  84.95%
     */
    public int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxDepth = 0;
        while (queue.size() > 0) {
            maxDepth++;
            //注意一定要把此时此刻队列的大小提前定义出来！！！，因为在for循环中，队列会出入，队列大小会发生变化
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return maxDepth;
    }

    /**
     * 深度优先/后序遍历  100%  52.25%
     */
    public int maxDepth2(TreeNode root) {

        return root == null ? 0 : Math.max(maxDepth2(root.left) + 1, maxDepth2(root.right) + 1);

/*        if (root == null) {
            return 0;
        }
        //树的最大深度=左子树和右子树的最大深度+1
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;*/
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
            //递归结束要将count复原！
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














