package a10_动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/9/9
 * Time: 12:55
 * Description:
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * 示例：
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 一共有5种方法让最终目标和为3。
 * 提示：
 * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 */
public class B12_目标和 {

    /**
     * 将数组中每个数分配好符号后，有的数前面是➖，有的数前面是➕，将数组中的数按照符号类型分成两部分，left为正数和，right为符号为➖的数之和，这
     * 样就可以写出公式：target = left - right  ①
     * 数组中所有数的和记为sum，∵ left+right=sum ∴ right=sum-left ∴ ①式可写成：left - (sum-left) =target 即：left= (sum+target)/2
     * 因此，只要找到和为left的那部分数即可。
     * 从数组中找和为一定值的数，可以采用两种方式，一种类似回溯算法中的B04_数组组合，通过回溯算法遍历查找，但这样非常慢；另一种就是动规。
     */
    public int findTargetSumWays(int[] nums, int target) {
        //求sum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //判断，target绝对值比sum都大，肯定找不到
        if (Math.abs(target) > sum) return 0;
        //只有sum与target奇偶性相同时，才会有符合条件的值，如：sum=5,target=2,就找不到
        if ((sum + target) % 2 != 0) return 0;
        //求left
        int left = (sum + target) / 2;

        //dp[i][j]表示遍历到下标为i的物品，背包容量为j，方法有dp[i][j]种
        int[][] dp = new int[nums.length][left + 1];
        //初始化下标为0的物品那一行，此物品质量为nums[0]，当背包容量j正好与其相等时，说明有一种方法，否则都为0
        for (int i = 0; i < dp[0].length; i++) {
            if (nums[0] == i) dp[0][i] = 1;
        }
        // 初始化最左列（dp[i][0])
        // 当从nums数组的索引0到i的部分有n个0时（n > 0)，每个0可以取+/-，因此有2的n次方中可以取到j = 0的方案
        // n = 0说明当前遍历到的数组部分没有0全为正数，因此只有一种方案可以取到j = 0（就是所有数都不取）
        int n = 0;
        for (int i = 0; i < dp.length; i++) {
            if (nums[i] == 0) n++;
            dp[i][0] = (int) Math.pow(2, n);
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //可以将nums[i]放入背包中，则方法数量得在没放入这个值时的方法数基础上加上j-nums[i]的方法数量
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][left];
    }

    /**
     * 滚动数组实现dp
     */
    public int findTargetSumWays2(int[] nums, int target) {
        //求sum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //判断，target绝对值比sum都大，肯定找不到
        if (Math.abs(target) > sum) return 0;
        //只有sum与target奇偶性相同时，才会有符合条件的值，如：sum=5,target=2,就找不到
        if ((sum + target) % 2 != 0) return 0;
        //求left
        int left = (sum + target) / 2;

        //dp[i]表示背包容量为i，方法有dp[i]种
        int[] dp = new int[left + 1];
        //递推公式：dp[i]+=dp[i-nums[i]]
        //初始化，从递推公式可以看出，在初始化的时候dp[0] 一定要初始化为1，因为dp[0]是在公式中一切递推结果的起源，如果dp[0]是0的话，递推结果将
        //都是0。其实不要硬去解释它的含义，咱就把 dp[0]的情况带入本题看看应该等于多少。如果数组[0] ，target = 0，那么
        //bagSize = (target + sum) / 2 = 0。 dp[0]也应该是1， 也就是说给数组里的元素 0 前面无论放加法还是减法，都是 1 种方法。
        //所以本题我们应该初始化 dp[0] 为 1
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[left];
    }

    /**
     * 回溯法——非常慢，不推荐
     */
    public Integer findTargetSumWays3(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if (target > sum) return 0; // 此时没有方案
        if ((target + sum) % 2 != 0) return 0; // 此时没有方案，两个int相加的时候要各位小心数值溢出的问题
        int left = (target + sum) / 2; // 转变为组合总和问题，left就是要求的和
        //将数组排序
        Arrays.sort(nums);
        backtracking(nums, left, 0);
        return res.size();
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    private void backtracking(int[] nums, int target, int startIndex) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }

        //对于升序排列的数组，如果target - nums[i]<0，由于i后边的数都大于i所以就不用进行后面的循环了
        for (int i = startIndex; i < nums.length && target - nums[i] >= 0; i++) {
            path.add(nums[i]);
            backtracking(nums, target - nums[i], i + 1);
            path.remove(path.size() - 1);
        }
    }
}
