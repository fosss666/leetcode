package a07_二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: fosss
 * Date: 2023/8/8
 * Time: 17:58
 * Description:
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意: 你可以假设树中没有重复的元素。
 * 示例：
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 */
public class B15_从中序与后序遍历序列构造二叉树 {

    /**
     * 后序遍历最后一个元素是根结点，根据这个根结点在中序遍历数组中的位置，将中序遍历数组切割成左右数组，然后根据左右数组的大小再分别从后序遍历数
     * 组中切割后序遍历数组的左右数组。
     * 为了方便根据后序遍历中一个节点的值在前序遍历数组中找到对应的位置，免于遍历寻找，使用map来记录inorder中每个值的下标
     */
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursion(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode recursion(int[] inorder, int inorderBegin, int inorderEnd, int[] postorder, int postorderBegin, int postorderEnd) {
        //递归结束条件——后序遍历数组已经访问完，此时返回空树
        if (postorderBegin > postorderEnd) return null;

        //根据postorder创建根结点
        int rootValue = postorder[postorderEnd];
        TreeNode root = new TreeNode(rootValue);

        //分割中序数组
        int inorderLeftBegin = inorderBegin;
        int inorderLeftEnd = map.get(rootValue) - 1; //跳过根结点
        int inorderRightBegin = map.get(rootValue) + 1; //跳过根结点
        int inorderRightEnd = inorderEnd;

        //分割后序数组
        int leftSize = inorderLeftEnd - inorderLeftBegin + 1;

        int postorderLeftBegin = postorderBegin;
        int postorderLeftEnd = postorderLeftBegin + leftSize - 1;
        int postorderRightBegin = postorderLeftEnd + 1;
        int postorderRightEnd = postorderEnd - 1;//跳过根结点

        //设置左右子树
        root.left = recursion(inorder, inorderLeftBegin, inorderLeftEnd, postorder, postorderLeftBegin, postorderLeftEnd);
        root.right = recursion(inorder, inorderRightBegin, inorderRightEnd, postorder, postorderRightBegin, postorderRightEnd);

        return root;
    }
}
