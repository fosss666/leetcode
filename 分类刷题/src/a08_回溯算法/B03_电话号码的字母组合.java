package a08_回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/8/13
 * Time: 17:07
 * Description:
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同，九键键盘）。注意 1 不对应任何字母。
 * 2:abc   3:def  4:ghi  ……
 * 示例：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class B03_电话号码的字母组合 {

    /**
     * 一个数字代表3~4个字母，几个数字就说明每个字符串有几个字符
     * 数字和字母的对应关系用哈希表或字符串数组表示
     */
    public List<String> letterCombinations(String digits) {
        backtracking(digits, 0);
        return res;
    }

    List<String> res = new ArrayList<>();//返回结果集
    StringBuilder path = new StringBuilder();//每种可能组合
    //数字字母对应关系
    String[] letterMap = {
            "",//数字0
            "",//数字1
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    /**
     * 回溯算法
     *
     * @param digits 数字字符串
     * @param index  访问到的数字下标
     */
    private void backtracking(String digits, int index) {
        if (index == digits.length()) {
            //每个数字都访问到了
            res.add(path.toString());
            return;
        }

        //当前访问的数字
        int num = digits.charAt(index) - '0';
        //遍历当前数字所映射的字母
        for (int i = 0; i < letterMap[num].length(); i++) {
            //添加路径
            path.append(letterMap[num].charAt(i));
            //递归访问下一个数字
            backtracking(digits, index + 1);
            //回溯
            path.deleteCharAt(path.length() - 1);
        }
    }
}











