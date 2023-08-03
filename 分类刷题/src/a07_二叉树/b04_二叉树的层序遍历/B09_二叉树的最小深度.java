package a07_二叉树.b04_二叉树的层序遍历;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: fosss
 * Date: 2023/8/3
 * Time: 19:01
 * Description:
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class B09_二叉树的最小深度 {

    /**
     * 递归法
     */
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth2(root.left);
        int right = minDepth2(root.right);

        //精简一下，当左为空或右为空时，为空的那个的深度为0，所以用left+right+1可以表示某一个的深度+1
        //如果左子树为空，右子树不为空，说明最小深度是 1 + 右子树的深度。
        //反之，右子树为空，左子树不为空，最小深度是 1 + 左子树的深度。
        //最后如果左右子树都不为空，返回左右子树深度最小值 + 1
        return (root.left == null || root.right == null) ? left + right + 1 : Math.min(left, right) + 1;

        /*
        //如果左子树为空，右子树不为空，说明最小深度是 1 + 右子树的深度。
        //反之，右子树为空，左子树不为空，最小深度是 1 + 左子树的深度。
        if (root.left == null && root.right != null) return right + 1;
        if (root.right == null && root.left != null) return left + 1;
        //最后如果左右子树都不为空，返回左右子树深度最小值 + 1
        return Math.min(left, right) + 1;
        */
    }

    /**
     * 层序遍历法
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            depth++;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                //一个结点左右子树都为空时，为叶子结点，遇到叶子结点后直接返回此时的深度
                if (node.left == null && node.right == null) {
                    return depth;
                }
            }
        }
        return depth;
    }
}
