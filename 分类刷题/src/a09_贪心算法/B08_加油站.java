package a09_贪心算法;

/**
 * @author: fosss
 * Date: 2023/8/26
 * Time: 13:36
 * Description:
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * 说明:
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * 示例 1: 输入:
 * gas = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * 输出: 3 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2: 输入:
 * gas = [2,3,4]
 * cost = [3,4,3]
 * 输出: -1
 * 解释: 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 =
 * 0 + 4 = 4 升汽油。开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油。开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油。你无法返回 2
 * 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。因此，无论怎样，你都不可能绕环路行驶一周。
 */
public class B08_加油站 {

    /**
     * 暴力解法——超时
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //分别模拟从每个加油站出发的场景，试试能否走完
        for (int i = 0; i < gas.length; i++) {
            int carGas = gas[i] - cost[i];//初始油量
            //判断能否走到下一站，不能则直接进入下个循环
            if (carGas < 0) continue;
            //标记走到哪个加油站
            int index = i;//从i出发，
            //count为走过的加油站的数量
            for (int count = 1; count <= gas.length; count++) {
                //更新当前站下标
                index = (index + 1) % gas.length;
                //更新油量
                carGas = carGas + gas[index] - cost[index];
                //油量不足则退出循环
                if (carGas < 0) break;
                //走过gas.length个加油站，说明找到了合适的路线，出发站为i
                if (count == gas.length) return i;
            }
        }
        //没有合适的路线
        return -1;
    }

    /**
     * 贪心解法一
     * 直接从全局进行贪心选择，情况如下：
     * 情况一：如果gas的总和小于cost总和，那么无论从哪里出发，一定是跑不了一圈的
     * 情况二：rest[i] = gas[i]-cost[i]为一天剩下的油，i从0开始计算累加到最后一站，如果累加没有出现负数，说明从0出发，油就没有断过，那么0就是起点。
     * 情况三：如果累加的最小值是负数，汽车就要从非0节点出发，从后向前（画图理解为什么是从后向前），看哪个节点能把这个负数填平，能把这个负数填平的节点就是出发节点。
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        //看看总油量和总消耗量的差是否小于零，记录从下标0处出发油差累加最小值
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            int rest = gas[i] - cost[i];
            sum += rest;
            min = Math.min(min, sum);
        }
        //情况一
        if (sum < 0) return -1;
        //情况二
        if (min >= 0) return 0;
        //情况三，累加最小值min是负数。从后往前查找，
        for (int i = gas.length - 1; i > 0; i--) {
            int res = gas[i] - cost[i];
            min += res;
            if (min >= 0) return i;
        }
        return -1;
    }

    /**
     * 贪心解法二——最佳解法
     * 首先如果总油量减去总消耗大于等于零那么一定可以跑完一圈，说明 各个站点的加油站 剩油量rest[i]相加一定是大于等于零的。
     * 每个加油站的剩余量rest[i]为gas[i] - cost[i]。
     * i从0开始累加rest[i]，和记为curSum，一旦curSum小于零，说明[0, i]区间都不能作为起始位置，因为这个区间选择任何一个位置作为起点，到i这里
     * 都会断油，那么起始位置从i+1算起，再从0计算curSum。
     */
    public int canCompleteCircuit3(int[] gas, int[] cost) {
        int sum = 0;
        int curSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            //下标为i这站的剩油量
            int rest = gas[i] - cost[i];
            //总剩油量，即总油量-总耗油量
            sum += rest;
            //从起始站开始计算的剩油量和
            curSum += rest;
            //判断当前curSum是否小于0,小于0则更新起始站坐标和从起始站开始计算的剩油量和
            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }
        //判断总剩油量。需要注意的是，如果最后一个加油站当前剩油量<0的话（curSum<0），则sum也一定是<0的，所以用一个条件判断就行
        //if (sum < 0 || start == gas.length) return -1;
        if (sum < 0) return -1;
        return start;
    }
}
















