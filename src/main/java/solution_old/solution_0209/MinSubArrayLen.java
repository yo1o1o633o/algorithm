package solution_old.solution_0209;

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
        int end = 0;
        int start = 0;
        int ans = 0;
        int min = Integer.MAX_VALUE;
        while (end < nums.length) {
            ans += nums[end];
            while (ans >= s) {
                min = Math.min(min, end - start + 1);
                ans -= nums[start];
                start++;
            }
            end++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
