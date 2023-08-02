package a07_二叉树.b04_二叉树的层序遍历;

import java.util.*;

/**
 * @author: fosss
 * Date: 2023/8/2
 * Time: 11:35
 * Description:
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class B02_二叉树的层序遍历2 {

    /**
     * 和从上到下的层序遍历一样，最后将结果反转一下就行
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //提前将当前队列大小记录下来，避免其大小的变化影响到下边的循环，也可以采用 for(int i=queue.size();i>=0;i--){} 这种方式
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                //添加下一层的结点
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(list);

        }
        Collections.reverse(res);
        return res;
    }
}
