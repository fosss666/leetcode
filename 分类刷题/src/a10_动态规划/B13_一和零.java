package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/10
 * Time: 12:31
 * Description:
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * 示例 1：
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 * 提示：
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 */
public class B13_一和零 {

    public static void main(String[] args) {
        B13_一和零 test = new B13_一和零();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        test.findMaxForm(strs, 3, 3);
    }

    /**
     * 此题背包分为两个维度，分别是0的数量和1的数量
     */
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]：最多有i个0和j个1的strs的最大子集的大小为dp[i][j]
        int[][] dp = new int[m + 1][n + 1];

        //遍历字符串集合
        for (String str : strs) {
            //记录这个字符串0和1的数量
            int count0 = 0, count1 = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }

            //倒序遍历背包,两个维度先遍历那个都行
            for (int j = m; j >= count0; j--) {
                for (int k = n; k >= count1; k--) {
                    //判断加上这个字符串是否有性价比，这个字符串中0和1的个数越小越好，子集数量dp[j][k]越大越好
                    dp[j][k] = Math.max(dp[j][k], dp[j - count0][k - count1] + 1);
                }
            }
        }
        return dp[m][n];
    }

}
