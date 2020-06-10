package solution.solution_0167;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shuai.yang
 */
public class TwoSum {
    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     *
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     *
     * 说明:
     *
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * */
    public static void main(String[] args) {
        int[] numbers = {5, 25, 75};
        int target = 100;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
        System.out.println(Arrays.toString(twoSum1(numbers, target)));
    }

    private static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            maps.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (maps.containsKey(target - numbers[i])) {
                res[0] = i + 1;
                res[1] = maps.get(target - numbers[i]) + 1;
                return res;
            }
        }
        return res;
    }

    /**
     * 双指针向中间判断. 因为是自增的. 如果相加后大于目标数, 就把右指针左移. 如果小于目标数左指针右移
     * */
    private static int[] twoSum1(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }
}
