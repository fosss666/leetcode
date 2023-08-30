package a09_贪心算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/8/30
 * Time: 17:53
 * Description:
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 */
public class B15_合并区间 {

    /**
     * 在原数组上修改
     * 还是区间重叠问题
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                //区间有重叠，进行合并
                intervals[i][0] = intervals[i - 1][0];
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            } else {
                //没有重叠，将上一个确定没有重叠的区间i-1加入集合，
                list.add(intervals[i - 1]);
            }
        }
        //添加最后一个区间
        list.add(intervals[intervals.length - 1]);

        return list.toArray(new int[list.size()][]);
    }

    /**
     * 不修改原数组
     */
    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                //没有重叠，将无重叠的区间放入集合，并更新起点
                list.add(new int[]{start, end});
                start = intervals[i][0];
            }
            end = Math.max(intervals[i][1], end);
        }
        //添加最后一个区间
        list.add(new int[]{start, end});

        return list.toArray(new int[list.size()][]);
    }
}
