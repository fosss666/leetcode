package a05_双指针法;

/**
 * @author: fosss
 * Date: 2023/7/29
 * Time: 15:04
 * Description:
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class B03_反转字符串中的单词 {

    public static void main(String[] args) {
        String res = reverseWords("the  sky  is  blue   ");
        System.out.println("res = " + res);
    }

    public static String reverseWords(String s) {
        //去除两端及单词间多余的空格
        StringBuilder sb = myTrim(s);
        //反转整个字符串
        reverse(sb, 0, sb.length() - 1);
        //反转每个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    private static void reverseEachWord(StringBuilder sb) {
        int left = 0;
        int right = 0;
        while (right < sb.length()) {
            while (right < sb.length() && sb.charAt(right) != ' ') {
                right++;
            }
            reverse(sb, left, right - 1);
            right++;
            left = right;
        }
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

    private static StringBuilder myTrim(String s) {
        //去除左右空格
        int left = 0;
        int right = s.length() - 1;
        while (s.charAt(left) == ' ') {
            left++;
        }
        while (s.charAt(right) == ' ') {
            right--;
        }
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            if ((s.charAt(left) != ' ') || (s.charAt(left) != s.charAt(left - 1))) {
                //不为空格或者是空格但上一个不是空格（不为连续的空格）
                sb.append(s.charAt(left));
            }
            left++;
        }
        return sb;
    }
}








