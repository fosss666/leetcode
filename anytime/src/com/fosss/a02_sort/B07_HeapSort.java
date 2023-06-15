package com.fosss.a02_sort;

/**
 * @author: fosss
 * Date: 2023/6/15
 * Time: 15:26
 * Description: 堆排序
 * 时间复杂度O(n*以2为底n的对数) 空间复杂度O(1) 不稳定，适用于n较大的情况
 */
public class B07_HeapSort {
    public static void heapSort(int[] arr) {
        //从最后一个非叶子节点(数组从1开始存储数组的话为arr.length/2)开始，向前转成大顶堆 注意数组下标从1开始
        for (int i = arr.length / 2; i >= 1; i--) {
            heapTransfer(arr, i, arr.length);
        }

        //将堆顶放到尾部
        for (int i = arr.length - 1; i > 1; i--) {
            int temp = arr[i];
            arr[i] = arr[1];
            arr[1] = temp;
            //重新构建
            heapTransfer(arr, 1, i);
        }

    }

    /**
     * 数组（二叉树）转成大顶堆
     *
     * @param index  最后一个非叶子节点的下标
     * @param length 数组的长度，因为堆排序要将顶部逐个放到尾部，这个位置的数就不能再最终形成一个从小到大排序的数组，所以数组长度会发生变化
     */
    private static void heapTransfer(int[] arr, int index, int length) {
        int temp = arr[index];
        //将此节点及子树转为堆
        for (int i = 2 * index; i < length; i++) {
            //找左右子树中较大的那一个 对从下标1开始存储数据的结构来说2*index是左子树，再+1是右子树
            //对从0开始的，2*index+1为左子树，再+1为右子树
            if (i + 1 < length && arr[i] < arr[i + 1]) {
                i++;
            }
            //重新设定顶
            if (temp < arr[i]) {
                arr[index] = arr[i];
                //！！！index表示堆顶，下一个堆的堆订为i
                index = i;
            } else {
                break;
            }
        }
        //将temp放在合适的位置
        arr[index] = temp;


    }
}
