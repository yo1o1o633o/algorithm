package solution_old.solution_0718;

/**
 * @author shuai.yang
 */
public class FindLength {
    /**
     * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
     * */
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        System.out.println(findLength(A, B));
    }

    /**
     * 动态规划
     * 从后向前进行对比
     * */
    private static int findLength(int[] A, int[] B) {
        int a = A.length;
        int b = B.length;
        int[][] dp = new int[a + 1][b + 1];
        int ans = 0;
        for (int i = a - 1; i >= 0; i--) {
            for (int j = b - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
