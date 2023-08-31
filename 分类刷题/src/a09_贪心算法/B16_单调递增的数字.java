package a09_贪心算法;

/**
 * @author: fosss
 * Date: 2023/8/31
 * Time: 9:21
 * Description:
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * 示例 1:
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 */
public class B16_单调递增的数字 {

    public static void main(String[] args) {
        B16_单调递增的数字 test = new B16_单调递增的数字();
        int res = test.monotoneIncreasingDigits2(100);
        System.out.println("res = " + res);
    }

    /**
     * 暴力解法——超时
     */
    public int monotoneIncreasingDigits(int n) {
        while (!isIncreasing(n)) {
            n--;
        }
        return n;
    }

    //检查数字是否递增
    private boolean isIncreasing(int num) {
        int max = 10;
        while (num != 0) {
            int i = num % 10;
            if (i <= max) {
                max = i;
            } else {
                return false;
            }
            num /= 10;
        }
        return true;
    }

    /**
     * 贪心——从后向前判断，当num不符合递增时，num--，它的后边所有位都变成9
     */
    public int monotoneIncreasingDigits2(int n) {
        //转成字符数组好操作
        char[] chars = (n + "").toCharArray();
        //从后向前遍历，找到从哪位开始，后边所有位都变成9
        int index = chars.length;
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                index = i + 1;
                chars[i] -= 1;
            }
        }

        for (int i = index; i < chars.length; i++) chars[i] = '9';

        //统计数字大小
        int res = 0;
        for (char c : chars) {
            res = res * 10 + (c - '0');
        }
        return res;
    }

    /**
     * 与上解思路相同，用构造方法代替最后统计数字大小的for循环
     */
    public int monotoneIncreasingDigits3(int n) {
        //转成字符数组好操作
        char[] chars = (n + "").toCharArray();
        //从后向前遍历，找到从哪位开始，后边所有位都变成9
        int index = chars.length;
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                index = i + 1;
                chars[i] -= 1;
            }
        }

        for (int i = index; i < chars.length; i++) chars[i] = '9';

        return Integer.parseInt(String.valueOf(chars));
    }
}










