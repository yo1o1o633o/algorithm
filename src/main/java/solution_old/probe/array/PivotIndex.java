package solution_old.probe.array;

public class PivotIndex {
    /**
     * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
     *
     * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
     *
     * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
     * */
    public static void main(String[] args) {
        int[] nums = {-1,-1,0,1,1,0};
        System.out.println(pivotIndex(nums));
    }

    /**
     * 左右相加对比
     * */
    private static int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            for (int j = 0; j < i; j++) {
                left += nums[j];
            }
            int right = 0;
            for (int k = i + 1; k < nums.length; k++) {
                right += nums[k];
            }
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}
