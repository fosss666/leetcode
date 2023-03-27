package com.fosss.a33_判断是不是二叉搜索树的后序遍历序列;

/**
 * @author fosss
 * @date 2023/1/27
 * @description： 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数
 * 字都互不相同。
 * 例：二叉树：【5,2,6,1,3】  输入: [1,6,3,2,5]  输出: false    输入: [1,3,2,6,5]   输出: true
 * <p>
 * 提示：数组长度 <= 1000
 * 二叉搜索树定义：关键要理解二叉搜索树的特点！！
 * 左子树中所有节点的值 < 根节点的值；右子树中所有节点的值 > 根节点的值；其左、右子树也分别为二叉搜索树
 * < 左子树的元素挨在一起，右子树的元素挨在一起 >
 * 后序遍历序列的< 最后一个元素为整棵树的根节点 >，序列中大于根节点的为右子树，其余为左子树
 * <p>
 * 思考：
 * 此题关键是要清楚二叉搜索树的特点和后序遍历的特点，后序遍历数组的最后一个元素是根节点，从第一个元素开始，所有小于根节点值的为左子树，大于根节点值
 * 的为右子树，这样就将数组分成了三部分，下标 0~left (左子树)  left+1~right (右子树)  right(arr.length-1) 根节点，这是第一次分组，接下来
 * 应递归对左子树和右子树分别进行该分组操作。递归结束条件：数组只有一个元素时；右子树后边的第一个元素的下标==根节点的下标 && 左右子树都能完成分组
 */

//public boolean verifyPostorder(int[] postorder) {
//        if(postorder==null||postorder.length==0){
//            return true;
//        }
//        return check(postorder,0,postorder.length-1);
//    }
//    private boolean check(int[] postorder,int left,int right){
//        if(left>=right){
//            return true;
//        }
//        int x=left;
//        while(postorder[x]<postorder[right]){
//            x++;
//        }
//        int y=x;
//        while(postorder[y]>postorder[right]){
//            y++;
//        }
//        return y==right && check(postorder,left,x-1) && check(postorder,x,y-1);
//    }
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 6, 9, 4, 3};
        Solution solution = new Solution();
        boolean result = solution.verifyPostorder(arr);
        System.out.println("result = " + result);
    }

    /**
     * 递归分治
     */
    public boolean verifyPostorder(int[] postorder) {
        //最后一个元素为树的根元素，小于根元素的为左子树，大于根元素的为右子树
        return check(postorder, 0, postorder.length - 1);
    }

    private boolean check(int[] postorder, int i, int j) {
        //根元素为postorder(j)
        //递归退出条件，子树只有一个元素时 !!!!!  ">="  !!!
        if (i >= j) {
            return true;
        }
        //找到根节点的左子树的最后一个元素的下一个元素
        int x = i;
        while (postorder[x] < postorder[j]) {
            x++;
        }
        //找到右子树的最后一个元素（右子树的第一个元素为x+1）
        //记录左子树
        int y = x;
        while (postorder[y] > postorder[j]) {
            y++;
        }
        //左子树（i~x-1） 右子树（x~j-1）  当y==j时，说明（确保）右子树的最后一个元素为j的前一个元素（y为右子树的最后一个元素的下一个元素）
        return y == j && check(postorder, i, x - 1) && check(postorder, x, j - 1);
    }
}




















