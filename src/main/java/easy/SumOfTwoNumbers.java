package easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Yang
 */
public class SumOfTwoNumbers {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * */
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] firstRes = firstRun(nums, target);
        int[] secondRes = secondRun(nums, target);
        int[] thirdRes = thirdRun(nums, target);
        System.out.println(Arrays.toString(firstRes));
        System.out.println(Arrays.toString(secondRes));
        System.out.println(Arrays.toString(thirdRes));
    }

    /**
     * 双重遍历相加
     * */
    private static int[] firstRun(int[] nums, int target) {
        int[] res = new int[2];
        // 循环遍历
        for (int i = 0; i < nums.length; i++) {
            System.out.println("i" + i);
            int x = i + 1;
            for (int j = x; j <= nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        throw new IllegalArgumentException("Not Found Index");
    }

    /**
     * 两次hash
     * 第一次循环将所有数都添加到hash表中
     * 第二个循环, 循环判断hash是否存在差值, 除了自身以外
     * 较第一种方法提高了速度, hash表的查找速度高
     * */
    private static int[] secondRun(int[] nums, int target) {
        HashMap<Integer, Integer> maps = new HashMap<>(10);
        for (int i = 0; i < nums.length; i++) {
            maps.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (maps.containsKey(complement) &&  maps.get(complement) != i) {
                return new int[] {i, maps.get(complement)};
            }
        }
        throw new IllegalArgumentException("Not Found Index");
    }

    /**
     * 优化第二个方案, 一次遍历解决
     * 如果存在就返回, 否则就将该值put进map里. 第一次执行肯定不存在则会将第一个放进去.
     * 后续从第二个开始循环判断是否在hash表有满足条件的, 不满足则继续添加
     * */
    private static int[] thirdRun(int[] nums, int target) {
        HashMap<Integer, Integer> maps = new HashMap<>(10);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (maps.containsKey(complement) && maps.get(complement) != i) {
                return new int[] {i, maps.get(complement)};
            }
            maps.put(nums[i], i);
        }
        throw new IllegalArgumentException("Not Found Index");
    }
}
