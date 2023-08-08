package a07_二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: fosss
 * Date: 2023/8/8
 * Time: 20:22
 * Description:
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意: 你可以假设树中没有重复的元素。
 * 示例：
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 */
public class B16_从前序与中序遍历序列构造二叉树 {

    /**
     * 中序数组还是用来分析左右子树，前序数组首位是根结点元素，与根据后序与中序构造二叉树思路相同，都是做分割
     */
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursion(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode recursion(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        //递归结束条件——数组遍历完
        if (preLeft > preRight) {
            return null;
        }

        //获取根结点
        int rootValue = preorder[preLeft];
        TreeNode root = new TreeNode(rootValue);

        //分割中序数组
        int inLL = inLeft;
        int inLR = map.get(rootValue) - 1;
        int inRL = map.get(rootValue) + 1;
        int inRR = inRight;

        //分割前序数组
        int lSize = inLR - inLL + 1;
        int preLL = preLeft + 1;//跳过根结点，注意与后续数组跳过的位置不一样
        int preLR = preLL + lSize - 1;//这里要用preLl为起点
        int preRL = preLR + 1;
        int preRR = preRight;

        root.left = recursion(preorder, preLL, preLR, inorder, inLL, inLR);
        root.right = recursion(preorder, preRL, preRR, inorder, inRL, inRR);

        return root;
    }
}










