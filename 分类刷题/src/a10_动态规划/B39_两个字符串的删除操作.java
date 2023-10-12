package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/10/12
 * Time: 9:55
 * Description:
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 * 示例：
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 */
public class B39_两个字符串的删除操作 {
    public static void main(String[] args) {
        B39_两个字符串的删除操作 test = new B39_两个字符串的删除操作();
        int res = test.minDistance2("sea", "eat");
        System.out.println("res = " + res);
    }

    /**
     * 思路一
     * 如果两个字符不相同，要不删除word1的字符，要不删除word2的字符
     */
    public int minDistance(String word1, String word2) {
        //dp[i][j]表示：以i-1结尾的word1和以j-1结尾的word2要想相等，需要删除的字符数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        //初始化：word1为空字符串时，需要删除掉word2 j长度的字符才能使两个字符串相等；同理word2为空字符串也一样
        //2为空字符串
        for (int i = 0; i <= word1.length(); i++) dp[i][0] = i;
        //1为空字符串
        for (int j = 0; j <= word2.length(); j++) dp[0][j] = j;

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                //字符相等，不需要删除字符，所以删除次数不变
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //字符不相等，删word1或word2，选择删除数小的那个，并加上1
                    //dp[i - 1][j]+1：删除word1[i-1]    dp[i][j-1]：删除word2[j-1]
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    /**
     * 思路二
     * B34_最长公共子序列，计算最长公共子序列的长度，再用两个字符串长度的和减去 (公共序列长度*2)
     */
    public int minDistance2(String word1, String word2) {
        //dp[i][j]表示：以i-1结尾的word1和以j-1结尾的word2的公共子序列的长度
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        int max = 0;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return word1.length() + word2.length() - max * 2;
    }

}
