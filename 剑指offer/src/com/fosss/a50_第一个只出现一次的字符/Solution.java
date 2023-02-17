package com.fosss.a50_第一个只出现一次的字符;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fosss
 * @date 2023/2/16
 * @description： 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母
 * 例：输入：s = "abaccdeff"  输出：'b'
 * 限制：0 <= s 的长度 <= 50000
 * 提示：这种是否重复的问题，可以考虑哈希表（HashMap是无序的）或LinkedHashSet
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char res = solution.firstUniqChar3("leetcode");
        System.out.println("res = " + res);
    }

    /**
     * 大佬map的值用布尔类型-很简洁
     */
    public char firstUniqChar4(String s) {
        //LinkedHashMap
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';

        //====HashMap=====
        //HashMap<Character, Boolean> dic = new HashMap<>();
        ////用一个数组保证返回时返回第一个值
        //char[] sc = s.toCharArray();
        //for(char c : sc)
        //    dic.put(c, !dic.containsKey(c));
        ////遍历数组,HashMap虽然是无序的，但是数组是有序的，map只用来取值就行了
        //for(char c : sc)
        //    if(dic.get(c)) return c;
        //return ' ';

    }

    /**
     * 自解，HashMap, 46%  45%
     * 注意，hashMap存入的键也不是有序存入的
     * LinkedHashMap 62%  66%
     */
    public char firstUniqChar3(String s) {

        //LinkedHashMap是有序的，不用再多余去寻找第一个符合条件的值了
        Map<Character, Integer> map = new LinkedHashMap<>();
        //hashMap
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                //值为-1代表是重复字符
                map.put(c, -1);
            } else {
                //值为0代表不是重复字符
                map.put(c, 0);
            }
        }
        //返回第一个符合条件的字符,值最小的且不为-1的即为所需值
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                return entry.getKey();
            }
        }
        return ' ';

        //Map<Character, Integer> map = new HashMap<>();
        ////hashMap存入的键也不是有序存入的，用i来找到第一个符合条件的值
        //int i = 0;
        //for (char c : s.toCharArray()) {
        //    if (map.containsKey(c)) {
        //        //值为-1代表是重复字符
        //        map.put(c, -1);
        //    } else {
        //        //值不为-1代表不是重复字符
        //        map.put(c, i);
        //        i++;
        //    }
        //}
        ////返回第一个符合条件的字符,值最小的且不为-1的即为所需值
        //int min = Integer.MAX_VALUE;
        //Character res = ' ';
        //for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        //    if (entry.getValue() < min && entry.getValue() != -1) {
        //        min = entry.getValue();
        //        res = entry.getKey();
        //    }
        //}
        //return res;
    }

    /**
     * 自解，LinkedHashSet, 5%  84%
     */
    public char firstUniqChar2(String s) {
        Set<Character> set = new LinkedHashSet<>();
        //用来保存已经重复的字符
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c) || list.contains(c)) {
                set.remove(c);
                if (!list.contains(c)) {
                    list.add(c);
                }
            } else {
                set.add(c);
            }
        }
        return set.isEmpty() ? ' ' : (char) set.toArray()[0];

    }

    /**
     * 自解，暴力遍历  5% 11%
     */
    public char firstUniqChar(String s) {
        if (s.length() == 1) {
            return s.charAt(0);
        }
        //转成集合，便于遍历和删除
        List<Character> list = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        //遍历集合,i用来遍历，j用来记录遍历开始的位置
        int i = 1, j = 0;
        while (j < list.size()) {

            if (list.get(i).equals(list.get(0))) {
                //字符相同，不符合要求，从集合中删除该字符
                int finalI = i;
                //这里要对list重新赋值
                List<Character> finalList = list;
                list = list.stream().filter((item) -> {
                    return !item.equals(finalList.get(finalI));
                }).collect(Collectors.toList());
                i = 1;
            } else {
                i++;
            }
            //如果i的长度达到集合长度，说明此时j处的字符是符合要求的，直接返回
            if (i == list.size()) {
                return list.get(j);
            }
        }
        //j的长度达到集合长度，说明没有符合要求的字符，返回空格
        return ' ';
    }
}


























