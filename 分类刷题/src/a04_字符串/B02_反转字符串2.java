package a04_字符串;

/**
 * @author: fosss
 * Date: 2023/7/25
 * Time: 8:42
 * Description:
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起, 每计数至 2k 个字符，就反转这 2k 个字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 */
public class B02_反转字符串2 {

    public static void main(String[] args) {
        //String res = reverseStr("abcdefg", 2);
        String res = reverseStr2("abcd", 4);
        System.out.println("res = " + res);
    }

    /**
     * 用for每次移动2*k个单位
     */
    public static String reverseStr2(String s, int k) {
        //先转成数组更容易处理
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i += (2 * k)) {
            int left = i;
            //处理需要进行反转的字符串的右边界
            int right = left + k - 1 < s.length() ? left + k - 1 : s.length() - 1;
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(chars);
    }

    /**
     * 5% 5%
     */
    public static String reverseStr(String s, int k) {
        int left = 0;
        int length = s.length();

        while (left < length) {
            int right = left + 2 * k - 1;
            //修正right
            right = right < length ? right : length - 1;
            //实际需要处理的字符数量
            int i = right - left + 1;
            if (i < k) {
                s = reverse(s, left, i);
                break;
            } else if (i <= 2 * k) {
                s = reverse(s, left, k);
                left += i;//跳过已经处理的字符
            }
        }
        return s;
    }

    private static String reverse(String s, int left, int size) {
        char[] chars = s.toCharArray();
        int right = left + size - 1;//反转前 k 个字符
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(chars);

    }
}



















