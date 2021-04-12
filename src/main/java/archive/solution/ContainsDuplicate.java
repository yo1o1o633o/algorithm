package archive.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * @author shuai.yang
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicateWithHash(nums));
        System.out.println(containsDuplicateWithDoublePoint(nums));
    }

    /**
     * 哈希表. 如果Map内存在, 则证明遇到重复元素, 返回true
     * 否则给Map添加元素1
     * */
    private static boolean containsDuplicateWithHash(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int n : nums) {
            if (map.containsKey(n)) {
                return true;
            }
            map.put(n, 1);
        }
        return false;
    }

    /**
     * 双指针
     * 利用排序方法对数组进行排序
     * 如果有重复的那么一定是挨着的
     * 双指针两两比较. 碰到相同的返回true
     * */
    private static boolean containsDuplicateWithDoublePoint(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Arrays.sort(nums);
        int i = 0;
        int j = i + 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                return true;
            }
            i++;
            j++;
        }
        return false;
    }
}
