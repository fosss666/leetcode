package com.fosss.kamaCoder.a_练习acm模式;

import java.util.Scanner;

/**
 * 题目描述：
 * 小明每天的话费是1元，运营商做活动，手机每充值K元就可以获赠1元话费，一开始小明充值M元，问最多可以用多少天？ 注意赠送的话费也可以参与到奖
 * 励规则中
 * <p>
 * 输入： 输入包括多个测试实例。每个测试实例包括2个整数M，K（2<=k<=M<=1000)。M=0，K=0代表输入结束。
 * <p>
 * 输出： 对于每个测试实例输出一个整数，表示M元可以用的天数。
 * <p>
 * 样例输入：
 * 2 2
 * 4 3
 * 13 3
 * 0 0
 * 样例输出：
 * 3
 * 5
 * 19
 * 提示：
 * 注意第三组数据「13 3」结果为什么是19呢， 13/3=4，获得4元奖励。 13%3=1，还剩下1元，4+1=5，5元继续参加奖励规则。 5/3=1，获得1元奖
 * 励。 5%3=2，剩下2元，1+2=3，3元继续参与奖励规则。 3/3=1，获得1元奖励。 3%3=0，剩下0元，1+0=1。 1元不能参与剩下奖励。所以一共可
 * 以使用的天数是 13+4+1+1=19
 */
public class B10_运营商活动 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int M = sc.nextInt();
            int K = sc.nextInt();
            if (M == 0 && K == 0) break;
            int res = M;
            int t = M;
            while (t / K > 0) {
                //t用来记录获得的奖励
                t /= K;
                res += t;
                //更新t
                t = t % K;
            }
            System.out.println(res);
        }
        sc.close();
    }
}