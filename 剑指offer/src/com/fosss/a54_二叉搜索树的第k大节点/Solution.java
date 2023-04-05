package com.fosss.a54_二叉搜索树的第k大节点;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fosss
 * @date 2023/2/21
 * @description： 给定一棵二叉搜索树，请找出其中第 k 大的节点的值
 * 例：输入: root = [3,1,4,null,2], k = 1  输出：4
 * 限制：1 ≤ k ≤ 二叉搜索树元素个数
 * <p>
 * 思路：
 * 首先要明确二叉搜索树的特点，对二叉搜索树进行中序遍历就可得到一个升序的数组，第k大就是下标为 (nums.length-k) 处的元素。中序遍历是按照左节点->根节点->右
 * 节点的顺序进行遍历的，同理，按照右节点->根节点->左节点的顺序进行遍历可以得到一个降序排列的数组，第k大就是下标为 (k-1) 处的元素。依照这两种方式可以都可以
 * 进行求解。在用方式2时，可以不使用集合进行存储。
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        node1.left = node2;
        node2.right = node4;
        node1.right = node3;

        Solution solution = new Solution();
        int res = solution.kthLargest2(node1, 3);
        System.out.println("res = " + res);
    }

    /**
     * 中序遍历，优化  100%
     * 二叉搜索树按照右结点->根节点->左结点的顺序遍历就是从大到小遍历，不利用List进行存储
     */
    public int kthLargest2(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        middle2(root, k);
        return res;
    }

    int num = 1, res = -1;

    private void middle2(TreeNode root, int k) {
        if (root.right != null) {
            middle2(root.right, k);
        }

        if (num++ == k) {
            res = root.val;
            return;
        }

        if (root.left != null) {
            middle2(root.left, k);
        }
    }


    /**
     * 中序遍历
     */
    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        middle(root, list);
        //第k大，就是正数第（n-k）个数
        return list.get(list.size() - k);

        /*for (int i = 0; i < list.size(); i++) {
            if (list.size() - k == i) {
                return list.get(i);
            }
        }
        return -1;*/
    }

    private void middle(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            middle(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            middle(root.right, list);
        }
    }
}















