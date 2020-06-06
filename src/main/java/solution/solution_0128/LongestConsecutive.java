package solution.solution_0128;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author shuai.yang
 */
public class LongestConsecutive {
    /**
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     *
     * 要求算法的时间复杂度为 O(n)。
     * */
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutive1(nums));
    }

    /**
     * 借用排序类. 对数组进行排序. 循环对每个元素判断和统计. 如果碰到重复的元素, 那么跳过
     * */
    private static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1 && nums[i + 1] == nums[i]) {
                continue;
            }
            count++;
            if (i == nums.length -  1 || nums[i + 1] - 1 != nums[i]) {
                max = Math.max(count, max);
                count = 0;
            }
        }
        return max;
    }

    /**
     * 集合去重. 循环判断集合中是否有当前值+1的存在. 存在累计计数
     * 跳过当前值-1的判断.
     * */
    private static int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (Integer s : set) {
            int curr = s;
            int count = 1;
            if (!set.contains(s - 1)) {
                while (set.contains(curr + 1)) {
                    curr++;
                    count++;
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
}
