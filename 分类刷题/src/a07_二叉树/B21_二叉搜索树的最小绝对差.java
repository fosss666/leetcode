package a07_二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: fosss
 * Date: 2023/8/10
 * Time: 15:07
 * Description:
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 */
public class B21_二叉搜索树的最小绝对差 {

    /**
     * 递归法-中序遍历得到数组，然后遍历数组求最小绝对差
     */
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            //有序数组中，最小绝对差绝对是两个相邻数产生的
            int i1 = list.get(i) - list.get(i - 1);
            if (i1 < min) min = i1;
        }
        return min;
    }

    List<Integer> list = new ArrayList<>();

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    /**
     * 在中序遍历过程中找最小绝对差——最佳方案
     */
    public int getMinimumDifference2(TreeNode root) {
        recursion(root);
        return min;
    }

    //存储最小绝对值差
    int min = Integer.MAX_VALUE;
    //用一个前驱节点
    TreeNode pre = null;

    private void recursion(TreeNode root) {
        if (root == null) return;
        recursion(root.left);
        if (pre != null && root.val - pre.val < min) min = root.val - pre.val;
        //更新pre
        pre = root;
        recursion(root.right);
    }

    /**
     * 迭代法-一般中序遍历
     */
    public int getMinimumDifference3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;

        int res = Integer.MAX_VALUE;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (pre != null) res = Math.min(res, cur.val - pre.val);
                pre = cur;

                //右
                cur = cur.right;
            }
        }
        return res;
    }

    /**
     * 迭代法-统一迭代法
     */
    public int getMinimumDifference4(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        stack.push(root);
        int res = Integer.MAX_VALUE;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) stack.push(node.right);
                stack.push(node);
                stack.push(null);
                if (node.left != null) stack.push(node.left);
            } else {
                node = stack.pop();
                if (pre != null) res = Math.min(res, node.val - pre.val);
                pre = node;
            }
        }
        return res;
    }
}
