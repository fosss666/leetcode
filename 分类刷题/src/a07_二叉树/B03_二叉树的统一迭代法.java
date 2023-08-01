package a07_二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: fosss
 * Date: 2023/8/1
 * Time: 15:10
 * Description:
 * 以中序遍历为例，使用栈的话，无法同时解决访问节点（遍历节点）和处理节点（将元素放进结果集）不一致的情况。
 * 那我们就将访问的节点放入栈中，把要处理的节点也放入栈中但是要做标记。即将所有结点都先放入栈中，但对要先遍历的结点加个标记
 * 如何标记呢，就是要处理的节点放入栈之后，紧接着放入一个空指针作为标记。 这种方法也可以叫做标记法。
 */
public class B03_二叉树的统一迭代法 {

    /**
     * 后序遍历  遍历顺序为左右中，所以加入栈的顺序是中左右
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                stack.push(node);
                //放入一个null，表示node未进行处理
                stack.push(null);

                if (node.right != null) stack.push(node.right);

                if (node.left != null) stack.push(node.left);

            } else {
                //node为空，说明遇到了没有处理的结点
                TreeNode t = stack.pop();//将需要处理的结点弹出
                list.add(t.val);
            }
        }
        return list;
    }

    /**
     * 前序遍历  遍历顺序为中左右，所以加入栈的顺序是右左中
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) stack.push(node.right);

                if (node.left != null) stack.push(node.left);

                stack.push(node);
                //放入一个null，表示node未进行处理
                stack.push(null);

            } else {
                //node为空，说明遇到了没有处理的结点
                TreeNode t = stack.pop();//将需要处理的结点弹出
                list.add(t.val);
            }
        }
        return list;
    }

    /**
     * 中序遍历  遍历顺序为左中右，所以加入栈的顺序是右中左
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) stack.push(node.right);

                stack.push(node);
                //放入一个null，表示node未进行处理
                stack.push(null);

                if (node.left != null) stack.push(node.left);
            } else {
                //node为空，说明遇到了没有处理的结点
                TreeNode t = stack.pop();//将需要处理的结点弹出
                list.add(t.val);
            }
        }
        return list;
    }
}
