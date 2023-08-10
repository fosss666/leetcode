package a07_二叉树;

/**
 * @author: fosss
 * Date: 2023/8/10
 * Time: 19:59
 * Description:
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
 * （一个节点也可以是它自己的祖先）。”
 * 示例：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 */
public class B23_二叉树的最近公共祖先 {
    /**
     * 两个结点的公共祖先有三种情况，要不其中一个结点是另一个结点的子树，要不两个结点分别是祖先的左右子树
     * 后序遍历，从左子树和右子树中找两个值，找到就返回
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;//没有符合的结点返回空，或者找到了某个结点，就将其返回

        //向左子树找
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //向右子树找
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //如果left和right都不为空，则root为公共祖先；某个为空，则另一个为公共祖先
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            //都为空，说明没有公共祖先
            return null;
        }
    }
}
