package sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {12, 45, 6, 1, 6521, 7, 861, 2376, 73, 2, 4, 1};
        sort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 两层循环. 内层每次循环在剩余元素中找到最小的一个元素的下标.
     * 即第一次挑出最小的
     * 第二次挑出第二小的
     * 依次从小到大选出所有的.
     * 每选出一个,就放在已经排好的元素后边
     * @param nums nums
     */
    private static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
    }

    /**
     * 每次选择, 选出一个最大值和一个最小值. 循环边界两侧缩进
     * @param nums nums
     */
    private static void sort2(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int min = i;
            int max = nums.length - 1 - i;
            if (nums[min] > nums[max]) {
                int temp = nums[min];
                nums[min] = nums[max];
                nums[max] = temp;
            }
            for (int j = i + 1; j < nums.length - 1 - i; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
                if (nums[j] > nums[max]) {
                    max = j;
                }
            }
            if (min != i) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
            if (max != nums.length - 1 - i) {
                int temp = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = nums[max];
                nums[max] = temp;
            }
        }
    }
}
