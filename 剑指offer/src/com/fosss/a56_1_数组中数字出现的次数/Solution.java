package com.fosss.a56_1_数组中数字出现的次数;

import java.util.*;

/**
 * @author fosss
 * @date 2023/2/24
 * @description： 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间
 * 复杂度是O(1)
 * 例：输入：nums = [4,1,4,6] 输出：[1,6] 或 [6,1]
 * 限制：2 <= nums.length <= 10000
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 2};
        Solution solution = new Solution();
        int[] res = solution.singleNumbers3(nums);
        System.out.println("res = " + Arrays.toString(res));
    }

    /**
     * 位运算  100%
     * https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/jian-zhi-offer-56-i-shu-zu-zhong-shu-zi-tykom/
     */
    public int[] singleNumbers3(int[] nums) {
        //因为相同的数字异或为0，任何数字与0异或结果是其本身。
        //所以遍历异或整个数组最后得到的结果就是两个只出现一次的数字异或的结果：即 z = x ^ y
        int z = 0;
        for (int num : nums) {
            z ^= num;
        }
        //我们根据异或的性质可以知道：z中至少有一位是1，否则x与y就是相等的。
        //我们通过一个辅助变量m来保存z中哪一位为1.（可能有多个位都为1，我们找到最低位的1即可）。
        //举个例子：z = 10 ^ 2 = 1010 ^ 0010 = 1000,第四位为1.
        //我们将m初始化为1，如果（z & m）的结果等于0说明z的最低为是0
        //我们每次将m左移一位然后跟z做与操作，直到结果不为0.
        //此时m应该等于1000，同z一样，第四位为1.
        int m = 1;
        while ((z & m) == 0) {
            m <<= 1;
        }
        //我们遍历数组，将每个数跟m进行与操作，结果为0的作为一组，结果不为0的作为一组
        //例如对于数组：[1,2,10,4,1,4,3,3]，我们把每个数字跟1000做与操作，可以分为下面两组：
        //nums1存放结果为0的: [1, 2, 4, 1, 4, 3, 3]
        //nums2存放结果不为0的: [10] (碰巧nums2中只有一个10，如果原数组中的数字再大一些就不会这样了)
        //此时我们发现问题已经退化为数组中有一个数字只出现了一次
        //分别对nums1和nums2遍历异或就能得到我们预期的x和y
        int x = 0, y = 0;
        for (int num : nums) {
            //这里我们是通过if...else将nums分为了两组，一边遍历一遍异或。
            //跟我们创建俩数组nums1和nums2原理是一样的。
            if ((num & m) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }

    /**
     * 自解，先排序再判断 17%  18%
     */
    public int[] singleNumbers2(int[] nums) {
        //先排序
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 1;
        while (list.size() < 2 && i < nums.length && j < nums.length) {
            if (nums[i] != nums[j]) {
                //相邻两个数不同的话，说明前一个数时符合要求的
                list.add(nums[i]);
                //判断下一个数
                i++;
                j++;
            } else {
                //这两个数是不符合要求的，跳过这两个数
                i += 2;
                j = i + 1;
            }
        }
        //如果是这种情况 【1，4，4，6】，需要将最后一个数添加到集合中
        if (list.size() < 2) {
            list.add(nums[nums.length - 1]);
        }
        int[] res = new int[2];
        for (int i1 = 0; i1 < list.size(); i1++) {
            res[i1] = list.get(i1);
        }
        return res;
    }

    /**
     * 自解，map, 12%  18%
     */
    public int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.remove(num);
            } else {
                map.put(num, num);
            }
        }
        int[] res = new int[2];
        int i = 0;
        for (Integer integer : map.keySet()) {
            res[i++] = integer;
        }
        return res;
    }
}


























