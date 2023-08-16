package a08_回溯算法;

import java.util.*;

/**
 * @author: fosss
 * Date: 2023/8/16
 * Time: 10:12
 * Description:
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个
 * 从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 * 提示：
 * 如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 所有的机票必须都用一次 且 只能用一次。
 * 示例 1：
 * 输入：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出：["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2：
 * 输入：[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 */
public class B13_重新安排行程 {

    public static void main(String[] args) {
        B13_重新安排行程 test = new B13_重新安排行程();
        List<List<String>> tickets = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("MUC");
        l1.add("LHR");
        List<String> l2 = new ArrayList<>();
        l2.add("JFK");
        l2.add("MUC");
        List<String> l3 = new ArrayList<>();
        l3.add("SFO");
        l3.add("SJC");
        List<String> l4 = new ArrayList<>();
        l4.add("LHR");
        l4.add("SFO");
        tickets.add(l1);
        tickets.add(l2);
        tickets.add(l3);
        tickets.add(l4);
        //for (List<String> ticket : tickets) {
        //    System.out.println(ticket);
        //}
        List<String> res = test.findItinerary(tickets);
        System.out.println(res);
    }

    /**
     * 使用Map<出发机场, map<到达机场, 航班次数>>，第二个map为自动排序的TreeMap来记录航班的映射关系
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        //将票的信息记录到targets中
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);//出发地
            String des = ticket.get(1);//目的地
            Map<String, Integer> map = targets.get(src);
            if (!targets.containsKey(src)) {
                //还未记录当前出发地
                map = new TreeMap<>();
                map.put(des, 1);
            } else {
                map.put(des, map.getOrDefault(des, 0) + 1);//为什么用getOrDefault。map不为空，但k未必是des可能是其他的，所以map.get(k)可能返回null
            }

            targets.put(src, map);
        }
        //System.out.println(targets);
        //从JFK开始
        res.add("JFK");
        //调用回溯算法，参数placeCount表示目的地数，比如三张票就有四个目的地（包含重复），递归结束需要这个参数
        //为什么这个回溯算法要有返回值呢？因为我们只需要找一条路径即可，不需要遍历整棵树，所以为了找到后就返回，需要有返回值
        boolean backtracking = backtracking(tickets.size() + 1);
        if (!backtracking) {
            //返回false说明没有合适的路线，将路线置空
            res.clear();
        }
        return res;
    }

    Map<String, Map<String, Integer>> targets = new HashMap<>();
    List<String> res = new ArrayList<>();

    private boolean backtracking(int placeCount) {
        //递归结束条件，目的地已经都遍历到
        if (res.size() == placeCount) {
            return true;
        }

        //找上一站的地址
        String previousStop = res.get(res.size() - 1);
        //从映射表中从previoutStop出发的票
        if (targets.containsKey(previousStop)) {
            Map<String, Integer> tickets = targets.get(previousStop);
            //获取每张票，如果票的航班次数大于0，就用这张票，否则寻找下一张
            Set<String> eachTicket = tickets.keySet();
            for (String ticket : eachTicket) {
                Integer count = tickets.get(ticket);
                if (count > 0) {
                    //添加路径
                    res.add(ticket);
                    //修改该票的航班次数
                    tickets.put(ticket, count - 1);
                    boolean backtracking = backtracking(placeCount);
                    //找到了，直接返回
                    if (backtracking) return true;
                    //回溯
                    tickets.put(ticket, count);
                    res.remove(res.size() - 1);
                }
            }
        }
        //没找到
        return false;
    }
}











