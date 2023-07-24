package a03_哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: fosss
 * Date: 2023/7/24
 * Time: 8:53
 * Description:
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * 注意：
 * 你可以假设两个字符串均只含有小写字母。
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class B06_赎金信 {

    /**
     * 数组解法  速度快
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
        //由题意分析，ransomNote的长度一定<=magazine，所以m的字符类型>=r，所以先记录m
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int j = ransomNote.charAt(i) - 'a';
            arr[j]--;
            if (arr[j] < 0) {
                //说明r中有m不存在的字符
                return false;
            }
        }
        return true;
    }

    /**
     * 解法类似于有效的字母异位词    map解法：使用map的空间消耗要比数组大一些的，因为map要维护红黑树或者哈希表，而且还要做哈希函数，是费时的！数据量大的话就能体现出来差别
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            //需要防止减多了
            if (map.containsKey(c) && map.get(c) != 0) {
                map.put(c, map.get(c) - 1);
            }
        }

        //获取map中所有值，如果全是零返回true
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}












