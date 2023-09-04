package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/4
 * Time: 16:57
 * Description:
 * https://leetcode.cn/problems/unique-binary-search-trees/
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 示例:
 * 输入：n = 3
 * 输出：5
 */
public class B07_不同的二叉搜索树 {

    /**
     * 动规
     * 题解：https://www.programmercarl.com/0096.%E4%B8%8D%E5%90%8C%E7%9A%84%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91.html
     */
    public int numTrees(int n) {
        //dp[i]表示由i格节点组成且节点值从1到n互不相同的二叉搜索树个数
        int[] dp = new int[n + 1];
        //初始化：n==0时，表示空树，空树默认只有一种情况
        dp[0] = 1;
        //从1到n一次推导i个节点组成的二叉搜索树有多少种
        for (int i = 1; i <= n; i++) {
            //对特定个数的节点，dp[i]=dp[左子树多少种] * dp[右子树多少种]
            for (int j = 0; j < i; j++) {
                //j表示左子树的节点数，最少0，最多n-1
                //dp[j]表示左子树有多少种，i-j-1为右子树节点数（-1是减去根结点那一个），dp[i-j-1]表示右子树有多少种
                dp[i] += (dp[j] * dp[i - j - 1]);
            }
        }
        return dp[n];
    }
}
