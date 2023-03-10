package com.fosss.a68_2_二叉树的最近公共祖先;

/**
 * @author: fosss
 * Date: 2023/3/10
 * Time: 9:12
 * Description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉树: root =[3,5,1,6,2,0,8,null,null,7,4]
 * 示例：
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 说明：
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中
 * <p>
 * 分析：
 * 若root为p和q的公共祖先，则必为一下情况之一
 * 1.p和q在root的子树中，且分列root的异侧（即分别在左右子树中）
 * 2.p=root,且q在root的左或右子树中
 * 3.q=root,且p在root的左或右子树中
 */
public class Solution {

    /**
     * 深度优先遍历       100%   78%
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归退出条件
        if (root == null) {
            return null;
        }
        if (root == p) {
            //p为公共祖先
            return p;
        }
        if (root == q) {
            //q为公共祖先
            return q;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //结果分为四种可能
        //1.如果都不为空，说明公共祖先为root
        if (left != null && right != null) {
            return root;
        }
        //2.如果left不为空，说明公共祖先为left
        if (left != null) {
            return left;
        }
        //3.如果right不为空，说明公共祖先为right
        if (right != null) {
            return right;
        }
        //4.如果都为空，说明没有公共祖先
        return null;
    }
}


























