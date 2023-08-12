package a07_二叉树;

/**
 * @author: fosss
 * Date: 2023/8/12
 * Time: 17:43
 * Description:
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例：
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案
 */
public class B28_将有序数组转换为二叉搜索树 {

    /**
     * 递归法
     * 从有序数组中间位置开始（偶数个的话中间那俩哪个都行），左右子数组分别构建，这样构造的二叉搜索树天然就是平衡的
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        //遍历结束
        if (left > right) return null;
        //取中间的值作为根结点，这样构造的二叉搜索树就天然的是平衡的
        int mid = (right - left) / 2 + left;
        TreeNode root = new TreeNode(nums[mid]);
        //构建左子树
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }
}
