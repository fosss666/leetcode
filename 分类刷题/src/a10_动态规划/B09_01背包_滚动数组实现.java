package a10_动态规划;

/**
 * @author: fosss
 * Date: 2023/9/6
 * Time: 15:49
 * Description:
 * 有n件物品和一个最多能背重量为w 的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
 */
public class B09_01背包_滚动数组实现 {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int w = 4;
        B09_01背包_滚动数组实现 test = new B09_01背包_滚动数组实现();
        int res = test.bagProblem(weight, value, w);
        System.out.println("res = " + res);
    }

    /**
     * 二维数组的递推公式：dp[i][j]=Math.max( dp[i-1][j], value[i] + dp[i-1][j-weight[i]] )
     * 由公式可以发现dp[i-1]这一行完全可以用dp[i]代替，即只保留一行数据就行(当前循环时，dp[i]暂存的是上一循环的数据)，所以用一维数组代替二维数
     * 组，每遍历一个物品，就让一维数组更新为这个物品对应的每个背包容量对应的价值, 递推公式 dp[j]=Math.max( dp[j], value[i]+dp[j-weight[i]] )
     */
    public int bagProblem(int[] weight, int[] value, int w) {
        //dp[j]表示背包容量为i时，背包中物品的最大价值
        int[] dp = new int[w + 1];
        //初始化：还没放入物品时，背包中的价值都为0
        //遍历物品
        for (int i = 0; i < weight.length; i++) {
            //遍历背包容量，注意：应该按照容量从大到小遍历
            //原因：对于一个指定的物品i，倒序遍历是为了保证物品i只被放入一次！。但如果一旦正序遍历了，那么物品0就会被重复加入多次！
            //举一个例子：物品0的重量weight[0] = 1，价值value[0] = 15。如果正序遍历 dp[1] =Math.max(dp[1],dp[1 - weight[0]] + value[0])=
            //15；dp[2] = Math.max(dp[2],dp[2 - weight[0]] + value[0]) = 30。此时dp[2]就已经是30了，意味着物品0，被放入了两次，
            //所以不能正序遍历。为什么倒序遍历，就可以保证物品只放入一次呢？倒序就是先算dp[2]。dp[2] =
            // Math.max(dp[2],dp[2 - weight[0]] + value[0])= 15 （dp数组已经都初始化为0）；dp[1] = dp[1 - weight[0]] + value[0] = 15
            //所以从后往前循环，每次取得状态不会和之前取得状态重合，这样每种物品就只取一次了。
            //为什么二维dp数组历的时候不用倒序呢？
            //因为对于二维dp，dp[i][j]都是通过上一层即dp[i - 1][j]计算而来，本层的dp[i][j]并不会被覆盖！

            /*for(int j=w;j>=1;j--){
                if(j>weight[i]){
            }*/
            for (int j = w; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], value[i] + dp[j - weight[i]]);
            }
        }
        return dp[w];
    }
}
