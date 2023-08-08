package a07_二叉树;

/**
 * @author: fosss
 * Date: 2023/8/8
 * Time: 16:42
 * Description:
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class B13_路径总和 {

    /**
     * 递归精简版
     */
    public boolean hasPathSum2(TreeNode root,int targetSum){
        if(root==null) return false;
        if(root.left==null&&root.right==null&&(targetSum-root.val==0)) return true;
        return hasPathSum2(root.left,targetSum-root.val)||hasPathSum2(root.right,targetSum-root.val);
    }

    /**
     * 递归
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        return exist(root,targetSum);
    }

    private boolean exist(TreeNode root,int targetSum){
        if(root.left==null&&root.right==null){
            //到达叶子结点，判断是否存在
            return targetSum - root.val == 0;
        }
        boolean left=false;
        boolean right=false;
        if(root.left!=null){
            //判断左子树中是否存在，如果存在直接返回true
            left=exist(root.left,targetSum-root.val);
            if(left) return true;
        }
        if(root.right!=null){
            //判断右子树中是否存在，如果存在直接返回true
            right=exist(root.right,targetSum-root.val);
            if(right) return true;
        }
        //不存在
        return false;
    }
}
