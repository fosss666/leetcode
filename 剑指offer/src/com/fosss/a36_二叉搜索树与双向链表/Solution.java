package com.fosss.a36_二叉搜索树与双向链表;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fosss
 * @date 2023/1/31
 * @description： 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向
 * 分析：left作为前驱结点，right作为后继结点。中序遍历可以按照结点的值从小到大的顺序得到结点
 * <p>
 * 思考：
 * 1.中序遍历+集合存储。将二叉搜索树转换成一个排序的循环双向链表，中序遍历二叉搜索树可以得到排序的结果，将中序遍历的结点放到集合中，再对这
 * 个集合进行处理，遍历集合，设置每个结点的前驱节点和后继节点（借助模运算来方便处理首结 点和尾结点）
 * 2.中序遍历（不借助集合）。设置两个成员变量，一个用来存储头结点，一个用来存储当前结点的前一个结点。编写中序遍历方法，中间部分的处理：pre
 * ==null时，存储头结点（head=null），将pre=root,回溯到下一个过程后，pre就相当于root的前一个结点，这个过程中pre!=null,所以设置前驱
 * 结点和后继结点 pre.right=root;root.left=pre; 然后更新pre=root;
 * 主操作方法中，调用中序遍历方法，此时头结点和尾结点的前驱节点和后继结点还未设置，所以需要设置，设置成员变量head也是为了这个步骤：pre.right
 * =head; head.left=pre;
 */
public class Solution {

    /**
     * 中序遍历，不借助集合
     */
    Node pre = null;
    Node head = null;

    public Node treeToDoublyList2(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        //处理首尾结点
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node root) {
        if (root.left != null) {
            dfs(root.left);
        }

        if (pre == null) {
            head = root;
        } else {
            pre.right = root;
            root.left = pre;
        }
        pre = root;
        if (root.right != null) {
            dfs(root.right);
        }
        //if (root == null) {
        //    return;
        //}
        //dfs(root.left);
        //if (pre == null) {
        //    head = root;
        //} else {
        //    pre.right = root;
        //    root.left = pre;
        //}
        //pre = root;
        //dfs(root.right);
    }

    /**
     * 自解，中序遍历+集合
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> list = new ArrayList<>();
        //获取中序遍历的结点集合
        getMiddleNodes(root, list);
        int size = list.size();
        //将集合中的结点构建成双向循环链表
        for (int i = 0; i < list.size(); i++) {
            //单独判断首尾结点
            //if (i == 0) {
            //    Node node = list.get(i);
            //    node.left = list.get(list.size() - 1);
            //    node.right = list.get(i + 1);
            //}

            Node node = list.get(i);
            //利用整除可以不用单独判断首位结点
            node.left = list.get(((i + size - 1) % size));
            node.right = list.get((i + size + 1) % size);
        }
        return list.get(0);
    }

    //获取中序遍历的结点集合
    private void getMiddleNodes(Node root, List<Node> list) {
        if (root.left != null) {
            getMiddleNodes(root.left, list);
        }
        list.add(root);
        if (root.right != null) {
            getMiddleNodes(root.right, list);
        }
    }
}




















