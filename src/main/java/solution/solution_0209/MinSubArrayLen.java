package solution.solution_0209;

/**
 * @author shuai.yang
 */
public class MinSubArrayLen {
    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
     * */
    public static void main(String[] args) {
        int[] nums = {5,1,3,5,10,7,4,9,2,8};
        int s = 15;
        System.out.println(minSubArrayLen(s, nums));
    }

    /**
     * 双指针. 一个记录头部一个记录尾部.  出现大于s的值就计算头尾区间.  最后保存最大区间个数
     * */
    private static int minSubArrayLen(int s, int[] nums) {
        int i = 0;
        int j = 0;
        int res = 0;
        int min = Integer.MAX_VALUE;
        while (i < nums.length) {
            res = res + nums[i];
            if (res >= s) {
                while (j < i) {
                    if (res - nums[j] < s) {
                        break;
                    }
                    res = res - nums[j];
                    j++;
                }
                min = Math.min(min, i - j + 1);
            }
            i++;
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }
}
