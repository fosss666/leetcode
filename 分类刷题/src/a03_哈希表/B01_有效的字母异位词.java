package a03_哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: fosss
 * Date: 2023/7/23
 * Time: 17:08
 * Description:
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 */
public class B01_有效的字母异位词 {

    /**
     * 用一个数组来记录，遍历第一个字符串，执行+1操作；遍历第二个字符串执行-1操作。最后看看数组中有没有不为零的值
     */
    public boolean isAnagram2(String s, String t) {
        //创建大小为26的数组
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;//妙啊
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 暴力循环记录
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map1.containsKey(c)) {
                map1.put(c, map1.get(c) + 1);
            } else {
                map1.put(c, 1);
            }
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map2.containsKey(c)) {
                map2.put(c, map2.get(c) + 1);
            } else {
                map2.put(c, 1);
            }

        }

        for (Character c : map1.keySet()) {
            if (!map1.get(c).equals(map2.get(c))) {
                return false;
            }
        }
        return true;
    }
}
