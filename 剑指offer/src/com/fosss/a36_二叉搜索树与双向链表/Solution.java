package com.fosss.a36_二叉搜索树与双向链表;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fosss
 * @date 2023/1/31
 * @description： 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向
 * 分析：left作为前驱结点，right作为后继结点。中序遍历可以按照结点的值从小到大的顺序得到结点
 */
public class Solution {


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




















