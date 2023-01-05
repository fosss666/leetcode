package com.fosss.a07_重建二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fosss
 * date 2023/1/5
 * description：
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例：  Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 限制：0 <= 节点个数 <= 5000
 */
public class Demo {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        Demo demo = new Demo();
        TreeNode treeNode = demo.buildTree(preorder, inorder);
        System.out.println("treeNode.val = " + treeNode.val);
    }


    //用来存储中序遍历中个元素的下标
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    /**
     * @param preorder 前序遍历的值数组
     * @param inorder  中序遍历的值数组
     * @return 树的根结点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //初始化map
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursion(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }


    private TreeNode recursion(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        //递归结束条件
        if (l1 > r1 || l2 > r2) {
            return null;
        }
        //根节点
        TreeNode root = new TreeNode(preorder[l1]);
        //获取根节点的下标
        Integer index = map.get(root.val);
        //左子树的结点个数,根据中序
        int size = index - l2;
        //递归设置左子树
        root.left = recursion(preorder, l1 + 1, l1 + size, inorder, l2, index - 1);
        //递归设置右子树
        root.right = recursion(preorder, l1 + size + 1, r1, inorder, index + 1, r2);

        return root;
    }
}























