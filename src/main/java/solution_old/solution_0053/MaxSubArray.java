package solution_old.solution_0053;

public class MaxSubArray {
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * */
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-1,-2,-5,7,4};
        System.out.println(maxSubArray2(nums));
    }

    /**
     * 动态规划
     * 依次判断， 当前元素的前一个元素大于0， 那么就加到当前元素上
     * */
    private static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i - 1] + nums[i];
            }
        }
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return max;
    }

    /**
     * 贪心算法
     * 如果一个元素的前边所有元素和小于0， 那么就丢弃
     * */
    private static int maxSubArray1(int[] nums) {
        int per = 0;
        int max = nums[0];
        for (int num : nums) {
            per = Math.max(num, per + num);
            max = Math.max(per, max);
        }
        return max;
    }

    /**
     * 线段树？
     * TODO 这个方法没有研究明白
     * */
    private static int maxSubArray2(int[] nums) {
        return get(nums, 0, nums.length - 1).mSum;
    }
    private static Status get(int[] nums, int l, int r) {
        if (l == r) {
            return new Status(nums[l], nums[l], nums[l], nums[l]);
        }
        // 右移一位, 除2
        int m = (l + r) >> 1;
        Status lSub = get(nums, l , m);
        Status rSub = get(nums, m + 1 , r);
        return pushUp(lSub, rSub);
    }
    private static Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

    public static class Status {
        int lSum;
        int rSum;
        int mSum;
        int iSum;

        Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }
}
