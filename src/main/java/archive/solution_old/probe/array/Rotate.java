package archive.solution_old.probe.array;

import java.util.Arrays;

public class Rotate {
    /**
     * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
     * */
    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
        rotate2(matrix);
    }

    /**
     * 按圈旋转
     * */
    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        int num = n / 2;
        int min = 0;
        int max = n;
        while (num > 0) {
            int[] t = Arrays.copyOf(matrix[min], matrix.length);
            // 左侧边赋值到顶部边 3, 1
            for (int i = max - 1; i >= min; i--) {
                matrix[min][i] = matrix[max - 1 - i + min][min];
            }
            // 底部边赋值到左侧
            for (int i = min; i < max; i++) {
                matrix[i][min] = matrix[max - 1][i];
            }
            // 右侧边赋值到底边
            for (int i = min; i < max; i++) {
                matrix[max - 1][i] = matrix[max - 1 - i + min][max - 1];
            }
            // 上边赋值到右侧边
            for (int i = min; i < max; i++) {
                matrix[i][max - 1] = t[i];
            }
            num--;
            n = n - 2;
            min++;
            max--;
        }
    }

    /**
     * 找寻规律。
     * matrix[row][col] 变换之后的位置是matrix[col][n - row - 1]
     * */
    private static void rotate1(int[][] matrix) {
        int n = matrix.length;
        // 对数组进行深拷贝, 赋值到新的数组内
        int[][] newMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            newMatrix[i] = newMatrix[i].clone();
        }
        // 根据公式对每个元素进行赋值
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                newMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }
        // 将结果深拷贝回原数组
        for (int i = 0; i < newMatrix.length; i++) {
            matrix[i] = newMatrix[i].clone();
        }
    }

    /**
     * 利用两次翻转。
     * */
    private static void rotate2(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
        // 对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}
