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
        String string = demo.replaceSpace(s);
        System.out.println("string = " + string);
    }


    /**
     * 自解
     */
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }
}
























