package a07_二叉树.b04_二叉树的层序遍历;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: fosss
 * Date: 2023/8/3
 * Time: 18:53
 * Description:
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class B08_二叉树的最大深度 {

    /**
     * 递归法
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        //每次深度+1，返回左右子树中更深的深度
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }

    /**
     * 层序遍历法
     */
    public int maxDepth(TreeNode root) {
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
            }
        }
        return depth;
    }
}
