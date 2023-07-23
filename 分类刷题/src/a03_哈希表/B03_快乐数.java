package a03_哈希表;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: fosss
 * Date: 2023/7/23
 * Time: 19:00
 * Description:
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * 示例：
 * 输入：19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class B03_快乐数 {

    public static void main(String[] args) {
        boolean res = isHappy(19);
        System.out.println("res = " + res);
    }

    /**
     * 用set来判断和是否出现过，如果出现过，说明已经是无限循环了，返回false
     */
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int sum = getSum(n);
            if (sum == 1) {
                return true;
            }
            if (set.contains(sum)) {
                //说明进入了无限循环
                return false;
            }
            //放到set中
            set.add(sum);
            //更新n的值，用于下次判断
            n = sum;
        }
    }

    //求一个数各位的平方和
    private static int getSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += (num % 10) * (num % 10);
            num /= 10;
        }
        return sum;
    }
}



















