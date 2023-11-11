package com.fosss.日期枚举问题.test;

import java.time.LocalDate;

/**
 * @author: fosss
 * Date: 2023/11/11
 * Time: 14:14
 * Description:
 * 小明特别喜欢顺子。顺子指的就是连续的三个数字:123、456等。顺子
 * 目期指的就是在日期的yyyymmdd 表示法中，存在任意连续的三位数是
 * 一个顺子的日期。例如 20220123 就是一个顺子日期，因为它出现了一
 * 个顺子: 123;而20221023 则不是一个顺子日期，它一个顺子也没
 * 有。小明想知道在整个2022年份中，一共有多少个顺子日期？
 */
public class B02_顺子问题 {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2022, 1, 1);
        LocalDate end = LocalDate.of(2022, 12, 31);
        int count = 0;
        while (!start.isAfter(end)) {
            if (isProper(start)) count++;
            start = start.plusDays(1);
        }
        System.out.println(count);
    }

    /**
     * 判断一个日期是不是顺子日期
     */
    private static boolean isProper(LocalDate date) {
        //将年月日拼成字符串，注意2022-3-4这种应该拼接成2022-03-04这种形式
        String month = date.getMonthValue() < 10 ? ("0" + date.getMonthValue()) : "" + date.getMonthValue();
        String day = date.getDayOfMonth() < 10 ? ("0" + date.getDayOfMonth()) : "" + date.getDayOfMonth();
        String s = String.valueOf(date.getYear()) + month + day;
        for (int i = 2; i < s.length(); i++) {
            int a = s.charAt(i - 2) - '0';
            int b = s.charAt(i - 1) - '0';
            int c = s.charAt(i) - '0';
            if (b == a + 1 && c == b + 1) return true;
        }
        return false;
    }
}
