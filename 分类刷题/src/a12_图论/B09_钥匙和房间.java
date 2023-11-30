package a12_图论;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: fosss
 * Date: 2023/11/30
 * Time: 15:02
 * Description: https://leetcode.cn/problems/keys-and-rooms/description/
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中
 * N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 * 你可以自由地在房间之间来回走动。
 * 如果能进入每个房间返回 true，否则返回 false。
 * 示例 1：
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释: 我们从 0 号房间开始，拿到钥匙 1。 之后我们去 1 号房间，拿到钥匙 2。 然后我们去 2 号房间，拿到钥匙 3。 最后我们去了 3 号房间。 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 */
public class B09_钥匙和房间 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //标记第i个房间是否被访问过
        boolean[] isVisited = new boolean[rooms.size()];
        //一开始拥有第0处房间的钥匙
        dfs(rooms, 0, isVisited);
        //判断是否所有的房间都被访问过
        for (boolean b : isVisited) {
            if (!b) return false;
        }
        return true;
    }

    /**
     * 深搜
     */
    private void dfs(List<List<Integer>> rooms, int key, boolean[] isVisited) {
        //设置为已访问
        isVisited[key] = true;
        //获取钥匙
        List<Integer> keys = rooms.get(key);
        for (Integer k : keys) {
            //如果k这个房间没访问过，则dfs。这个判断相当于递归结束条件，也可以在方法第一行进行判断
            if (!isVisited[k]) dfs(rooms, k, isVisited);
        }
    }

    /**
     * 广搜
     */
    private void bfs(List<List<Integer>> rooms, int key, boolean[] isVisited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(key);
        isVisited[key] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<Integer> keys = rooms.get(poll);
            for (Integer k : keys) {
                if (!isVisited[k]) {
                    queue.add(k);
                    isVisited[k] = true;
                }
            }
        }
    }
}
