package a09_贪心算法;

/**
 * @author: fosss
 * Date: 2023/8/31
 * Time: 10:04
 * Description:
 * 给定一个二叉树，我们在树的节点上安装摄像头。节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。计算监控树的所有节点所需的最小摄像头数量。
 * 示例：
 * 输入：[0,0,null,0,null,0,null,null,0]
 * 输出：2
 * 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
 */
public class B17_监控二叉树 {

    /**
     * 从下往上看，局部最优：让叶子节点的父节点安摄像头，所用摄像头最少，整体最优：全部摄像头数量所用最少
     * 节点有三个状态：0：该节点无覆盖  1：本节点有摄像头  2：本节点有覆盖
     */
    public int minCameraCover(TreeNode root) {
        //从下往上处理，才有后序遍历的方式，返回节点状态
        int status = postOrder(root);
        //判断根结点状态，如果未覆盖，则摄像头数量应该+1
        if (status == 0) res++;
        return res;
    }

    int res = 0;

    public int postOrder(TreeNode root) {
        //遍历到空节点，将其看作是已覆盖
        if (root == null) return 2;

        //遍历左子树
        int left = postOrder(root.left);
        //遍历右子树
        int right = postOrder(root.right);

        //由左右子树的返回状态判断他们的父节点root的状态
        if (left == 2 && right == 2) {
            //1.左右子树都被覆盖，root状态为未覆盖
            return 0;
        } else if (left == 0 || right == 0) {
            //2.左右子树中有一个未被覆盖，则root上应该放个摄像头
            res++;
            return 1;
        } else {
            //3.其他情况，左右子树中至少有一个摄像头，root为已覆盖
            return 2;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}