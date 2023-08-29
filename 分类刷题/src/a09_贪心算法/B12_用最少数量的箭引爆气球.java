package a09_贪心算法;

import java.util.Arrays;

/**
 * @author: fosss
 * Date: 2023/8/29
 * Time: 10:19
 * Description:
 * https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 * 示例 1：
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 * 示例 2：
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 示例 3：
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 示例 4：
 * 输入：points = [[1,2]]
 * 输出：1
 * 示例 5：
 * 输入：points = [[2,3],[2,3]]
 * 输出：1
 * 提示：
 * 0 <= points.length <= 10^4
 * points[i].length == 2
 * -2^31 <= xstart < xend <= 2^31 - 1
 */
public class B12_用最少数量的箭引爆气球 {

    public static void main(String[] args) {
        B12_用最少数量的箭引爆气球 test = new B12_用最少数量的箭引爆气球();
        int[][] points = {
                {-2147483646, -2147483645},
                {2147483646, 2147483647}
        };
        int res = test.findMinArrowShots(points);
        System.out.println("res = " + res);
    }

    /**
     * 局部最优：当气球出现重叠，一起射，所用弓箭最少。全局最优：把所有气球射爆所用弓箭最少。
     */
    public int findMinArrowShots(int[][] points) {
        //先排序，按照左边界从小到大排序。TODO 需要注意不能直接a[0] - b[0]（原因：如果a[0]-b[0]结果超出int的范围，结果就有问题），所以应该换种方式比较大小
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        //记录所需箭数
        int res = 0;
        //从第二个箭开始，查看与前一个箭的重叠情况
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {
                //i的左边界>i-1的右边界，说明两箭无重叠，需要多加一只箭
                res++;
            } else {
                //两箭有重叠，将i右边界改为重叠部分的右边界
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }

        return res;
    }
}

