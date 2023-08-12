package a07_二叉树;

/**
 * @author: fosss
 * Date: 2023/8/12
 * Time: 18:03
 * Description:
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于
 * node.val 的值之和。
 * 提醒一下，二叉搜索树满足下列约束条件：
 * 节点的左子树仅包含键 小于 节点键的节点。 节点的右子树仅包含键 大于 节点键的节点。 左右子树也必须是二叉搜索树。
 * 示例：
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 */
public class B29_将二叉搜索树转换为累加树 {

    /**
     * 题意：每个结点值变成从下向上，从右向左递加
     * 按照右中左的顺序遍历，将每次遍历到的结点值改为加上上一个结点值的数，用pre记录上一个结点
     */
    public TreeNode convertBST(TreeNode root) {
        reverseInorder(root);
        return root;
    }

    TreeNode pre = null;

    private void reverseInorder(TreeNode root) {
        if (root == null) return;
        //右
        reverseInorder(root.right);
        //中
        if (pre != null) root.val += pre.val;
        pre = root;

        //左
        reverseInorder(root.left);
    }

    /**
     * 迭代法，可以用中序遍历的普通方式或者统一方式，在遍历到中结点时用`if (pre != null) root.val += pre.val;pre = root;`这个逻辑就行了
     */
}

