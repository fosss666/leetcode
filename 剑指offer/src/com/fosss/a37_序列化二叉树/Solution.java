package com.fosss.a37_序列化二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fosss
 * @date 2023/2/1
 * @description： 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列化 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符
 * 串并且将这个字符串反序列化为原始的树结构
 * <p>
 * 思路:
 * 1.序列化：将二叉树转成一个字符串，因为还需要用这个字符串反序列化成原来的二叉树，所以要存储完整的二叉树结构，即要将叶子结点下的null也要存储到
 * 字符串中，从而防止有左子树而没有右子树的问题。采用层序遍历（借助队列实现）来拼接字符串，结点为空则拼接null，所以向队列中添加元素时无需判断结
 * 点是否为空；结点不为空则拼接结点的值，
 * 2.反序列化：
 * 1） 去掉字符串两端的"[]"，以"," 分割字符串形成字符串数组
 * 2) 接下来构建二叉树：同样借助队列来实现层序构建，分别设置poll的左子树和右子树，如果s[index]不是"null",new 结点并设置为左子树，index++;
 * 如果s[index]不是"null",new 结点并设置为右子树，index++
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        Solution solution = new Solution();
        String serialize = solution.serialize(node1);
        System.out.println("serialize = " + serialize);
        TreeNode deserialize = solution.deserialize(serialize);
        System.out.println("deserialize = " + deserialize.val);
    }

    /**
     * k神的层序遍历
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //如果root为空，返回‘[]’
        if (root == null) {
            return "[]";
        }
        //拼接字符串
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        //利用队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //根据node是否为空进行不同的处理
            //为了便于反序列化时处理子树为空的情况，当子树为空时拼接“null,”
            if (node == null) {
                //为空则存储字符串"null,"
                sb.append("null").append(",");
            } else {
                //不为空则拼接结点的值
                sb.append(node.val).append(",");
                //对不为空的结点的左右子树加入队列
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        //拼接完后，最后多了一个逗号 将其去除
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        //借助队列实现反序列化
        Queue<TreeNode> queue = new LinkedList<>();
        //获取字符串数组，跳过中括号和逗号
        String[] strings = data.substring(1, data.length() - 1).split(",");
        //创建结点
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //反序列化左子树
            if (!strings[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(strings[i]));
                queue.add(node.left);
            }
            i++;
            //反序列化右子树
            if (!strings[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(strings[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}




































