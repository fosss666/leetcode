package a07_二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: fosss
 * Date: 2023/8/11
 * Time: 15:49
 * Description:
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 */
public class B25_二叉搜索树中的插入操作 {

    /**
     * 迭代法
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //树为空时，要插入的结点就是树的根结点
        if (root == null) return new TreeNode(val);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //根据val值的大小寻找它的位置
            if (node.val > val) {
                if (node.left != null) {
                    queue.add(node.left);
                } else {
                    //如果left为空，val就是那个新结点
                    node.left = new TreeNode(val);
                    break;
                }
            } else {
                if (node.right != null) {
                    queue.add(node.right);
                } else {
                    node.right = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

    /**
     * 递归法——结果始终是在结点的空子树插入结点，也就是不存在val构成的结点是别的结点的父结点
     */
    public TreeNode insertIntoBST2(TreeNode root, int val) {

        if (root == null) return new TreeNode(val);

        if (root.val > val) root.left = insertIntoBST2(root.left, val);
        if (root.val < val) root.right = insertIntoBST2(root.right, val);

        return root;
    }
}
