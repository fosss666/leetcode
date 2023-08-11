package a07_二叉树;

/**
 * @author: fosss
 * Date: 2023/8/11
 * Time: 17:44
 * Description:
 * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
 */
public class B27_修剪二叉搜索树 {

    /**
     * 递归法
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        //如果根结点值小于low，向右递归
        //防止root在左边界左侧，而root的右子树在边界内
        if (root.val < low) {
            TreeNode right = trimBST(root.right, low, high);
            return right;
        }
        //如果根结点值大于high，向左递归
        //防止root在右边界右侧，而root的左子树在边界内
        if (root.val > high) {
            TreeNode left = trimBST(root.left, low, high);
            return left;
        }

        //拼接左右子树
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }

    /**
     * 迭代法
     */
    public TreeNode trimBST2(TreeNode root, int low, int high) {
        if (root == null) return null;
        //将root先移动到[low,high]之间
        //注意必须在一个循环中，才能去除所有边界外的结点，如果用两个循环会导致一些子树无法判断到，链表才可以才有那种方式
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low)
                root = root.right;
            else
                root = root.left;
        }

        //处理root的左子树中小于low的结点
        TreeNode cur = root;
        while (cur != null) {
            //这里要循环，因为不一定移动一次cur.left就不小于low了
            while (cur.left != null && cur.left.val < low) cur.left = cur.left.right;
            cur = cur.left;
        }
        //处理root的右子树中大于high的结点
        cur = root;
        while (cur != null) {
            //这里要循环，因为不一定移动一次cur.left就不小于low了
            while (cur.right != null && cur.right.val > high) cur.right = cur.right.left;
            cur = cur.right;
        }
        return root;
    }
}
