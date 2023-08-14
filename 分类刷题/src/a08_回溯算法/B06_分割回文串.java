package a08_回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/8/14
 * Time: 16:09
 * Description:
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * 示例: 输入: "aab" 输出: [ ["aa","b"], ["a","a","b"] ]
 */
public class B06_分割回文串 {

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    private void backtracking(String s, int startIndex) {
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            //先挨个找回文子串，是回文字串才需要进行后续的处理
            String substring = s.substring(startIndex, i + 1);//获取startIndex到i的子串
            if (isPalindrome(substring)) {
                path.add(substring);
                backtracking(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * 双指针法判断是否是回文子串
     */
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

}
