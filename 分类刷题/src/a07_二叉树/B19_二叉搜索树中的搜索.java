package a07_二叉树;

/**
 * @author: fosss
 * Date: 2023/8/9
 * Time: 18:30
 * Description:
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * 示例：
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 */
public class B19_二叉搜索树中的搜索 {

    /**
     * 迭代法-利用二叉搜索树的性质
     */
    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null) return null;
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                //向左找
                root = root.left;
            } else {
                //向右找
                root = root.right;
            }
        }
        //没找到
        return null;
    }

    /**
     * 递归法利用到二叉搜索树的性质
     */
    public TreeNode searchBST3(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        TreeNode res = null;
        //向左查找
        if (root.val > val) res = searchBST3(root.left, val);

        //向右查找
        if (root.val < val) res = searchBST3(root.right, val);

        return res;
    }

    /**
     * 前序遍历查找,普通二叉树的搜索方法
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode res = null;
        //向左查找
        if (root.left != null) res = searchBST3(root.left, val);

        //向右查找
        if (root.right != null) res = searchBST3(root.right, val);

        return res;

        /*
        //向左查找
        TreeNode left = searchBST(root.left, val);
        if (left != null) return left;
        //向右查找
        TreeNode right = searchBST(root.right, val);
        if (right != null) return right;

        return null;

         */
    }
}
