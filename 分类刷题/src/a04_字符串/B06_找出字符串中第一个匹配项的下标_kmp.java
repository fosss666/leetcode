package a04_字符串;

/**
 * @author: fosss
 * Date: 2023/7/27
 * Time: 21:21
 * Description:
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
 * 示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2
 * 示例 2: 输入: haystack = "aaaaa", needle = "bba" 输出: -1
 * 说明: 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与
 * C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class B06_找出字符串中第一个匹配项的下标_kmp {

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        //String needle = "ll";
        //int[] next = getNext(needle);
        //System.out.println("next = " + Arrays.toString(next));
        //strStr(haystack, needle);
        //int[] next2 = getNext2(needle);
        //System.out.println("next2 = " + Arrays.toString(next2));
        int i = strStr2(haystack, needle);
        System.out.println(i);
    }

    //===================================== next数组为公共前后缀匹配表整体后移一位=================================

    /**
     * kmp算法
     */
    public static int strStr2(String haystack, String needle) {
        char[] s = haystack.toCharArray();
        char[] c = needle.toCharArray();
        //获取next数组
        int[] next = getNext2(needle);
        //进行匹配
        int i = 0;
        int j = 0;
        while (i < s.length && j < c.length) {
            if (j == -1 || s[i] == c[j]) {
                i++;
                j++;
            } else {
                //移动模式串到应该进行下一次匹配的位置
                j = next[j];
            }
        }

        //找不着匹配的，返回-1
        return j == c.length ? i - j : -1;
    }

    /**
     * 获取next数组（这里采用公共前后缀匹配数组没有发生移动的方式）
     */
    private static int[] getNext2(String needle) {

        //next[i]表示如果当前位置的字符不满足的话，需要进行匹配的下一个字符的位置
        int[] next = new int[needle.length()];
        if (needle.length() == 0) {
            return next;
        }
        char[] chars = needle.toCharArray();
        //next数组第一个值初始化为-1
        next[0] = -1;

        //j初始化为-1。注意j既代表前后缀匹配的长度，又代表如果不匹配的花，应该回退到的字符下标
        int i = 0;
        int j = -1;
        //因为当前i位置的值代表的是字符串下一位字符的前后缀匹配长度，所以需要用到i的下一位的下标，所以循环条件是<length-1
        while (i < chars.length - 1) {
            if (j == -1 || chars[i] == chars[j]) {
                //因为公共前后缀匹配表统一后移，所以先进行+1操作
                i++;
                j++;
                next[i] = j;
                //next数组的优化
                /*
                if (chars[i] != chars[j]) {
                     next[i] = j;
                } else {
                //再进行两字符串匹配时，如果chars[k] == chars[j]的话，next[j]和主串不匹配，next[k]肯定也不匹配，所以直接对next[next[k]]进行匹配判断
                     next[i] = next[j];
                }
                */
            } else {
                j = next[j];
            }
        }

        return next;
    }

    //=========================================== next数组与公共前后缀匹配表完全一致======================================

    /**
     * kmp算法
     */
    public static int strStr(String haystack, String needle) {
        char[] s = haystack.toCharArray();
        char[] c = needle.toCharArray();
        //获取next数组
        int[] next = getNext(needle);
        //进行匹配 j表示needle已经和haystack匹配的长度，也表示next数组应该进行匹配的下标
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && s[i] != c[j]) {
                //出现不匹配现象了，根据next数组查找下一个应该进行比较的位置（即当前字符的前一个字符的前后缀匹配位置）,直到找到位置
                j = next[j - 1];
            }
            //匹配，则下个循环中要对c的下个字符进行比较
            if (s[i] == c[j]) {
                j++;
            }
            if (j == c.length) {
                //说明已经完全匹配了,返回开始匹配的位置
                return i - j + 1;
            }

        }
        //找不着匹配的，返回-1
        return -1;
    }

    /**
     * 获取next数组（这里采用公共前后缀匹配数组没有发生移动的方式）
     */
    private static int[] getNext(String needle) {

        //next[i]表示如果当前位置的字符不满足的话，需要进行匹配的下一个字符的位置
        int[] next = new int[needle.length()];
        if (needle.length() == 0) {
            return next;
        }
        char[] chars = needle.toCharArray();

        //j初始化为第一个字符的下标。注意j既代表前后缀匹配的长度，又代表如果不匹配的花，应该回退到的字符下标
        int j = 0;
        //从第二个字符开始逐个匹配
        for (int i = 1; i < chars.length; i++) {
            //j的回退
            while (j > 0 && chars[i] != chars[j]) {
                //不匹配，则一直回退到与当前字符匹配的字符上
                j = next[j - 1];
            }
            //匹配时，匹配长度+1
            if (chars[i] == chars[j]) {
                j++;
            }
            //更新当前字符应该回退的位置
            next[i] = j;
        }
        return next;
    }
}















