package solution_0088;

import java.util.Arrays;

/**
 * @author Yang
 */
public class Merge {
    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。Merge
     * */
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[] nums1 = new int[6];
        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 3;
        int[] nums2 = new int[3];
        nums2[0] = 2;
        nums2[1] = 5;
        nums2[2] = 6;
//        System.out.println(Arrays.toString(merge(nums1, m, nums2, n)));
//        System.out.println(Arrays.toString(merge2(nums1, m, nums2, n)));
        System.out.println(Arrays.toString(merge3(nums1, m, nums2, n)));
    }

    /**
     * 利用java类, 先合并再排序
     * */
    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        // 原数组, 起始位置, 目标数组, 目标数组起始位置, copy的长度. 将nums2从0开始复制到nums1数组的m起始n个长度的位置
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        return nums1;
    }

    /**
     * 双指针
     * */
    private static int[] merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        // 记录nums1 < nums2 对应指针的个数
        int p1 = 0;
        // 记录nums2 >= nums1 对应指针的个数
        int p2 = 0;
        int p = 0;
        while ((p1 < m) && (p2 < n)) {
            if (nums1_copy[p1] < nums2[p2]) {
                nums1[p++] = nums1_copy[p1++];
            } else {
                nums1[p++] = nums2[p2++];
            }
        }
        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
        return nums1;
    }

    /**
     * 双指针, 从后向前比较
     * 已知nums1 后有空位0
     * */
    private static int[] merge3(int[] nums1, int m, int[] nums2, int n) {
        // 最后空位索引
        int p = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        // 从后向前比较
        while ((p1 >= 0) && (p2 >= 0)) {
            if (nums1[p1] < nums2[p2]) {
                nums1[p--] = nums2[p2--];
            } else {
                nums1[p--] = nums1[p1--];
            }
        }
        // 当上面的循环是以p1跳出的, p2有可能剩余元素没有处理. 而剩下的都是小的, 拼到nums1前边
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        return nums1;
    }
}
