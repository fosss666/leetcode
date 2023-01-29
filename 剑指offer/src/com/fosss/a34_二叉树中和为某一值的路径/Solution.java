package com.fosss.a34_二叉树中和为某一值的路径;

import java.util.*;

/**
 * @author fosss
 * @date 2023/1/29
 * @description： 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点
 * 例：输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22  输出：[[5,4,11,2],[5,8,4,5]]
 * 输入：root = [1,2], targetSum = 0  输出：[]
 * 提示：
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node;
        root.right = node2;
        node2.left = new TreeNode(4);

        Solution solution = new Solution();
        for (List<Integer> integers : solution.pathSum(root, 8)) {
            System.out.println(integers);
        }

    }

    /**
     * 回溯法
     */
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> stack = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return res;
    }

    //回溯
    void recur(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        stack.add(root.val);

        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            //值得注意的是，记录路径时若直接执行 res.append(path) ，则是将 path 对象加入了 res ；后续 path 改变时， res 中的 path 对象也会随之改变。
            //正确做法：res.append(list(path)) ，相当于复制了一个 path 并加入到 res
            res.add(new LinkedList<>(stack));
        }
        recur(root.left, target);
        recur(root.right, target);
        //向上回溯前，需要将当前结点从路径中删除!!!
        stack.removeLast();
    }

}















































