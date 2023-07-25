package a04_字符串;

/**
 * @author: fosss
 * Date: 2023/7/25
 * Time: 14:46
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
public class B04_反转字符串中的单词 {

    public static void main(String[] args) {
        String s = "  the sky   is blue";
        //String res = reverseWords(s);
        String res = reverseWords2(s);
        System.out.println("res = " + res);
    }

    /**
     * 不调用api
     * 1.去掉前后中间的空格
     * 2.反转整个字符串
     * 3.反转单词
     */
    public static String reverseWords2(String s) {
        StringBuilder sb = myTrim(s);
        reverse(sb, 0, sb.length() - 1);
        reverseWord(sb);
        return sb.toString();
    }

    /**
     * 反转单词
     */
    private static void reverseWord(StringBuilder sb) {
        int start = 0;
        int end = 0;
        while (start < sb.length()) {
            while (end < sb.length() && sb.charAt(end) != ' ') {
                end++;
            }
            reverse(sb, start, end - 1);
            end++;
            start = end;
        }
    }

    /**
     * 反转指定范围的整个字符串
     */
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
     * 去掉前后中间的空格
     */
    private static StringBuilder myTrim(String s) {
        //去掉前后字符串
        int left = 0;
        int right = s.length() - 1;
        while (left < right && s.charAt(left) == ' ') {
            left++;
        }
        while (left < right && s.charAt(right) == ' ') {
            right--;
        }

        StringBuilder sb = new StringBuilder();
        //去除单词间多余的空格
        while (left <= right) {
            //非空格或者仅有一个空格
            if ((left > 0 && s.charAt(left - 1) != ' ') || s.charAt(left) != ' ') {
                sb.append(s.charAt(left));
            }
            left++;
        }
        return sb;
    }

    /**
     * 调用api: trim、split
     */
    public static String reverseWords(String s) {
        //去除两边空格
        s = s.trim();
        //根据单个空格进行分组，注意由于单词之间的空格可能不止一个，所以肯恩那个出现数组中的元素为空字符串获取空格的现象，处理时需要过滤掉
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].length() > 0) {
                sb.append(strings[i]).append(' ');
            }
        }
        String res = sb.toString();
        //去掉最后一个空格
        res = res.trim();
        return res;
    }
}



















