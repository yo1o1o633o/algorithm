package solution_old.solution_0283;

import java.util.Arrays;

/**
 * @author shuai.yang
 */
public class MoveZeroes {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * */
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,1};
        moveZeroes1(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 两两交换
     * */
    private static void moveZeroes(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
            }
        }
        int c = 0;
        while (c < count) {
            for (int i = 0; i < nums.length; i++) {
                if (i != nums.length - 1 && nums[i] == 0) {
                    nums[i] = nums[i + 1];
                    nums[i + 1] = 0;
                }
            }
            c++;
        }
    }

    /**
     * 双指针.
     * */
    private static void moveZeroes1(int[] nums) {
        int i = 0;
        int j = 1;
        while (i < nums.length && j < nums.length) {
            if (nums[i] == 0) {
                if (nums[j] == 0) {
                    j++;
                    continue;
                } else {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
            }
            i++;
            j++;
        }
    }
}
