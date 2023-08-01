package a07_二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author: fosss
 * Date: 2023/8/1
 * Time: 14:08
 * Description:
 * 递归的实现就是：每一次递归调用都会把函数的局部变量、参数值和返回地址等压入调用栈中，然后递归返回的时候，从栈顶弹出上一次递归的各项参数
 */
public class B02_二叉树的迭代遍历 {

    /**
     * 后序遍历
     * 在前序遍历代码上做顺序的调整，后序遍历的访问顺序是左右中，前序遍历的顺序是中左右，相当于修改一下左右顺序，最后再将集合逆转就行
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        //取list的倒序
        Collections.reverse(list);
        return list;
    }

    /**
     * 中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                //遍历添加左子树
                stack.push(cur);
                cur = cur.left;
            } else {
                //遍历到叶子结点了，弹出中间结点，并访问右子结点
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }

    /**
     * 前序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            //要先将右结点入栈，再将左结点入栈，这样出栈的时候就是先左后右了
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return list;
    }
}
