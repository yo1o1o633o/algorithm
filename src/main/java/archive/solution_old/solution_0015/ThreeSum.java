package archive.solution_old.solution_0015;

import java.util.*;

/**
 * @author shuai.yang
 */
public class ThreeSum {
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     * */
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    /**
     * 利用排序
     * 相同的元素只判断第一次
     * 根据两个元素的和进行左右指针查找
     * */
    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 跳过相同元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int len = nums.length - 1;
            int target = -nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                // 跳过相同元素
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (j < len && nums[j] + nums[len] > target) {
                    len--;
                }
                if (len == j) {
                    break;
                }
                if (nums[len] + nums[j] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[len]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
