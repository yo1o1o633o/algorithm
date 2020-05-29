package solution.solution_0594;

import java.util.*;

/**
 * @author shuai.yang
 */
public class FindLhs {
    /**
     * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
     *
     * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
     * */
    public static void main(String[] args) {
        int[] nums = {1,3,2,2,5,2,3,7};
        System.out.println(findLhs(nums));
    }

    /**
     * 一次循环. 每次循环时进行计算
     * */
    private static int findLhs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            int n = map.getOrDefault(num, 0) + 1;
            map.put(num, n);
            if (map.containsKey(num + 1)) {
                count = Math.max(count, map.get(num + 1) + n);
            }
            if (map.containsKey(num - 1)) {
                count = Math.max(count, map.get(num - 1) + n);
            }
        }
        return count;
    }

    private static int findLhs1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                int sum = map.get(key) + map.get(key + 1);
                if (sum > count) {
                    count = sum;
                }
            }
        }
        return count;
    }

    /**
     * Hash表
     * */
    private static int findLhs2(int[] nums) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (treeMap.containsKey(nums[i])) {
                treeMap.put(nums[i], treeMap.get(nums[i]) + 1);
            } else {
                treeMap.put(nums[i], 1);
            }
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> t : treeMap.entrySet()) {
            if (treeMap.containsKey(t.getKey() + 1)) {
                int sum = t.getValue() + treeMap.get(t.getKey() + 1);
                if (sum > count) {
                    count = sum;
                }
            }
        }
        return count;
    }
}
