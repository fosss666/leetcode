package a05_双指针法;

/**
 * @author: fosss
 * Date: 2023/7/28
 * Time: 20:09
 * Description:
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class B01_移除元素 {


    /**
     * 快慢指针法
     */
    public int removeElement2(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            //不相等的时候进行赋值，否则跳过
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    /**
     * 前后指针法
     */
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        //前后指针
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            //从左到右找第一个相等的
            while (left <= right && nums[left] != val) {
                left++;
            }
            //从右到左找第一个不相等的
            while (left <= right && nums[right] == val) {
                right--;
            }
            if (left <= right) {
                nums[left] = nums[right];
                left++;
                right--;
            }
        }
        return left;
    }
}













