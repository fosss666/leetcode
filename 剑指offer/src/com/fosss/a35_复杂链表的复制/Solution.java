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
 * <p>
 * 思考：
 * 1.借用哈希表，遍历链表，以结点为key,new 结点（结点值）为值存入map中，然后从新遍历链表，设置每个值的next(map.get(tmp.next))和
 * random(map.get(tmp.random))
 * 2.拼接拆分，先构建next；再构建random，构建random和构建next不能公用一个while循环，因为构建random必须在链表完整时；再进行拆分。因为
 * 不能改变原链表，所以应该将原链表和复制的链表都单独拆分出来
 */
public class Solution {


    /**
     * 拼接拆分
     * 考虑构建 原节点 1 -> 新节点 1 -> 原节点 2 -> 新节点 2 -> …… 的拼接链表，如此便可在访问原节点的 random 指向节点的同时找到新对应新节
     * 点的 random 指向节点
     */
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        //拼接
        Node temp = head;
        while (temp != null) {
            Node next = temp.next;//存下来
            temp.next = new Node(temp.val);//拼接的时候一定要new
            temp.next.next = next;
            temp = next;
        }
        //构建random
        temp = head;
        while (temp != null) {
            temp.next.random = temp.random == null ? null : temp.random.next;
            temp = temp.next.next;
        }

        //拆分,将链表拆分成原链表和复制的链表，注意这里不把原链表拆分出来，只拆分所需链表leetcode不通过
        Node newHead = head.next;
        temp = newHead;
        Node pre = head;
        //temp.next只要不为空，temp.next.next就不为空（因为它是temp.next复制得来的）
        //不能用pre.next!=null来判断，因为pre.next指向它的复制，应该用它的复制来判断
        while (temp.next != null) {
            pre.next = pre.next.next;
            temp.next = temp.next.next;
            temp = temp.next;
            pre = pre.next;
        }
        //处理原链表的尾部！！原来是指向它的复制的，所以需要置空
        pre.next = null;
        return newHead;
    }

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





















