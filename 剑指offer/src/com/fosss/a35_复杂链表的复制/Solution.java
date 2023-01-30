package com.fosss.a35_复杂链表的复制;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fosss
 * @date 2023/1/30
 * @description： 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的
 * 任意节点或者 null
 * 示例：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]  输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * <p>
 * 提示：
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000
 */
public class Solution {


    /**
     * 哈希表
     * 构建原链表和新链表结点一一对应的键值对
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(head.val));
            temp = temp.next;
        }
        //一一复制
        temp = head;
        while (temp != null) {
            //妙啊
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}





















