package a07_二叉树;

import java.util.Stack;

/**
 * @author: fosss
 * Date: 2023/8/7
 * Time: 17:04
 * Description:
 * 计算给定二叉树的所有左叶子之和。
 * 节点A的左孩子不为空，且左孩子的左右孩子都为空（说明是叶子节点），那么A节点的左孩子为左叶子节点
 */
public class B11_左叶子之和 {

    /**
     * 前序遍历
     */
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        getLeftLeafCount(root);
        return sum;
    }
    private void getLeftLeafCount(TreeNode root){
        if(root==null) return;
        if(root.left!=null){
            //判断是否是左叶子
            if(root.left.left==null&&root.left.right==null) sum+=root.left.val;
            getLeftLeafCount(root.left);
        }
        if(root.right!=null) getLeftLeafCount(root.right);
    }
    /**
     * 迭代法-前序遍历 （中左右）
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        if(root==null) return 0;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        int sum=0;
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null){
                //判断是否是左叶子
                if(node.left.left==null&&node.left.right==null) sum+=node.left.val;
                stack.push(node.left);
            }
        }
        return sum;
    }

}
