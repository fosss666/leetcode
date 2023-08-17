package a09_贪心算法;

import java.util.Arrays;

/**
 * @author: fosss
 * Date: 2023/8/17
 * Time: 17:55
 * Description:
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值  g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可
 * 以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 示例  1:
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1 解释:你有三个孩子和两块小饼干，3 个孩子的胃口值分别是：1,2,3。虽然你有两块小饼干，由于他们的尺寸都是 1，你只能让胃口值是 1 的孩子满
 * 足。所以你应该输出 1。
 * 示例  2:
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:你有两个孩子和三块小饼干，2 个孩子的胃口值分别是 1,2。你拥有的饼干数量和尺寸都足以让所有孩子满足。所以你应该输出 2.
 * 提示：
 * 1 <= g.length <= 3 * 10^4
 * 0 <= s.length <= 3 * 10^4
 * 1 <= g[i], s[j] <= 2^31 - 1
 */
public class B01_分发饼干 {

    public static void main(String[] args) {
        int[] g = {10, 9, 8, 7};
        int[] s = {5, 6, 7, 8};
        int res = findContentChildren(g, s);
        System.out.println("res = " + res);
    }

    /**
     * 将胃口g，饼干大小s从小到大排序，遍历g，从s中尽可能找能符合g[i]的，才会去找g[i+1]的，即先满足小胃口，逐个满足大胃口，贪心思想
     */
    public static int findContentChildren(int[] g, int[] s) {
        //先对两个数组排序
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int count = 0;
        //遍历g   小饼干去满足小胃口
        for (int i = 0; i < g.length; i++) {
            //从s中找到合适的数
            while (j < s.length && s[j] < g[i]) {
                j++;
            }
            if (j == s.length) break;
            //找到了
            count++;
            j++;//此数已被用了
        }
        return count;
    }

    /**
     * 用胃口去找，先满足大胃口
     */
    public static int findContentChildren2(int[] g, int[] s) {
        //先对两个数组排序
        Arrays.sort(g);
        Arrays.sort(s);
        int j = s.length - 1;
        int count = 0;
        for (int i = g.length - 1; i >= 0; i--) {//胃口
            if (j >= 0 && s[j] >= g[i]) {//饼干
                count++;
                j--;
            }
        }
        return count;
    }
}
