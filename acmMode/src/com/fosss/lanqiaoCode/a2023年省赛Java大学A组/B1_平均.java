package com.fosss.lanqiaoCode.a2023年省赛Java大学A组;

import java.util.*;

/**
 * @author: fosss
 * Date: 2023/11/21
 * Time: 20:41
 * 题目描述：
 * 有一个长度为 n 的数组（n 是 10 的倍数），每个数 ai 都是区间 [0, 9] 中的整数。小明发现数组里每种数出现的次数不太平均，
 * 而更改第 i 个数的代价为bi，他想更改若干个数的值使得这 10 种数出现的次数相等（都等于n/10），请问代价和最少为多少。
 * ·
 * 输入格式：
 * 输入的第一行包含一个正整数 n 。
 * 接下来 n 行，第 i 行包含两个整数 ai , bi ，用一个空格分隔。
 * ·
 * 输出格式：
 * 输出一行包含一个正整数表示答案。
 * ·
 * 样例输入：
 * 10
 * 1 1
 * 1 2
 * 1 3
 * 2 4
 * 2 5
 * 2 6
 * 3 7
 * 3 8
 * 3 9
 * 4 10
 * 样例输出：
 * 27
 * 提示：
 * 只更改第 1, 2, 4, 5, 7, 8 个数，需要花费代价 1 + 2 + 4 + 5 + 7 + 8 = 27 。
 * 对于 20% 的评测用例，n ≤ 1000；对于所有评测用例，n ≤ 100000, 0 < bi ≤ 2 × 105 。
 */
public class B1_平均 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int sum = 0;
            int n = sc.nextInt();
            //记录每个数及代价
            Map<Integer, List<Integer>> map = new HashMap<>();
            //记录每种数最终需要出现的次数
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (!map.containsKey(a)) map.put(a, new ArrayList<>());
                map.get(a).add(b);
                arr[a]++;
            }
            //统计代价
            for (int i = 0; i < n; i++) {
                int len = arr[i];
                //将有代价的数的代价从小到大排序
                if (map.containsKey(i)) Collections.sort(map.get(i));
                if (len > n / 10) {
                    for (int j = 0; j < len - n / 10; j++) {
                        sum += map.get(i).get(j);
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
