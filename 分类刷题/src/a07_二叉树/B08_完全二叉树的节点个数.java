package a07_二叉树;

/**
 * @author: fosss
 * Date: 2023/8/6
 * Time: 9:33
 * Description:
 * 给出一个完全二叉树，求出该树的节点个数。
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 示例 2：
 * 输入：root = []
 * 输出：0
 * 示例 3：
 * 输入：root = [1]
 * 输出：1
 * 提示：
 * 树中节点的数目范围是[0, 5 * 10^4]
 * 0 <= Node.val <= 5 * 10^4
 * 题目数据保证输入的树是 完全二叉树
 */
public class B08_完全二叉树的节点个数 {

    /**
     * 利用到完全二叉树的特点
     * 完全二叉树可以看成多个满二叉树拼接而成，满二叉树结点个数用2^n-1来计算，n表示层数
     */
    public int countNodes2(TreeNode root) {
        if(root== null) return 0;
        //在完全二叉树中，如果一直向左的深度与一直向右的深度相等，则说明是满二叉树，普通二叉数没有这个特点
        //计算比较一下
        //为什么初始值设为1呢？如果两值计算出来相等，需要利用公式2的n次方来计算，如果值是1（left=right=null即二叉树只有一个根结点），则返回结果为2^1-1=1;如果值是2，则返回结果是2^2-1=3
        int leftDepth=1;
        int rightDepth=1;
        TreeNode left=root.left;
        TreeNode right=root.right;
        while(left!=null){
            left=left.left;
            leftDepth++;
        }
        while(right!=null){
            right=right.right;
            rightDepth++;
        }
        if(leftDepth==rightDepth){
            return (int)(Math.pow(2,leftDepth) -1);
        }
        //不是满二叉树则向左右寻找满二叉树并将求得的结点数以及根结点那一个加起来
        return countNodes2(root.left)+countNodes2(root.right)+1;
    }

    /**
     * 可以采用各种遍历方式，但这样没用用到完全二叉树的性质，只是对普通的二叉树统计的一般方式
     * 前序遍历
     */
    public int countNodes(TreeNode root) {
        if(root== null) return 0;
        return countNodes(root.left)+countNodes(root.right)+1;
    }

}

