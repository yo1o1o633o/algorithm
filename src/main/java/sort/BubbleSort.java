package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 22, 22, 23, 24, 41, 88};
        sort4(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 基本冒泡. 双层遍历, 暴力交换
     * @param nums  数组
     */
    private static void sort(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;

                    n++;
                    System.out.println(Arrays.toString(nums));
                }
            }
        }
        System.out.println(n);
    }

    /**
     * 基本冒泡. 双层遍历, 两两交换
     * @param nums  数组
     */
    private static void sort2(int[] nums) {
        int n = 0;
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            // 因为每一次内圈循环比较完成后,最大的值就会到队尾.所以没一次都可以减去i的长度循环次数.
            // 因为是两两交换, 每次比较把小的和大的交换位置
            // 即每完成一次内圈循环, 就能数组中一个最大的值放到尾部的正确位置, 那么每一个下一次内圈循环就可以少比较一个.
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                    n++;
                }
                m++;
            }
        }
        System.out.println(n);
        System.out.println(m);
    }

    /**
     * 优化: 当传入的数组本身是有序的, 或者在所有循环之前就排好了序. 如只有前两个元素需要排序, 此时按上边的方法依然要走完所有循环
     * 设置一个标志, 标识是否存在一次循环, 该循环没有交换过任何元素. 则证明整个数组已经排好序
     * @param nums nums
     */
    private static void sort3(int[] nums) {
        int n = 0;
        int m = 0;
        int j = 0;
        boolean flag = true;
        while (flag) {
            // 先设置为false
            flag = false;
            for (int i = 1; i < nums.length - j; i++) {
                if (nums[i] < nums[i - 1]) {
                    int temp = nums[i - 1];
                    nums[i - 1] = nums[i];
                    nums[i] = temp;
                    // 此次有交换, 设置为true. 进入下一次循环
                    flag = true;
                    n++;
                }
                m++;
            }
            j++;
        }
        System.out.println(n);
        System.out.println(m);
    }

    /**
     * 优化: 当传入的数组如 3, 2, 1, 22, 22, 23, 24, 41, 88
     * 只有前边3个需要排序, 而后边的都是排排好序的. 此时使用上边的方法虽然只要3次外循环, 但是每次内循环都要全部遍历所有元素
     * 设置一个边界值. 边界值表示之后的元素无需冒泡判断.
     * @param nums nums
     */
    private static void sort4(int[] nums) {
        int n = 0;
        int m = 0;
        int j = nums.length;
        while (j > 0) {
            int f = 0;
            for (int i = 1; i < j; i++) {
                if (nums[i] < nums[i - 1]) {
                    int temp = nums[i - 1];
                    nums[i - 1] = nums[i];
                    nums[i] = temp;
                    // 更新边界值
                    f = i;
                    n++;
                }
                m++;
            }
            j = f;
        }
        System.out.println(n);
        System.out.println(m);
    }
}
