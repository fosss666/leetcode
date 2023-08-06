package a07_二叉树;

/**
 * @author: fosss
 * Date: 2023/8/6
 * Time: 18:26
 * Description:
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7] 返回：true
 */
public class B09_平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        return getHeight(root)!=-1;
    }
    //比较左右子树高度，如果返回-1说明高度之差>1，即不是平衡二叉树
    private int getHeight(TreeNode root){
        if(root == null ) return 0;
        //求左子树高度
        int left=getHeight(root.left);
        //注意判断高度是否为-1很关键，高度为-1说明已经得知该树不是平衡二叉树了，由于不是二叉树应该最终返回-1，所以应该在判断到不是的时候直接
        //返回，而不是让他去执行比较高度差的操作，如果left=right=-1时，比较高度差的判断条件不符合，就会执行后面的返回 max+1，结果就不是-1了,
        //然后恶行循环，后边的递归回溯时返回的值就越来越大，最终不可能返回-1，就不能实现所需效果了
        if(left==-1) return -1;
        //求右子树高度
        int right=getHeight(root.right);
        if(right==-1) return -1;
        //比较高度差
        if(Math.abs(left-right)>1) return -1;
        //不是-1则返回最大高度
        return Math.max(left,right)+1;
    }
}
