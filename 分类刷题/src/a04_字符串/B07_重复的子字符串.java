package a04_字符串;

/**
 * @author: fosss
 * Date: 2023/7/28
 * Time: 17:47
 * Description:
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class B07_重复的子字符串 {

    public static void main(String[] args) {
        //String s = "aabaabf";
        //System.out.println("getNext(s) = " + Arrays.toString(getNext(s)));
        //System.out.println("getNext2(s) = " + Arrays.toString(getNext2(s)));

        boolean res = repeatedSubstringPattern3("abab");
        System.out.println("res = " + res);
    }

    /**
     * 移动匹配中用到了查找字符串中是否存在某子字符串的操作，这个操作可以使用kmp算法优化
     */
    public static boolean repeatedSubstringPattern3(String s) {
        String ss = s + s;
        ss = ss.substring(1, ss.length() - 1);
        return kmp(ss, s);
    }

    private static boolean kmp(String s, String n) {
        char[] arrayS = s.toCharArray();
        char[] arrayN = n.toCharArray();
        int[] next = getNext(n);

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j > 0 && arrayS[i] != arrayN[j]) {
                j = next[j - 1];
            }
            if (arrayS[i] == arrayN[j]) {
                j++;
            }
            if (j == arrayN.length) {
                return true;
            }
        }
        return false;
    }


    /**
     * next数组 = 公共前后缀匹配表
     */
    private static int[] getNext(String pattern) {
        char[] chars = pattern.toCharArray();
        int[] next = new int[chars.length];
        int j = 0;
        for (int i = 1; i < chars.length; i++) {
            while (j != 0 && chars[i] != chars[j]) {
                j = next[j - 1];
            }
            if (chars[i] == chars[j]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     * next数组 = 公共前后缀匹配表整体后移一位
     */
    private static int[] getNext2(String pattern) {
        char[] chars = pattern.toCharArray();
        int[] next = new int[chars.length];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < chars.length - 1) {
            if (j == -1 || chars[i] == chars[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    /**
     * 移动匹配
     * ss=s+s    去掉首尾字符后，如果ss中还存在s，则返回true。其中判断ss中是否存在s的操作调用api
     */
    public boolean repeatedSubstringPattern2(String s) {
        String ss = s + s;
        //掐头去尾，保证匹配到的字符串不是原来前后的两个s
        ss = ss.substring(1, ss.length() - 1);
        //查找是否存在s
        //return ss.indexOf(s)>=0;
        return ss.contains(s);
    }

    /**
     * 枚举法
     * 长度为N的字符串s，如果它由重复的子字符串t组成，t的长度为n。则N是n的整数倍，且对于i∈[n,N]，s[i]=s[i-n]
     * 子字符串长度最大为s的一半
     */
    public boolean repeatedSubstringPattern(String s) {
        int N = s.length();
        for (int i = 1; i < N / 2; i++) {//逐个增加子字符串的长度（从1开始）
            //满足整数倍
            if (N % i == 0) {
                //标记是否找到子字符串
                boolean flag = true;
                for (int j = i; j < N; j++) {
                    if (s.charAt(j - i) != s.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

}













