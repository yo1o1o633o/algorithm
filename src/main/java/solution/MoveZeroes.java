package solution;

import java.util.Arrays;

/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroesFromFast(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 双指针
     * 定义快慢指针。慢指针遇到0的时候，快指针启动。
     * 快指针向后遇到非0时。交换快慢指针元素。
     * 即，从前向后，每次在0后边碰到大于0的数，就放到前边
     * */
    private static void moveZeroes(int[] nums) {
        int i = 0;
        int j = 1;
        while (i < nums.length) {
            if (nums[i] != 0) {
                i++;
                j++;
                continue;
            }
            while (j < nums.length) {
                if (nums[j] == 0) {
                    j++;
                    continue;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                break;
            }
            i++;
        }
    }

    /**
     * 双指针
     * 此方法先找大于0的， 如果碰到就和慢指针交换。交换后慢指针前进1
     * */
    private static void moveZeroesFromFast(int[] nums) {
        int n = nums.length;
        int f = 0;
        int s = 0;
        while (s < n) {
            if (nums[s] != 0) {
                int temp = nums[s];
                nums[s] = nums[f];
                nums[f] = temp;
                f++;
            }
            s++;
        }
    }
}
