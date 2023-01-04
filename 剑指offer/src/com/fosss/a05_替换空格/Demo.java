package com.fosss.a05_替换空格;

import com.sun.org.apache.xml.internal.serializer.ElemDesc;

import java.util.Arrays;

/**
 * @author fosss
 * date 2023/1/3
 * description：
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 例：输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 限制：0 <= s 的长度 <= 1000
 */
public class Demo {
    public static void main(String[] args) {
        String s = "We are happy.";
        Demo demo = new Demo();
        //String string = demo.replaceSpace(s);
        String string = demo.replaceSpace2(s);
        System.out.println("string = " + string);
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
























