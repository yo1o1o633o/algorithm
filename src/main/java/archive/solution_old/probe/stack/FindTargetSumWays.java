package archive.solution_old.probe.stack;

/**
 * @author shuai.yang
 */
public class FindTargetSumWays {
    /**
     * 官方不能使用static. 会导致测试多个测试用例互相影响
     * */
    public static void main(String[] args) {
        int[] nums = {1};
        int S = 1;
        FindTargetSumWays findTargetSumWays = new FindTargetSumWays();
        System.out.println(findTargetSumWays.findTargetSumWays(nums, S));
    }
    private int count = 0;
    private int findTargetSumWays(int[] nums, int S) {
        helper(nums, 0, 0, S);
        return count;
    }
    private void helper(int[] nums, int index, int sum, int target) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            helper(nums, index + 1, sum + nums[index], target);
            helper(nums, index + 1, sum - nums[index], target);
        }
    }
}
