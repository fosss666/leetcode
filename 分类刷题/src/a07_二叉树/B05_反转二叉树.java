package a07_二叉树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: fosss
 * Date: 2023/8/2
 * Time: 18:35
 * Description:
 * 翻转一棵二叉树。
 */
public class B05_反转二叉树 {

    /**
     * 前序遍历-迭代法统一写法
     */
    public TreeNode invertTree5(TreeNode root) {
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                //做个标记
                stack.push(node);
                stack.push(null);

                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            } else {
                TreeNode node2 = stack.pop();
                TreeNode temp = node2.left;
                node2.left = node2.right;
                node2.right = temp;
            }
        }

        return root;
    }

    /**
     * 前序遍历-迭代法
     */
    public TreeNode invertTree4(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return root;
    }

    /**
     * 后序遍历
     */
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return null;

        invertTree3(root.left);
        invertTree3(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        return root;
    }

    /**
     * 递归-前序遍历
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree2(root.left);
        invertTree2(root.right);
        return root;
    }

    /**
     * 辅助队列  交换左右子树
     */
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return null;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return root;
    }
}
