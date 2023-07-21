package a02_链表;

/**
 * @author: fosss
 * Date: 2023/7/21
 * Time: 21:39
 * Description:
 * 在链表类中实现这些功能：(假设链表中的所有节点下标从 0 开始)
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 */
public class B02_设计链表 {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(5);
        list.addAtIndex(1, 2);
        list.get(1);
        list.addAtHead(6);
        list.addAtTail(2);
        list.get(3);
        list.addAtTail(1);
        list.get(5);
        list.addAtHead(2);
        list.get(2);
        list.addAtHead(6);
    }
}

class MyLinkedList {
    //记录链表长度
    int size;
    //虚拟头指针
    ListNode head;

    MyLinkedList() {
        this.size = 0;
        head = new ListNode(-1);
    }

    /**
     * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode temp = head;
        while (index >= 0) {
            temp = temp.next;
            index--;
        }
        return temp.val;
    }

    /**
     * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     */
    public void addAtHead(int val) {
        ListNode listNode = new ListNode(val);
        listNode.next = head.next;
        head.next = listNode;
        size++;
    }

    /**
     * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
     */
    public void addAtTail(int val) {
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        ListNode listNode = new ListNode(val);
        temp.next = listNode;
        listNode.next = null;
        size++;
    }

    /**
     * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     */
    public void addAtIndex(int index, int val) {
        if (index == size) {
            addAtTail(val);
        } else if (index > size) {
            return;
        } else if (index <= 0) {
            addAtHead(val);
        } else {
            ListNode temp = head;
            while (index > 0) {
                temp = temp.next;
                index--;
            }
            ListNode listNode = new ListNode(val);
            listNode.next = temp.next;
            temp.next = listNode;
            size++;
        }

    }

    /**
     * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode temp = head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        temp.next = temp.next.next;
        size--;
    }
}





















