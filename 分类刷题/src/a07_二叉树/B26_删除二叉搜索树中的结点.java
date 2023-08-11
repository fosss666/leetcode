package a07_二叉树;

/**
 * @author: fosss
 * Date: 2023/8/11
 * Time: 16:50
 * Description:
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点； 如果找到了，删除它。 说明： 要求算法时间复杂度为 $O(h)$，h 为树的高度。
 */
public class B26_删除二叉搜索树中的结点 {

    /**
     * 要进行删除操作，所以要找到删除结点的父结点
     * 分析要删除的结点的左右子树情况，共五种可能，分别处理
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        //情况一：没找到要删除的结点，返回空
        if (root == null) return null;

        //根结点为要删除的结点
        if (root.val == key) {
            //情况二：删除root后没有结点了
            if (root.left == null && root.right == null) return null;
            //情况三：root只有右子树
            if (root.left == null) return root.right;
            //情况四：root只有左子树
            if (root.right == null) return root.left;
            //情况五：都不为空，连接好左右子树，选择一个结点作为根结点返回。将左子树放到右子树的最左结点的左子树位置。返回右子树。
            //1.找到右子树中最左的结点
            TreeNode node = root.right;
            while (node.left != null) node = node.left;
            //2.将左子树放到node左侧
            node.left = root.left;
            //3.返回右子树
            return root.right;
            //或者把右子树放到左子树最右结点的右子树位置，返回左子树
            /*
               TreeNode node=root.left;
               while(node.right!=null) node=node.right;
               node.right = root.right;
               return root.left;
             */
        }

        //若是删除普通二叉树，则下面两个递归不用加if判断
        //向左找，就要把删除后的子树连接到root的左侧
        if (root.val > key) root.left = deleteNode(root.left, key);

        //向右找，就要把删除后的子树连接到root的右侧
        if (root.val < key) root.right = deleteNode(root.right, key);

        return root;
    }
}
