package com.fosss.a55_2_平衡二叉树;

/**
 * @author fosss
 * @date 2023/2/23
 * @description： 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树
 * 例：给定二叉树 [3,9,20,null,null,15,7] 返回true
 * 限制：0 <= 树的结点个数 <= 10000
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        Solution solution = new Solution();
        boolean res = solution.isBalanced(node1);
        System.out.println("res = " + res);
    }

    /**
     * k神，后序遍历+剪枝（从底至顶）  100%  61%
     */
    public boolean isBalanced2(TreeNode root) {
        return dfs(root) != -1;
    }

    //用left，right记录root左右子节点的深度，避免遍历root时对左右节点的深度进行重复计算。
    //考虑到需要同时记录各个节点的深度和其是否符合平衡性要求，这里的返回值设为int,用一个特殊值-1来表示出现不平衡的节点的情况，而不是一般采用的boolean
    public int dfs(TreeNode root) {
        //用后序遍历的方式遍历二叉树的每个节点（从底至顶）,先左子树，再右子树，最后根节点，
        if (root == null) return 0;//root等于0时，该节点符合要求，返回其深度0，而不返回-1；
        int left = dfs(root.left);//left最开始的取值为0，从底朝上遍历，先左子树，后右子树，最后根节点
        if (left == -1) return -1;//若出现节点的深度为-1，则进行剪枝，开始向上返回，之后的迭代不再进行
        int right = dfs(root.right);
        if (right == -1) return -1;
        return Math.abs(right - left) < 2 ? Math.max(left, right) + 1 : -1;//+1不能少
        //最开始计算的是左子树最左侧的一个叶节点，其左右子节点不存在，left=0，right=0，满足条件，返回该叶节点的深度max(0,0)+1=1;
    }

    /**
     * 自解，获取左右子树深度，递归判断左右子树的深度差是否符合要求  53%  47%
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        //判断左右子树的深度差是否小于等于1
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1) {
            //继续判断子树的左右子树是否同时符合要求
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;

    }

    //获取子树最大深度（深度优先）
    private int getDepth(TreeNode root) {
        return root == null ? 0 : Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}




















