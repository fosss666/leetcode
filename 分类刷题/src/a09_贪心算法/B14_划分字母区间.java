package a09_贪心算法;

import java.util.*;

/**
 * @author: fosss
 * Date: 2023/8/30
 * Time: 8:01
 * Description:
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * 示例：
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8] 解释： 划分结果为 "ababcbaca", "defegde", "hijhklij"。 每个字母最多出现在一个片段中。 像 "ababcbacadefegde",
 * "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * 提示：
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 */
public class B14_划分字母区间 {

    public static void main(String[] args) {
        B14_划分字母区间 test = new B14_划分字母区间();
        test.partitionLabels2("ababcbacadefegdehijhklij");
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        //先获取每个字母的右边界
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], i);
        }

        //当遍历到的下边==最大边界时，记录一次长度
        int start = 0;
        int maxEdge = 0;
        for (int i = 0; i < chars.length; i++) {
            maxEdge = Math.max(maxEdge, map.get(chars[i]));
            if (maxEdge == i) {
                res.add(maxEdge - start + 1);
                //更新起点为下一个字符的下标
                start = i + 1;
            }
        }
        return res;
    }

    /**
     * 类似于`用最少数量的箭引爆气球`与`无重叠区间`两题的思路，先统计每个字符出现的右边界，然后组装每个字符的左右边界，根据字符区间的无重叠来处理
     */
    public int[][] findPartitions(String s) {
        //26个字母2列 表示该字母对应的区间
        //最多s中可能出现26个字符，但有可能不够26，即hash只会前几行有记录的左右边界，后几行都是两列都是0。对于这些没用的数据，不需要去掉，因为在使用
        //这个hash时，只会使用s.length()行，即后面那些没用的数据不会访问到。
        int[][] hash = new int[26][2];

        for (int i = 0; i < s.length(); i++) {
            //更新字符c对应的位置i
            char c = s.charAt(i);
            if (hash[c - 'a'][0] == 0) hash[c - 'a'][0] = i;
            hash[c - 'a'][1] = i;
            //第一个元素区别对待一下
            hash[s.charAt(0) - 'a'][0] = 0;
        }
        return hash;
    }


    public List<Integer> partitionLabels2(String s) {
        int[][] partitions = findPartitions(s);

        List<Integer> res = new ArrayList<>();
        //按照左边界从小到大排序
        Arrays.sort(partitions, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int right = partitions[0][1];
        int left = 0;
        for (int i = 0; i < partitions.length; i++) {
            if (partitions[i][0] > right) {
                //左边界大于右边界即可纪委一次分割
                res.add(right - left + 1);
                left = partitions[i][0];
            }
            right = Math.max(right, partitions[i][1]);
        }
        //最右端
        res.add((s.length() - 1) - left + 1);
        return res;
    }
}













