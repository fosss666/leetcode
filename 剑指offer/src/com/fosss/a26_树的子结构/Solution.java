package com.fosss.a26_树的子结构;


import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fosss
 * @date 2023/1/19
 * @description： 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * 例：输入：A = [3,4,5,1,2], B = [4,1] 输出：true
 * 限制：0 <= 节点个数 <= 10000
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;

        TreeNode node11 = new TreeNode(4);
        TreeNode node22 = new TreeNode(8);
        TreeNode node33 = new TreeNode(9);
        node11.left = node22;
        node11.right = node33;

        Solution solution = new Solution();
        boolean result = solution.isSubStructure2(node1, node11);
        System.out.println("result = " + result);
    }

    /**
     * 递归
     */
    public boolean isSubStructure2(TreeNode A, TreeNode B) {
        //以节点A为根节点的子树包含树B，对应recur(A,B)；
        //树B是树A左子树的子结构，对应isSubStructure(A.left,B)；
        //树B是树A右子树的子结构，对应isSubStructure(A.right,B)；
        return (A != null && B != null) && (recur(A, B) || isSubStructure2(A.left, B) || isSubStructure2(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    /**
     * 自解
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        //1.从A中找到与B中首节点数值相同的所有结点
        getHeadNode(A, B.val);
        //2.遍历B，取出数值存在集合中
        List<Integer> vals = getVals(B);
        //遍历headNode这个子树，看看是否有B树
        for (TreeNode node : nodes) {
            boolean b = hasB(node, vals);
            if (b) {
                return true;
            }
            //此时应将i重置为0！！！！！！！！！！
            i = 0;
        }
        return false;
    }

    //遍历headNode这个子树，看看是否有B树
    private static int i = 0;

    private boolean hasB(TreeNode headNode, List<Integer> vals) {
        if (i == vals.size()) {
            return true;
        }
        if (headNode != null && headNode.val == vals.get(i)) {
            i++;
        } else {
            return false;
        }
        boolean result1 = true;
        boolean result2 = true;
        if (headNode.left != null) {
            boolean b = hasB(headNode.left, vals);
            if (!b) {
                result1 = false;
            }

        }
        if (headNode.right != null) {
            boolean b = hasB(headNode.right, vals);
            if (!b) {
                result2 = false;
            }
        }
        return result1 && result2;
    }

    //前序遍历
    private static List<Integer> vals = new ArrayList<>();

    private List<Integer> getVals(TreeNode node) {
        if (node != null) {
            vals.add(node.val);
        }
        if (node != null && node.left != null) {
            vals.add(node.left.val);
        }
        if (node != null && node.right != null) {
            vals.add(node.right.val);
        }
        return vals;
    }

    //从A中找到与B中首节点数值相同的所有结点
    private static List<TreeNode> nodes = new ArrayList<>();

    private void getHeadNode(TreeNode A, int val) {
        if (A != null && A.val == val) {
            nodes.add(A);
        }
        TreeNode result = null;
        if (A.left != null) {
            getHeadNode(A.left, val);
        }
        if (A.right != null) {
            getHeadNode(A.right, val);
        }
    }
}
























