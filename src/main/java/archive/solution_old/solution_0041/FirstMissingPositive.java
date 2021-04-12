package archive.solution_old.solution_0041;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    /**
     * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
     * */
    public static void main(String[] args) {
        int[] nums = {7,8,9,11,12};
        System.out.println(firstMissingPositive(nums));
    }

    /**
     * Hash表从0开始枚举
     * */
    private static int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int i = 1;
        while (true) {
            if (set.contains(i)) {
                i++;
            } else {
                break;
            }
        }
        return i;
    }
}
