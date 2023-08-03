package a07_二叉树.b04_二叉树的层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: fosss
 * Date: 2023/8/3
 * Time: 16:53
 * Description:
 * 您需要在二叉树的每一行中找到最大的值。
 */
public class B06_在每个树行中找最大值 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root==null) return  res;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            for(int i = queue.size(); i > 0; i--){
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(max);
        }
        return res;
    }
}
