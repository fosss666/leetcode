package a03_哈希表;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: fosss
 * Date: 2023/7/23
 * Time: 17:55
 * Description:
 * 题意：给定两个数组，编写一个函数来计算它们的交集。
 */
public class B02_两个数组的交集 {

    /**
     * 用set来去重
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int n : nums1) {
            set.add(n);
        }
        for (int n : nums2) {
            if (set.contains(n)) {
                res.add(n);
            }
        }
        return res.stream().mapToInt(x -> x).toArray();
    }
}






