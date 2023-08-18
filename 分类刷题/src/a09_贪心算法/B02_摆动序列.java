package a09_贪心算法;

/**
 * @author: fosss
 * Date: 2023/8/18
 * Time: 11:06
 * Description:
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3)  是正负交替出现的。相反, [1,4,7,2,5]  和  [1,7,4,5,5] 不是摆动序列，第
 * 一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 * 示例 1:
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 * 示例 2:
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 * 示例 3:
 * 输入: [1,2,3,4,5,6,7,8,9]
 * 输出: 2
 */
public class B02_摆动序列 {

    /**
     * 贪心
     * 关键在于满足什么条件时增加count
     */
    public int wiggleMaxLength(int[] nums) {
        //处理数组长度小于2的情况
        if (nums.length <= 1) return nums.length;
        //上一组的差
        int preDiff = 0;
        //这一组的差
        int curDiff = 0;
        //记录摆动序列长度
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            //更新当前差
            curDiff = nums[i] - nums[i - 1];
            //如果先上后下或先下后上则递增长度，=代表差为0平坡
            if (preDiff <= 0 && curDiff > 0 || preDiff >= 0 && curDiff < 0) {
                count++;
                //更新前一组的差
                preDiff = curDiff;
            }
        }
        return count;
    }

    /**
     * 动态规划
     * 对于每个位置（i），从0开始递推i分别作为波峰和波谷时摆动序列的最大长度，嵌套for
     */
    public int wiggleMaxLength2(int[] nums) {
        //dp[i][0]：i为波峰时摆动序列长度
        //dp[i][1]：i为波谷时摆动序列长度
        int[][] dp = new int[nums.length][2];
        //初始化0处为波峰
        dp[0][0] = 1;
        //初始化0处为波谷
        dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++) {
            //i自己可以为波峰或波谷
            dp[i][0] = dp[i][1] = 1;
            //从j到i去递推i为波峰和波谷两种情况分别的摆动序列的长度
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    //i为波峰，dp[j][1]+1表示将i与j为波谷的序列连接起来形成新的摆动序列后的长度
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }
                if (nums[i] < nums[j]) {
                    //i为波谷,dp[j][0]+1表示将i与j为波峰的序列连接起来去程新的序列后的长度
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
            }
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}











