package archive.solution_old.solution_0215;

import java.util.Arrays;

/**
 * @author shuai.yang
 */
public class FindKthLargest {
    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * */
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    /**
     * 排序. 倒着查
     * */
    private static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int c = 0;
        for (int i = nums.length; i >= 0; i--) {
            if (c == k) {
                return nums[i];
            }
            c++;
        }
        return nums[nums.length - 1];
    }
}
