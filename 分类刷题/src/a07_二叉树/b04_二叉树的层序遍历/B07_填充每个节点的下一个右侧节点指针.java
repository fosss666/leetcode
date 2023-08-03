package a07_二叉树.b04_二叉树的层序遍历;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: fosss
 * Date: 2023/8/3
 * Time: 16:58
 * Description:
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct B07_Node {
 * int val;
 * B07_Node *left;
 * B07_Node *right;
 * B07_Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有next 指针都被设置为 NULL。
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 */
public class B07_填充每个节点的下一个右侧节点指针 {

    /**
     * 定义前驱节点
     */
    public B07_Node connect(B07_Node root) {
        if (root == null) return null;

        Queue<B07_Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            B07_Node pre = null;
            for (int i = queue.size(); i > 0; i--) {
                B07_Node cur = queue.poll();
                if (pre != null) pre.next = cur;
                pre = cur;

                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
        return root;
    }
}

class B07_Node {
    public int val;
    public B07_Node left;
    public B07_Node right;
    public B07_Node next;

    public B07_Node() {
    }

    public B07_Node(int _val) {
        val = _val;
    }

    public B07_Node(int _val, B07_Node _left, B07_Node _right, B07_Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};