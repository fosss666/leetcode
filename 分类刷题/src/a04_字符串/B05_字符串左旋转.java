package a04_字符串;

/**
 * @author: fosss
 * Date: 2023/7/25
 * Time: 15:51
 * Description:
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 * 限制：
 * 1 <= k < s.length <= 10000
 */
public class B05_字符串左旋转 {

    /**
     * 先局部反转，再整体反转（不必创建新空间）
     */
    public String reverseLeftWords2(String s, int n) {
        //先分别反转前一部分字符串和后一部分字符串，最后整体反转
        StringBuilder builder = new StringBuilder(s);
        reverse(builder, 0, n - 1);
        reverse(builder, n, builder.length());
        reverse(builder, 0, builder.length());
        return builder.toString();
    }

    private static void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }

    /**
     * substring截取字符串
     */
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}











