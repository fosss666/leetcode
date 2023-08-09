package a07_二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: fosss
 * Date: 2023/8/9
 * Time: 15:36
 * Description:
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树
 * 的节点。
 * 示例：
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 */
public class B18_合并二叉树 {

    /**
     * 迭代法
     */
    public TreeNode mergeTrees3(TreeNode root1, TreeNode root2) {
        //过滤单树为空的情况
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(root2);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            //合并
            node1.val += node2.val;

            //如果左子树都不为空，放入队列
            if (node1.left != null && node2.left != null) {
                queue.add(node1.left);
                queue.add(node2.left);
            } else {
                //如果一个为空，设置为另一个
                node1.left = node1.left == null ? node2.left : node1.left;
            }
            //如果右子树都不为空，放入队列
            if (node1.right != null && node2.right != null) {
                queue.add(node1.right);
                queue.add(node2.right);
            } else {
                node1.right = node1.right == null ? node2.right : node1.right;
            }
        }
        return root1;
    }

    /**
     * 递归简化版---优雅
     */
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root1.val += root2.val;
        root1.left = mergeTrees2(root1.left, root2.left);
        root1.right = mergeTrees2(root1.right, root2.right);
        return root1;
    }

    /**
     * 前序遍历，先构建根结点，再构建左右子树
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        //创建结点
        TreeNode root;
        if (root1 == null) {
            root = root2;
        } else if (root2 == null) {
            root = root1;
        } else {
            root = new TreeNode(root1.val + root2.val);
        }

        //构建左右子树
        //注意避免root1、root2为空的情况（空指针），取不到left和right
        root.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        root.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);

        return root;
    }
    /*
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return buildTree(root1, root2);
    }

    private TreeNode buildTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        //创建结点
        TreeNode root;
        if (root1 == null) {
            root = root2;
        } else if (root2 == null) {
            root = root1;
        } else {
            root = new TreeNode(root1.val + root2.val);
        }

        //构建左右子树
        //注意避免root1、root2为空的情况（空指针），取不到left和right
        root.left = buildTree(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        root.right = buildTree(root1 == null ? null : root1.right, root2 == null ? null : root2.right);

        return root;
    }

     */
}












