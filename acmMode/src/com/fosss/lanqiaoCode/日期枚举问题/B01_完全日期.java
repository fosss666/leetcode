package com.fosss.lanqiaoCode.日期枚举问题;

import java.time.LocalDate;

/**
 * @author: fosss
 * Date: 2023/11/10
 * Time: 22:06
 * Description:
 * 日期枚举问题
 * 题目描述：
 * 本题为填空题，只需要算出结果后，在代码中使用输出语句将
 * 所填结果输出即可。
 * 如果一个日期中年月日的各位数字之和是完全平方数，则称为
 * 一个完全日期。
 * 例如:2021年6月5日的各位数字之和为20十2
 * 1十6十5=16，而16是一个完全平方数，它是4的平
 * 方。所以2021年6月5日是一个完全日期。
 * 例如:2021年6月23日的各位数字之和为202
 * 1623=16是一个完全平方数。所以2021年6
 * 月23日也是一个完全日期。
 * 请问，从2001年1月1日到2021年12月31日中，一共
 * 有多少个完全日期？
 * 运行限制
 * 最大运行时间: 1s
 * 最大运行内存:128M
 */
public class B01_完全日期 {

    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2001, 1, 1);
        LocalDate end = LocalDate.of(2021, 12, 31);
        int count = 0;
        while (!start.isAfter(end)) {
            if (isProper(start.getYear(), start.getMonthValue(), start.getDayOfMonth())) count++;
            start = start.plusDays(1);
        }
        System.out.println(count);
    }

    /**
     * 判断是不是完全平方数
     */
    private static boolean isProper(int year, int month, int day) {
        int sum = 0;
        while (year > 0) {
            sum += year % 10;
            year /= 10;
        }
        while (month > 0) {
            sum += month % 10;
            month /= 10;
        }
        while (day > 0) {
            sum += day % 10;
            day /= 10;
        }
        return Math.pow((int) Math.sqrt(sum), 2) == sum;
    }
}
