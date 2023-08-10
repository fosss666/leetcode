package a07_二叉树;

import java.util.*;

/**
 * @author: fosss
 * Date: 2023/8/10
 * Time: 18:08
 * Description:
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 示例：
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 */
public class B22_二叉搜索树中的众数 {

    /**
     * 遍历，放到map中，k为结点值，v为出现次数，根据出现次数最多的返回——没有用到二叉搜索树的性质
     */
    public int[] findMode(TreeNode root) {
        preorder(root);
        List<Integer> list = new ArrayList<>();
        if (map.isEmpty()) return new int[0];
        int max = Integer.MIN_VALUE;
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            if (value > max) {
                //更新众数，先清空list中原有的数据
                list.clear();
                max = value;
                list.add(key);
            } else if (value == max) {
                list.add(key);//有不止一个众数
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    Map<Integer, Integer> map = new HashMap<>();

    private void preorder(TreeNode root) {
        if (root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * 利用到二叉搜索树中序遍历是一个递增数组的性质，在遍历过程中统计值出现的次数，并更新res
     */
    public int[] findMode2(TreeNode root) {
        inorder(root);
        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }

    List<Integer> res = new ArrayList<>();
    int count = 0;//用来结点值记录出现次数
    int maxCount = 0;//用来记录最大次数
    TreeNode pre = null;//用来记录前一个结点，方便比较当前节点值与前结点值是否相同

    private void inorder(TreeNode root) {
        if (root == null) return;
        //左
        inorder(root.left);
        //中
        if (pre == null || pre.val != root.val) {
            //pre为null说明现在遍历的是第一个结点，第一次出现
            //不等，说明是第一个出现的值
            count = 1;
        } else {
            count++;//次数+1
        }
        //更新pre
        pre = root;
        //判断是否是出现次数最多的
        if (count > maxCount) {
            //更新最大值
            maxCount = count;
            //是，先清空res，再添加
            res.clear();
            res.add(root.val);
        } else if (count == maxCount) {
            //不只一个众数
            res.add(root.val);
        }

        //右
        inorder(root.right);
    }

    /**
     * 迭代法
     */
    public int[] findMode3(TreeNode root) {
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        int maxCount = 0;
        int count = 0;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                // 计数
                if (pre == null || cur.val != pre.val) {
                    count = 1;
                } else {
                    count++;
                }
                // 更新结果
                if (count > maxCount) {
                    maxCount = count;
                    result.clear();
                    result.add(cur.val);
                } else if (count == maxCount) {
                    result.add(cur.val);
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
