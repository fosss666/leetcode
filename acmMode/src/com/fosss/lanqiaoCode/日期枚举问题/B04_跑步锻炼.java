package com.fosss.lanqiaoCode.日期枚举问题;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author: fosss
 * Date: 2023/11/11
 * Time: 15:25
 * Description:
 * 小蓝每天都锻炼身体，正常情况下，小蓝每天跑1千米。如果某天是周一或者月初（1号），为了激励自己，小蓝要跑2千米。如果同时是周一和月初，小蓝
 * 也是跑2千米。小蓝跑步已经坚持了很长时间，从2000年1月1日周六（含）到2020年10月1日周四（含）。请问这段时间小蓝总共跑步多少千米？
 */
public class B04_跑步锻炼 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        LocalDate start = LocalDate.of(2000, 1, 1);
        LocalDate end = LocalDate.of(2020, 10, 1);
        int kilos = 0;
        while (!start.isAfter(end)) {
            kilos += start.getDayOfWeek().getValue() == 1 || start.getDayOfMonth() == 1 ? 2 : 1;
            start = start.plusDays(1);
        }
        System.out.println(kilos);
        scan.close();
    }
}
