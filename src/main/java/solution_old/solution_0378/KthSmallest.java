package solution_old.solution_0378;

import java.util.Arrays;

public class KthSmallest {
    /**
     * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
     * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
     * */
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        System.out.println(kthSmallest(matrix, k));
    }

    /**
     * 合并成一个数组， 进行排序取值
     * */
    private static int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int[] sign = new int[len * len];
        int x = 0;
        for (int[] ma : matrix) {
            for (int m : ma) {
                sign[x++] = m;
            }
        }
        Arrays.sort(sign);
        return sign[k - 1];
    }
}
