package a07_二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: fosss
 * Date: 2023/8/9
 * Time: 18:54
 * Description:
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例：
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 */
public class B20_验证二叉搜索树 {
    public static void main(String[] args) {
        //TreeNode node1 = new TreeNode(5);
        //TreeNode node2 = new TreeNode(1);
        //TreeNode node3 = new TreeNode(4);
        //TreeNode node4 = new TreeNode(3);
        //TreeNode node5 = new TreeNode(6);
        //node1.left = node2;
        //node1.right = node3;
        //node3.left = node4;
        //node3.right = node5;
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        boolean validBST3 = isValidBST3(node1);
        System.out.println("validBST3 = " + validBST3);
        //System.out.println(list);
    }

    /**
     * 要知道一个预备知识，中序遍历二叉搜索树，得到的是一个有序数组。利用这个性质，判断
     */
    /**
     * 递归——得到中序数组后查看是否是有序的
     */
    public static boolean isValidBST(TreeNode root) {
        inorder(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) return false;
        }
        return true;
    }

    static List<Integer> list = new ArrayList<>();

    private static void inorder(TreeNode root) {
        if (root.left != null) inorder(root.left);
        list.add(root.val);
        if (root.right != null) inorder(root.right);
    }

    /**
     * 在递归过程中完成比较，不单独设置集合存储结点值——最优方案
     */
    TreeNode pre = null;

    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;

        boolean left = isValidBST2(root.left);
        //判断是否符合条件
        if (pre != null && pre.val >= root.val) return false;
        //更新pre
        pre = root;

        boolean right = isValidBST2(root.right);

        return left && right;
    }

    /**
     * 迭代-普通中序遍历
     */
    public static boolean isValidBST3(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                //向左移动
                root = root.left;//左
            } else {
                TreeNode node = stack.pop();
                //中
                if (pre != null && pre.val >= node.val) return false;
                //更新pre
                pre = node;

                //右
                root = node.right;
            }
        }
        return true;
    }

    /**
     * 迭代-中序遍历  统一遍历方式
     */
    public static boolean isValidBST4(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node != null) {
                if (node.right != null) stack.push(node.right);
                stack.push(node);
                stack.push(null);
                if (node.left != null) stack.push(node.left);
            } else {
                //pop出真正的数据
                node = stack.pop();
                if (pre != null && pre.val >= node.val) return false;
                pre = node;
            }
        }
        return true;
    }


    /**
     * 错误解法，只考虑了当前节点与其左右结点的大小关系，没有考虑到要比较的是左子树所有节点小于中间节点，右子树所有节点大于中间节点。
     */
    //public boolean isValidBST(TreeNode root) {
    //    //遍历结束返回true
    //    if (root == null) return true;
    //
    //    //不满足二叉搜索树特点，返回false
    //    if ((root.left != null && root.val <= root.left.val) || root.right != null && root.val >= root.right.val)
    //        return false;
    //
    //    //分别判断左右子树，并且返回两结果的&&
    //    return isValidBST(root.left) && isValidBST(root.right);
    //}
}

















