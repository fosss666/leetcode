package com.fosss.a05_替换空格;

/**
 * @author fosss
 * date 2023/1/3
 * description：
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 例：输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 限制：0 <= s 的长度 <= 1000、
 * <p>
 * 思路：
 * 1.用索引index遍历，遇到空格则换成%20后，index+=3,可以通过新建字符数组字符数组（3倍字符串长度，因为1个字符换成3个字符，最多长度增长3倍），
 * 也可借助StringBuilder进行拼接
 *
 */
public class Demo {
    public static void main(String[] args) {
        String s = "We are happy.";
        Demo demo = new Demo();
        //String string = demo.replaceSpace(s);
        //String string = demo.replaceSpace2(s);
        String string = demo.replaceSpace3(s);
        System.out.println("string = " + string);
    }

    /**
     * StringBuilder
     */
    public String replaceSpace3(String s) {

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 创建字符数组
     */
    public String replaceSpace2(String s) {
        //创建字符数组，长度为字符串的三倍（因为每次替换都是吧一个字符换成三个字符，所以创建三倍长的数组能够保证不会越界）
        char[] chars = new char[s.length() * 3];
        //遍历字符串
        //char[] chars1 = s.toCharArray();
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                chars[size] = '%';
                chars[size + 1] = '2';
                chars[size + 2] = '0';
                size += 3;//跳过三个字符
            } else {
                chars[size] = c;
                size++;
            }
        }
        return new String(chars, 0, size);
    }

    /**
     * 自解
     */
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }
}
























