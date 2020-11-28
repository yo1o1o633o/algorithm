package solution;

import java.util.Arrays;

/**
 * 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * */
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9,11},
                {2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 交换交换再交换。4个角的数进行3次交换。 一共交换数组长度次
     * 外圈循环代表二维数组的层数
     * 注意横纵坐标取值， 难点就是取值很绕~~
     * */
    private static void rotate(int[][] matrix) {
        int max = matrix.length - 1;
        for (int j = 0; j < matrix.length / 2; j++) {
            for (int i = j; i < max - j; i++) {
                int temp = matrix[i][max - j];
                matrix[i][max - j] = matrix[j][i];
                matrix[j][i] = matrix[max - i][j];
                matrix[max - i][j] = matrix[max - j][max - i];
                matrix[max - j][max - i] = temp;
            }
        }
    }
}
