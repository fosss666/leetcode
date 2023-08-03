package a07_二叉树.b04_二叉树的层序遍历;

/**
 * @author: fosss
 * Date: 2023/8/3
 * Time: 11:05
 * Description:
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 */
public class B06_另一棵树的子树 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //都为空说明相等，即subRoot是root的子树
        if (root == null && subRoot == null) return true;
        //root为空但subRoot不为空，说明不是子树
        if (root == null) return false;
        //subRoot可能是root（以root为根结点），可能是root的左子树，也可能是右子树
        return isSameTree(root, subRoot)
                || isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    /**
     * 判断两棵树是否相等
     */
    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        //都为空时相等
        if (root == null && subRoot == null) return true;
        //一个不为空或者值不同时不相等
        if (root == null || subRoot == null || root.val != subRoot.val) return false;
        //判断左子树和右子树
        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }
}
