package a07_二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: fosss
 * Date: 2023/8/7
 * Time: 11:31
 * Description:
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例：
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 */
public class B10_二叉树的所有路径 {

    /**
     * 前序遍历 path为String类型
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        if(root==null) return res;
        getPaths(root,res,"");
        return res;
    }
    private void getPaths(TreeNode root,List<String> list,String path){
        //递归结束条件——判断是否是叶子结点
        if(root.left==null&& root.right==null){
            //是叶子节点，将节点值放到路径中后加入返回集合
            path+=root.val;
            list.add(path);
            return;
        }
        //添加路径
        path=path+root.val+"->";
        //向左子树遍历
        if(root.left!=null)  getPaths(root.left,list,path);
        //为什么遍历完左子树和遍历完右子树后不需要将左子树遍历的最后一个结点node从路径中去掉呢？
        //因为String 是不可变的，每次修改都会创建一个新的String对象，所以回溯时的path会是原来没有添加node的路径，类似于基本类型的值传递，
        //然而如果path不用String而用一个List<Integer> 这种类型的话，就需要在回溯时将node去除掉了
        //也可以用path+root.val+"->"作为左右遍历是path的参数值
        //向右子树遍历
        if(root.right!=null) getPaths(root.right,list,path);
    }

    /**
     * 递归 path为集合类型
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<>();// 存最终的结果
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();// 作为结果中的路径
        traversal(root, paths, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val);// 前序遍历，中
        // 遇到叶子结点
        if (root.left == null && root.right == null) {
            // 输出
            StringBuilder sb = new StringBuilder();// StringBuilder用来拼接字符串，速度更快
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));// 记录最后一个节点
            res.add(sb.toString());// 收集一个路径
            return;
        }
        // 递归和回溯是同时进行，所以要放在同一个花括号里
        if (root.left != null) { // 左
            traversal(root.left, paths, res);
            paths.remove(paths.size() - 1);// 回溯
        }
        if (root.right != null) { // 右
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1);// 回溯
        }
    }

    /**
     * 迭代法
     */
    public List<String> binaryTreePaths3(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<Object> stack = new Stack<>();
        // 节点和路径同时入栈
        stack.push(root);
        stack.push(root.val + "");
        while (!stack.isEmpty()) {
            // 节点和路径同时出栈
            String path = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            // 若找到叶子节点
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            //右子节点不为空
            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.val);
            }
            //左子节点不为空
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }
        }
        return result;
    }
}
