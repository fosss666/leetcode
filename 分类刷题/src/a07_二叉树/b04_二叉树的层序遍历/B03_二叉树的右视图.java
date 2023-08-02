package a07_二叉树.b04_二叉树的层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: fosss
 * Date: 2023/8/2
 * Time: 11:39
 * Description:
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 示例：
 * 输入: [1,2,3,null,5,null,4]  输出: [1,3,4]
 * 输入: [1,null,3]  输出: [1,3]
 */
public class B03_二叉树的右视图 {

    /**
     * 层序遍历时，只保留每一层的最后一个元素
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) res.add(node.val);

                //添加子层结点
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return res;
    }
}













