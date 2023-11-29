package a12_图论;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: fosss
 * Date: 2023/11/29
 * Time: 20:06
 * Description: https://leetcode.cn/problems/word-ladder/description/
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
 * 序列中第一个单词是 beginWord 。
 * 序列中最后一个单词是 endWord 。
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典 wordList 中的单词。
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。
 * 示例 1：
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * 示例 2：
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 */
public class B08_单词接龙 {
    /**
     * 将每个单词看作图的顶点，只要单词之间只差一个字母，则两个单词之间有路径，本题相当于无向图求最短路径，用BFS比较合适，BFS只要找到就
     * 是最短的
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //！！！将单词列表转为set，提高查询速度，否则该代码超时
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        //记录每个单词是否被访问过，防止出现死循环。同时记录当前路径长度，所以用map
        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            //获取当前单词的路径长度
            Integer pathLen = map.get(word);
            //遍历当前单词的每个字符
            for (int i = 0; i < word.length(); i++) {
                //这个转换要放到这个位置，因为下一个循环时，chars又恢复到word的字符了，那个被替换的字符就不会影响到数组
                char[] chars = word.toCharArray();
                //每个字符都要换成其他字符，然后看看新组成的单词是否存在于单词列表
                for (char j = 'a'; j <= 'z'; j++) {
                    //替换
                    chars[i] = j;
                    //组成新单词
                    String newWord = String.valueOf(chars);
                    //如果存在，并且这个单词没被访问过
                    if (set.contains(newWord) && !map.containsKey(newWord)) {
                        //是不是最终目标
                        if (newWord.equals(endWord)) return pathLen + 1;//直接返回
                        //放入队列
                        queue.add(newWord);
                        //添加记录
                        map.put(newWord, pathLen + 1);
                    }
                }
            }
        }
        //没找到
        return 0;
    }

    public static void main(String[] args) {
        B08_单词接龙 test = new B08_单词接龙();
        String[] s = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> collect = Arrays.stream(s).collect(Collectors.toList());
        test.ladderLength("hit", "cog", collect);
    }
}
