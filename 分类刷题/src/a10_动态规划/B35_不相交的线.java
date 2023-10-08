package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/10/8
 * Time: 19:43
 * Description:
 * 我们在两条独立的水平线上按给定的顺序写下 A 和 B 中的整数。
 * 现在，我们可以绘制一些连接两个数字 A[i] 和 B[j] 的直线，只要 A[i] == B[j]，且我们绘制的直线不与任何其他连线（非水平线）相交。
 * 以这种方法绘制线条，并返回我们可以绘制的最大连线数
 * 示例：
 * 输入：nums1 = [1,4,2], nums2 = [1,2,4]
 * 输出：2
 * 解释：可以画出两条不交叉的线，如上图所示。
 * 但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相交
 */
public class B35_不相交的线 {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        //仔细分析题意，发现这不就是找两个数组的最长公共子序列那道题嘛
        //dp[i][j]表示长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    //(nums1[i]和nums2[j]相等，则赋值为长度为[0, i - 2]的字符串text1与长度为[0, j - 2]的字符串text2的最长公共子序列长度+1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //不相等，则赋值为max( 长度为[0, i - 2]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列长度, 长度为[0, i - 1]的字符串text1与长度为[0, j - 2]的字符串text2的最长公共子序列长度  )
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
