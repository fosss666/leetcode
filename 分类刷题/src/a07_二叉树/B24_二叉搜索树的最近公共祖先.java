package a07_二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: fosss
 * Date: 2023/8/11
 * Time: 15:00
 * Description:
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class B24_二叉搜索树的最近公共祖先 {

    /**
     * 普通二叉树寻找最近公共祖先时是从左右子树遍历挨个寻找的，对于二叉搜索树，可以根据要搜索的结点的值确定是要从左子树合适右子树寻找
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = null;
        TreeNode right = null;

        //回溯过程中由底向上，所以找到的公共祖先是最深的那个
        if (root.val > p.val && root.val > q.val) {
            //都比root大，说明都在右子树，向右找
            left = lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            //都比root小，说明都在左子树，向左找
            right = lowestCommonAncestor(root.right, p, q);
        } else {
            //一左一右，此时root就是最近的公共祖先
            return root;
        }
        //程序走到这里，说明要不就是没有公共祖先，要不就是公共祖先是p或q，否则就已经在else中返回了
        //也可以分别在if、else if中返回非空
        if (left != null) return left;
        return right;
    }

    /**
     * 递归精简
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        //这样不好理解
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor2(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor2(root.right, p, q);
        } else return root;


        /*
        if (root.val > p.val && root.val > q.val) {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            //找到即返回
            if (left != null) return left;
        }
        if (root.val < p.val && root.val < q.val) {
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            //找到即返回
            if (right != null) return right;
        }
        return root;
        */
    }

    /**
     * 迭代法——似乎更容易理解
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val > p.val && node.val > q.val) {
                queue.add(node.left);
            } else if (node.val < p.val && node.val < q.val) {
                queue.add(node.right);
            } else {
                return node;
            }
        }
        return null;
    }
}
