package a01_数组;

/**
 * @author: fosss
 * Date: 2023/7/19
 * Time: 16:19
 * Description:
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
 * <p>
 * 需要注意查找区间的开闭情况
 */
public class b01_二分查找 {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println("binarySearch1(arr, target) = " + binarySearch1(arr, target));
        System.out.println("binarySearch2(arr,target) = " + binarySearch2(arr, target));
    }

    /**
     * 左闭右闭
     */
    public static int binarySearch1(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        if (target < arr[left] || target > arr[right]) {
            return -1;
        }

        while (left <= right) { //left可能==right所以这里是<=
            int mid = (right - left) / 2 + left;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                //向右找
                left = mid + 1;
            } else {
                //向左找
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 左闭右开
     */
    public static int binarySearch2(int[] arr, int target) {
        int left = 0, right = arr.length;
        if (target < arr[left] || target > arr[right - 1]) {
            return -1;
        }

        while (left < right) {//left不可能==right所以这里是<
            int mid = (right - left) / 2 + left;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                //向右找
                left = mid + 1;
            } else {
                //向左找
                right = mid;
            }
        }
        return -1;
    }
}



















