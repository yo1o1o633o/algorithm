package offer.offer_003;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 2 <= n <= 100000
 * */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(findRepeatNumberWithReplace(nums));
    }

    public static int findRepeatNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    res = nums[i];
                    break;
                }
            }
        }
        return res;
    }

    private static int findRepeatNumberWithHash(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return num;
            }
            map.put(num, 1);
        }
        return 0;
    }

    private static int findRepeatNumberWithArray(int[] nums) {
        int[] arr = new int[100000];
        for (int num : nums) {
            if (arr[num] != 0) {
                return num;
            }
            arr[num]++;
        }
        return 0;
    }

    private static int findRepeatNumberWithSet(int[] nums) {
        Set<Integer> map = new HashSet<>();
        for (int num : nums) {
            if (map.contains(num)) {
                return num;
            }
            map.add(num);
        }
        return 0;
    }

    /**
     * 原地交换
     * 根据题目的场景。如果数组元素都不重复，那么每个元素值也和元素下表一一对应， 当出现两个元素对应一个下标时。 证明有重复元素
     * 则遍历数组元素，将元素放到对应的下标位置上。
     * 跳过元素值和下标相同的， 遇到当前元素和要交换的下标上的元素相等时，元素重复
     * */
    private static int findRepeatNumberWithReplace(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                continue;
            }
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return 0;
    }
}
