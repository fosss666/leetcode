package a07_二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: fosss
 * Date: 2023/8/7
 * Time: 19:54
 * Description:
 * 给定一个二叉树，在树的最后一行找到最左边的值。找最后一层最左的结点的值。
 * 示例：
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 */
public class B12_找树左下角的值 {

    /**
     * 递归
     */
    public int findBottomLeftValue3(TreeNode root) {
        recursion(root,1);
        return res;
    }
    int res=0;
    int maxDepth=Integer.MIN_VALUE;
    private void recursion(TreeNode root,int depth){
        //如果是叶子结点，看看是不是最大深度，更新最大深度和返回值
        if(root.left==null&&root.right==null){
            //由于前序遍历先遍历到左子树，所以相同深度先访问的是最左的结点，所以res可以取到所需位置的值
            if(depth>maxDepth){
                maxDepth=depth;
                res=root.val;
            }
            return;
        }
        //depth+1隐藏着回溯的过程
        if(root.left!=null) recursion(root.left,depth+1);
        if(root.right!=null) recursion(root.right,depth+1);
    }

    /**
     * 层序遍历，找每层最第一个结点
     */
    public int findBottomLeftValue2(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int res=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                //记录每列最左的结点值，这样遍历到最后一列时就是要找的值了
                if(i==0) res=node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return res;
    }

    /**
     * 层序遍历，遍历到最后一层找左下角
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            root =queue.poll();
            //先向队列中放右结点，再放左结点，这样队列最后取出就是左结点了
            if(root.right!=null) queue.add(root.right);
            if(root.left !=null) queue.add(root.left);

        }
        return root.val;
    }

}
