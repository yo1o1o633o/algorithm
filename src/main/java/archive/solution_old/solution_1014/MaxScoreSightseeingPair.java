package archive.solution_old.solution_1014;

public class MaxScoreSightseeingPair {
    /**
     * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
     *
     * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
     *
     * 返回一对观光景点能取得的最高分。
     * */
    public static void main(String[] args) {
        int[] A = {8,1,5,2,6};
        System.out.println(maxScoreSightseeingPair(A));
    }

    /**
     * A[i] + A[j] + i - j
     * 转换公式
     * A[i] + i + A[j] - j
     * */
    private static int maxScoreSightseeingPair(int[] A) {
        int ans = 0;
        int max = A[0];
        for (int j = 1; j < A.length; j++) {
            ans = Math.max(ans, max + A[j] - j);
            max = Math.max(max, A[j] + j);
        }
        return ans;
    }
}
