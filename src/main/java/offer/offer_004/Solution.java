package offer.offer_004;

/**
 * 剑指 Offer 04. 二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * */
public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        };
        int[][] matrix2 = {{}};
        System.out.println(findNumberIn2DArray3(matrix2, 1));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (target == anInt) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 从下向上开始。去数组第一个元素。因为每行数组都是升序的，则第一个元素比目标值大。 那么整行都不用判断
     * 如果第一个元素比目标值小。 则二分在数组中找。 没找到继续向上
     * */
    private static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        for (int i = matrix.length - 1; i >= 0; i--) {
            if (matrix[i].length == 0) {
                continue;
            }
            int first = matrix[i][0];
            if (first == target) {
                return true;
            } else if (first < target) {
                int[] ints = matrix[i];
                // 二分
                int a = 0;
                int b = ints.length - 1;
                while (a <= b) {
                    int mid = (a + b) / 2;
                    if (ints[mid] == target) {
                        return true;
                    }
                    if (ints[mid] < target) {
                        a = mid + 1;
                    } else {
                        b = mid - 1;
                    }
                }
            }
        }
        return false;
    }

    private static boolean findNumberIn2DArray3(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
