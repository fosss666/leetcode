package a07_二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: fosss
 * Date: 2023/8/2
 * Time: 20:52
 * Description:
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class B06_对称二叉树 {

    /**
     * 队列或栈
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        //也可以用栈，直接改成栈就行，代码逻辑一样
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) continue;//是对称的，进入下一个判断
            if (node1 == null || node2 == null || node1.val != node2.val) return false;

            //每次弹出两个结点，所以添加时要分别添加对称的两个结点
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }

    /**
     * 递归
     */
    public boolean isSymmetric(TreeNode root) {
        //root为空直接是轴对称的
        return root == null || recursion(root.left, root.right);
    }

    private boolean recursion(TreeNode left, TreeNode right) {
        //是轴对称的情况：左子树和右子树同为空
        if (left == null && right == null) return true;
        //非轴对称的情况：1.左右子树只有一个为空 2.左右结点值不同
        if (left == null || right == null || left.val != right.val) return false;
        //递归判断：对左子树的左结点和右子树的右结点以及左子树的右结点和右子树的左结点分别判断
        return recursion(left.left, right.right) && recursion(left.right, right.left);
    }
}
