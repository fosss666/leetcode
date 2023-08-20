package a09_贪心算法;

/**
 * @author: fosss
 * Date: 2023/8/20
 * Time: 14:30
 * Description:
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。从下标为 0 跳到下标为 1 的位置，跳  1  步，然后跳  3  步到达数组的最后一个位置。
 * 说明: 假设你总是可以到达数组的最后一个位置。
 */
public class B06_跳跃游戏2 {

    /**
     * 在一步距离内（[i~curDistance]）对每个i寻找下一步可以覆盖的最大距离（i+nums[i]）。
     * 每走完一步（i==curDistance），步数+1，判断最大覆盖距离是否达到数组长度
     */
    public int jump(int[] nums) {
        //起始位置为nums[0]，如果数组只有一个元素，则不需要跳跃。返回0步
        if (nums.length == 1) return 0;
        //记录当前可以覆盖的距离
        int curDistance = 0;
        //记录下一步跳跃可以覆盖的最大距离，注意这一步不一定是在curDistance开始的
        int nextDistance = 0;
        int steps = 0;
        for (int i = 0; i < nums.length; i++) {
            //更新下一步可以覆盖的最大距离
            nextDistance = Math.max(nextDistance, i + nums[i]);
            //查询完[i~curDistance]后，相当于走完了一步，steps++。判断nextDistance是否能走完，能则退出循环。更新当前可以覆盖的距离为
            //nextDistance，从而进行下一轮循环
            if (i == curDistance) {
                steps++;
                curDistance = nextDistance;
                if (nextDistance >= nums.length - 1) break;
            }
        }
        return steps;
    }
}
