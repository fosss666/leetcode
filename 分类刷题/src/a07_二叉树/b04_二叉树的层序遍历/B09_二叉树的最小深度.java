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
     * 层序遍历法，递归法在下面再遇到这个题时再写
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
