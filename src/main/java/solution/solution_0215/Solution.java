package solution.solution_0215;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargestWithFastSelect(nums, 4));
    }

    /**
     * 快速选择
     * 利用快速排序，只是当快速排序过程中发现所选择的目标值正好为k，则直接返回
     * 当k在目标值前时， 只递归左侧， 否则只递归右侧
     * 快速排序的特点是： 每次选择的目标值一定是其正确的位置，发生排序变化的只能是其左侧和右侧
     * */
    private static int findKthLargestWithFastSelect(int[] nums, int k) {
        // nums.length - k; 找最大的第K个元素， 那么也就等同于从小到大排序后, 长度-k的下标
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    /**
     * 先对整个数组快速排序一次， 然后判断目标只是否是要求的k。如果不是那么再判断k在目标值的左边还是右边。只需要再次对这一半的数组递归快速排序， 重复上述操作
     * */
    private static int quickSelect(int[] nums, int l, int r, int index) {
        int q = randomPartition(nums, l, r);
        if (q == index) {
            return nums[q];
        }
        return q < index ? quickSelect(nums, q + 1, r, index) : quickSelect(nums, l, q - 1, index);
    }

    private static int randomPartition(int[] nums, int l, int r) {
        Random random = new Random();
        // 取随机数, 取值为0到右-左+1. 最后再加l是因为l值不是0开始的
        int i = random.nextInt(r - l + 1) + l;
        // 把随机位置的元素和最后一个元素进行交换, 用于快排取目标值用
        swap(nums, i, r);
        return partitionSelect(nums, l, r);
    }

    /**
     * 进行一次排序
     * */
    private static int partitionSelect(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] <= pivot) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 利用快速排序，对数组进行排序
     * */
    private static int findKthLargestWithFastSort(int[] nums, int k) {
        helper(nums, 0, nums.length - 1);
        return nums[k - 1];
    }
    private static void helper(int[] nums, int left, int right) {
        // 跳出递归的条件是左右指针没有相遇
        // 对区间内进行排序
        if (left < right) {
            int partition = partition(nums, left, right);
            // 拆分两部分进行递归排序
            helper(nums, left, partition - 1);
            helper(nums, partition + 1, right);
        }
    }
    /**
     * 升序还是降序排列， 判断依据是内层的循环判断
     * 升序： 从小到大， 那么找到比目标值小的放左边，比目标值大的放右边
     * 降序： 从大到小， 那么找到比目标值大的放左边，比目标值小的放左边
     * */
    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        // 循环进行处理, 里面的每次最多找到两个值进行操作, 一个大于目标的, 一个小于目标的, 所以要继续循环处理, 直至两个指针相遇
        while (left < right) {
            // 从右向左进行判断, 如果比目标值大, 那么不操作指针前移1
            while (left < right && nums[right] <= pivot) {
                right--;
            }
            // 比目标值小或相等, 把他放在左边
            if (nums[right] > pivot) {
                nums[left] = nums[right];
            }
            // 从左向右进行判断, 如果比目标值小, 那么不操作指针后移1
            while (left < right && nums[left] >= pivot) {
                left++;
            }
            // 比目标值小或相等, 把他放在右边
            if (nums[left] < pivot) {
                nums[right] = nums[left];
            }
        }
        // 最后将目标值放到指针相遇处, 即这个数就是临界点
        nums[left] = pivot;
        return left;
    }

    /**
     * 转成最大堆，然后移除k-1个堆顶， 剩下的堆顶就是第k大的数
     */
    private static int findKthLargestWithPriority(int[] nums, int k) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : nums) {
            max.offer(n);
        }

        for (int i = 0; i < k - 1; i++) {
            max.poll();
        }
        return max.peek();
    }

}
