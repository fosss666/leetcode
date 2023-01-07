package com.fosss.a10_2_青蛙跳台阶问题;
/**
 * @author fosss
 * date 2023/1/7
 * description：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 例：输入：n = 7 输出：21
 * 限制：0 <= n <= 100
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.numWays(7);
        System.out.println("i = " + i);
    }
    public int numWays(int n) {
        if(n==0||n==1){
            return 1;
        }else if(n==2){
            return 2;
        }
        int f1=1,f2 = 2,f3=0;
        for(int i=3;i<=n;i++){
            f3=(f1+f2)%1000000007;
            f1=f2;
            f2=f3;
        }
        return f3;
    }
}




















