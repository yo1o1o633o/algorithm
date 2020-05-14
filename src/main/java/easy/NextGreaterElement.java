package easy;

import java.util.*;

public class NextGreaterElement {
    /**
     * 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
     *
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
     * */
    public static void main(String[] args) {
        int[] num1 = {4, 1, 2};
        int[] num2 = {1, 4, 3, 2};
        System.out.println(Arrays.toString(nextGreaterElement(num1, num2)));
    }

    /**
     * 暴力循环
     * */
    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j] && j != nums2.length - 1) {
                    for (int k = j; k < nums2.length; k++) {
                        if (nums2[k] > nums1[i]) {
                            res[i] = nums2[k];
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
}
