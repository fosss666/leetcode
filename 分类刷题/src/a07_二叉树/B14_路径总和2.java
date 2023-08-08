package a07_二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fosss
 * Date: 2023/8/8
 * Time: 17:15
 * Description:
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点
 */
public class B14_路径总和2 {

    public static void main(String[] args) {

    }

    /**
     * 递归
     */
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        getPath(root, targetSum, res, new ArrayList<>());
        return res;
    }

    private static void getPath(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> list) {
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                //是要找的路径
                list.add(root.val);
                //TODO 这里非常关键，一定要new一个新集合，否则得不出正确结果。List是引用类型，不new的话自始至终操作的都是那一个list,从而导致已经找到并且放到res中的路径还会再后面发生变化
                res.add(new ArrayList<>(list));
                //删除
                list.remove(list.size() - 1);
            }
            return;
        }
        if (root.left != null) {
            list.add(root.val);
            //向左找
            getPath(root.left, targetSum - root.val, res, list);
            //回溯
            list.remove(list.size() - 1);

        }
        if (root.right != null) {
            list.add(root.val);
            //向右找
            getPath(root.right, targetSum - root.val, res, list);
            //回溯
            list.remove(list.size() - 1);
        }
    }
}
