package solution.solution_0001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 * */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,2,11,15};
        int target = 4;
        System.out.println(Arrays.toString(twoSumWithHash(nums, target)));
        System.out.println(Arrays.toString(twoSumWithFor(nums, target)));
    }

    /**
     * 哈希表， 注意取出的不是本身的满足条件的就是
     */
    private static int[] twoSumWithHash(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int l = target - nums[i];
            if (map.containsKey(l) && map.get(l) != i) {
                res[0] = i;
                res[1] = map.get(l);
                break;
            }
        }
        return res;
    }

    /**
     * 双循环
     */
    private static int[] twoSumWithFor(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
}
