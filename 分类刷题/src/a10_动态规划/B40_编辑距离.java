package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/10/13
 * Time: 21:48
 * Description:
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1：
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释： horse -> rorse (将 'h' 替换为 'r') rorse -> rose (删除 'r') rose -> ros (删除 'e')
 * 示例 2：
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释： intention -> inention (删除 't') inention -> enention (将 'i' 替换为 'e') enention -> exention (将 'n' 替换
 * 为 'x') exention -> exection (将 'n' 替换为 'c') exection -> execution (插入 'u')
 * 提示：
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 */
public class B40_编辑距离 {
    public int minDistance(String word1, String word2) {
        //dp[i][j]表示以i-1结尾的word1和以j-1结尾的word2，要使他们相等，需要进行编辑距离的次数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        //初始化
        //word2为空字符串时
        for (int i = 0; i <= word1.length(); i++) dp[i][0] = i;
        //word1为空字符串时
        for (int i = 0; i <= word2.length(); i++) dp[0][i] = i;

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                //字符相等时，不需要编辑距离
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //删除word1的i-1位置的元素：dp[i - 1][j] + 1
                    //删除word2的j-1位置的元素：dp[i][j - 1] + 1)
                    //添加操作相等于给另一个字符串执行删除操作，如：word1 = "ad" ，word2 = "a"，word1删除元素'd' 和 word2添加一个元素'd'，变成word1="a", word2="ad"
                    //替换，相当于两个字符串的当前位置元素是相等时的次数再加上1
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
