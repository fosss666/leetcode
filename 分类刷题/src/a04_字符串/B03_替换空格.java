package a04_字符串;

/**
 * @author: fosss
 * Date: 2023/7/25
 * Time: 14:26
 * Description:
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1： 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class B03_替换空格 {
    /**
     * 用新字符串拼接
     */
    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c == ' ' ? "%20" : c);
        }
        return sb.toString();
    }

    /**
     * 先扩充再
     */
}


















