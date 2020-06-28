package solution.solution_0016;

public class ThreeSumClosest {
    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案
     * */
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0};
        int target = -100;
        System.out.println(threeSumClosest(nums, target));
    }

    /**
     * 3重循环。 待优化
     * */
    private static int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (min > Math.abs(target - sum)) {
                        min = Math.abs(target - sum);
                        ans = sum;
                    }
                }
            }
        }
        return ans;
    }
}
