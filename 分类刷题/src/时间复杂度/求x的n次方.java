package 时间复杂度;

/**
 * @author: fosss
 * Date: 2023/7/19
 * Time: 15:49
 * Description:
 */
public class 求x的n次方 {
    public static void main(String[] args) {
        System.out.println("f1(2,3) = " + f1(2, 3));
    }

    /**
     * 递归-时间复杂度为O(n)
     */
    public static int f1(int x, int n) {
        if (n == 0) return 1;
        if (n % 2 == 1) {
            return f1(x, n / 2) * f1(x, n / 2) * x;
        } else {
            return f1(x, n / 2) * f1(x, n / 2);
        }
    }

    /**
     * 递归-时间复杂度为O(logn)
     * 只有一次递归，每次n/2,所以2^t=n,t=以2为底n的对数
     */
    public static int f2(int x, int n) {
        if (n == 0) return 1;
        int t = f2(x, n / 2);
        if (t % 2 == 1) {
            return t * t * x;
        } else {
            return t * t;
        }
    }
}
