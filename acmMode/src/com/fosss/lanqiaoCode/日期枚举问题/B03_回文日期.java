package com.fosss.lanqiaoCode.日期枚举问题;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author: fosss
 * Date: 2023/11/11
 * Time: 14:54
 * Description:
 * 2020 年春节期间，有一个特殊的日期引起了大家的注意:2020年2月2日。因为如果将这个日期按“yyyyMMdd"的格式写成一个8 位数
 * 是20200202，怡好是一个回文数。我们称这样的日期是回文日期。有人表示20200202 是“千年一课”的特殊日子。对此小明很不认同
 * 因为不到2 年之后就是下一个回文日期:20211202即2021年12月2日、也有人表示20200202并不仅仅是一个回文日期，还是一个
 * ABABBABA型的回文日期。对此小明也不认同，因为大约 100年后就能遇到下一个ABABBABA型的回文日期: 21211212即2121年12
 * 月12日。算不上"千年-遇"，顶多算"千年两遇"给定一个8位数的日期，请你计算该日期之后下一个回文日期和下一
 * 个ABABBABA型的回文日期各是哪一天
 * <p>
 * 输入描述
 * 输入包含一个八位整数了，表示日期对于所有评测用例，10000101< <89991231，保证I 是一个合法日期的8位数表示
 * <p>
 * 输出描述
 * 输出两行，每行1个八位数。第一行表示下一个回文目期，第二行表示下一个ABABBABA型的回文目期。
 * <p>
 * 示例：
 * 输入：
 * 20200202
 * 输出：
 * 20211202
 * 21211212
 */
public class B03_回文日期 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        String input = scan.next();
        LocalDate date = LocalDate.of(Integer.parseInt(input.substring(0, 4)),
                Integer.parseInt(input.substring(4, 6)),
                Integer.parseInt(input.substring(6)));
        //从下一天开始!!
        date = date.plusDays(1);
        String s = dateFormat(date);
        int huiwenCount = 0;
        int properCount = 0;
        while (true) {
            if (isHuiwen(s) && huiwenCount == 0) {
                System.out.println(s);
                huiwenCount++;
            }
            if (isProper(s) && properCount == 0) {
                System.out.println(s);
                properCount++;
            }
            if (huiwenCount > 0 && properCount > 0) break;

            date = date.plusDays(1);
            s = dateFormat(date);
        }

        scan.close();
    }

    /**
     * 将日期转成yyyyMMdd形式
     */
    private static String dateFormat(LocalDate date) {
        String month = date.getMonthValue() < 10 ? ("0" + date.getMonthValue()) : "" + date.getMonthValue();
        String day = date.getDayOfMonth() < 10 ? ("0" + date.getDayOfMonth()) : "" + date.getDayOfMonth();
        return date.getYear() + month + day;
    }

    /**
     * 判断是不是回文串
     */
    private static boolean isHuiwen(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    /**
     * 判断是不是ABABBABA型
     */
    private static boolean isProper(String s) {
        char[] chars = s.toCharArray();
        return chars[0] == chars[2] && chars[0] == chars[5] && chars[0] == chars[7]
                && chars[1] == chars[3] && chars[1] == chars[4] && chars[1] == chars[6];
    }
}
