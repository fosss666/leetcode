package a09_贪心算法;

import java.util.Arrays;

/**
 * @author: fosss
 * Date: 2023/8/27
 * Time: 21:58
 * Description:
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * 示例 1:
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 */
public class B09_分发糖果 {

    public static void main(String[] args) {
        B09_分发糖果 test = new B09_分发糖果();
        int[] ratings = {1, 0, 2};
        int res = test.candy(ratings);
        System.out.println("res = " + res);
    }

    /**
     * 这道题目一定是要确定一边之后，再确定另一边，例如比较每一个孩子的左边，然后再比较右边，如果两边一起考虑一定会顾此失彼
     * 先从前向后遍历，判断后一个比前一个大的话，后一个的糖果修改成前一个+1。局部最优：如果ratings[i]>ratings[i-1]，则一定i糖果比i-1多
     * 再从后向前遍历，判断前一个比后一个大的话：如果糖果数也大，则不处理；反之，修改为后一个糖果数+1。局部最优：如果ratings[i]>ratings[i+1]，则一定i糖果比i+1多
     */
    public int candy(int[] ratings) {
        //记录各个孩子应该给的糖果数
        int[] candies = new int[ratings.length];
        //初始为1个
        Arrays.fill(candies, 1);
        //从左往右遍历，判断右是否>左
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
        }
        //从右往左遍历，判断左是否>右
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) candies[i] = candies[i + 1] + 1;
        }
        int sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }
}
