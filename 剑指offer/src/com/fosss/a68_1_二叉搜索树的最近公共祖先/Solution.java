package com.fosss.a68_1_二叉搜索树的最近公共祖先;

/**
 * @author: fosss
 * Date: 2023/3/8
 * Time: 10:03
 * Description:给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
 * （一个节点也可以是它自己的祖先）。”
 * 示例：输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8  输出: 6 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 说明：所有节点的值都是唯一的。 p、q 为不同节点且均存在于给定的二叉搜索树中。
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;

        Solution solution = new Solution();
        TreeNode res = solution.lowestCommonAncestor(node1, node2, node5);
        System.out.println("res = " + res.val);
    }

    /**
     * 递归         100%  41%
     * 利用二叉搜索树的性质
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            //向左子树递归
            return lowestCommonAncestor3(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor3(root.right, p, q);
        }
        return root;
    }

    /**
     * 迭代，提前判断pq的大小,从而简化后边的if判断        100%   42%
     * 利用二叉搜索树的性质
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //使p为较小的那个
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        while (root != null) {
            //q比p的值大，所以q.val<root.val,则一定p.val<root.val
            if (q.val < root.val) {
                //p和q都在公共祖先的左子树
                root = root.left;
            } else if (p.val > root.val) {
                //p和q都在公共祖先的右子树
                root = root.right;
            } else {
                //p和q再公共祖先的左右子树，此时的公共祖先是最近的
                break;
            }
        }
        return root;
    }

    /**
     * 迭代         100%   10%
     * 利用二叉搜索树的性质
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                //p和q都在公共祖先的左子树
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                //p和q都在公共祖先的右子树
                root = root.right;
            } else {
                //p和q再公共祖先的左右子树，此时的公共祖先是最近的
                break;
            }
        }
        return root;
    }
}

























