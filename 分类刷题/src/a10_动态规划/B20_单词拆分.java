package a10_动态规划;

import java.util.List;

/**
 * @author: fosss
 * Date: 2023/9/18
 * Time: 20:57
 * Description:
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class B20_单词拆分 {
    /**
     * 回溯算法：分割回文串 (opens new window)：是枚举分割后的所有子串，判断是否回文。本道是枚举分割所有字符串，判断是否在字典里出现过
     * 回溯法——超时
     */
/*    public boolean wordBreak(String s, List<String> wordDict) {
        return backtracking(s, 0, wordDict);
    }

    private boolean backtracking(String s, int startIndex, List<String> wordDict) {
        if (startIndex == s.length()) {
            //能走到这一步，说明set中的字符串能将s全部拆分
            return true;
        }

        for (int i = startIndex; i < s.length(); i++) {
            //切割字符串
            String substring = s.substring(startIndex, i + 1);
            if (set.contains(substring)) {
                //set中有这个字符串才需要继续处理
                boolean backtracking = backtracking(s, i + 1, wordDict);
                //找到了就返回
                if (backtracking) return true;
            }
        }
        //没找到
        return false;
    }*/

    /**
     * 回溯法——使用记忆数组优化，能通过
     * 为了使遍历完字符串后如果没有找到，应及时结束回溯返回false,使用一个数组记录无法匹配的下标
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        memory = new int[s.length()];
        return backtracking(s, 0, wordDict);
    }

    int[] memory;

    private boolean backtracking(String s, int startIndex, List<String> wordDict) {
        if (startIndex == s.length()) {
            //能走到这一步，说明set中的字符串能将s全部拆分
            return true;
        }
        //如果startIndex位置不是初始值0了，返回false
        if (memory[startIndex] == -1) return false;

        for (int i = startIndex; i < s.length(); i++) {
            //切割字符串
            String substring = s.substring(startIndex, i + 1);
            if (wordDict.contains(substring)) {
                //set中有这个字符串才需要继续处理
                boolean backtracking = backtracking(s, i + 1, wordDict);
                //找到了就返回
                if (backtracking) return true;
            }
        }
        //没找到,标记以startIndex开始的子串是不可以被拆分的
        memory[startIndex] = -1;
        return false;
    }

    /**
     * 完全背包
     * 单词就是物品，字符串s就是背包，单词能否组成字符串s，就是问物品能不能把背包装满。拆分时可以重复使用字典中的单词，说明就是一个完全背包
     * 这里强调单词的顺序一定，才能组成字符串s，所以是排列问题，先遍历背包后遍历物品
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        //dp[i]：遍历到s的下标i处，能用wordDict中的单词拆分吗？dp[i]
        boolean[] dp = new boolean[s.length() + 1];
        //递推公式中，要保证j之前能够由单词组成且j~i由单词组成，所以初始化第一个值为true
        dp[0] = true;

        //遍历子字符串结束下标
        for (int i = 1; i < dp.length; i++) {
            //遍历子字符串开始下标
            for (int j = 0; j < i; j++) {
                //拆分字符串
                String substring = s.substring(j, i);
                if (dp[j] && wordDict.contains(substring)) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
