package solution_old.solution_0217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author shuai.yang
 */
public class ContainsDuplicate {
    /**
     * 给定一个整数数组，判断是否存在重复元素。
     *
     * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     * */
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 1};
        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicate1(nums));
    }

    /**
     * Set集合判断一波
     * */
    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return true;
            }
            set.add(n);
        }
        return false;
    }

    /**
     * 先排序. 如果有相同的一定会挨着
     * Arrays.sort(nums); 数组个数大于286且连续性好就使用归并排序，若小于47使用插入排序，其余情况使用双轴快速排序
     * */
    private static boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0, j = 1; j < nums.length; i++, j++) {
            if (nums[i] == nums[j]) {
                return false;
            }
        }
        return false;
    }
}
