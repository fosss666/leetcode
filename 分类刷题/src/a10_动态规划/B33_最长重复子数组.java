package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/10/5
 * Time: 20:21
 * Description:
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 示例：
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3, 2, 1] 。
 * 提示：
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class B33_最长重复子数组 {

    /**
     * 动规
     */
    public int findLength(int[] nums1, int[] nums2) {
        //dp[i][j]表示以nums[i-1],nums[j-1]结尾的最长公共子数组
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        int max = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                //如果nums[i-1],nums[j-1]相等，则dp[i][j]为上一层+1，否则保持原来的0
                if (nums1[i - 1] == nums2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;

                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

}
