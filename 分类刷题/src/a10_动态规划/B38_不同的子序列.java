package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/10/11
 * Time: 16:02
 * Description:
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，
 * 而 "AEC" 不是）
 * 结果需要对 109 + 7 取模,即题目数据保证答案符合 32 位带符号整数范围。
 * 示例：
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 有 3 种可以从 s 中得到 "rabbit" 的方案。
 */
public class B38_不同的子序列 {

    public int numDistinct(String s, String t) {
        //dp[i][j]表示以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        //初始化: ①dp[i][0]表示t为空串时以i-1为结尾的s子序列出现t的次数，为1 ②dp[0][j]表示s为空串时s中出现非空串t的次数，为0
        for (int i = 0; i < s.length(); i++) dp[i][0] = 1;

        //遍历
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    //元素相同  dp[i][j]由两部分组成
                    //dp[i - 1][j - 1]：以i-2为结尾的s子序列中出现以j-2为结尾的t的个数。
                    //dp[i - 1][j]：以i-2结尾的s子序列中出现以j-1为结尾的t的个数。同一行（i-2），不同列（i-2和i-1），表示i-2
                    //及以前的序列中包含j-1的t序列的个数
                    //例如： s：bagg 和 t：bag ，s[3] 和 t[2]是相同的，但是字符串s也可以不用s[3]来匹配，即用s[0]s[1]s[2]组成的bag。
                    //当然也可以用s[3]来匹配，即：s[0]s[1]s[3]组成的bag。
                    //所以当s[i - 1] 与 t[j - 1]相等时，dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    //元素不同 dp[i][j]只有一部分组成，不用s[i - 1]来匹配（就是模拟在s中删除这个元素），即：dp[i - 1][j]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
