package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/25
 * Time: 20:58
 * Description:
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一
 * 个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将
 * 自动报警。计算在不触动警报的情况下，小偷一晚能够盗取的最高金额
 * 示例：
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 */
public class B24_打家劫舍Ⅲ {

    /**
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        //本题一定是要后序遍历，因为通过递归函数的返回值来做下一步计算。0处存不偷当前节点的最高金额，1处存偷当前节点的最高金额
        //用一个长度为2的数组来保存偷不偷当前节点分别得到的最高金额
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        //root为空，偷不偷得到的金额都是0，相当于初始化
        if (root == null) return new int[]{0, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        //判断当前节点root偷不偷
        //不偷root，则左右子节点可以偷也可以不偷，取左右子节点的最大值相加
        int value1 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //偷root,则它的左右子节点不能偷，得到此时的最高金额
        int value2 = root.val + left[0] + right[0];

        //返回当前节点得到的最大金额
        return new int[]{value1, value2};
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