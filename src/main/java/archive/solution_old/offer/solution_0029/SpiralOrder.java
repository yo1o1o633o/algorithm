package archive.solution_old.offer.solution_0029;

import java.util.Arrays;

/**
 * @author shuai.yang
 */
public class SpiralOrder {
    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
     * */
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(Arrays.toString(spiralOrder(matrix)));
        System.out.println(Arrays.toString(spiralOrder1(matrix)));
    }

    /**
     * 循环搞. 每次循环完对索引+1或-1操作判断是否有下一个. 没有就跳出循环. 有就继续循环取值.
     * 每次循环后长或宽会减一, 也就是会向内圈进一
     * */
    private static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int u = 0, d = matrix.length - 1, l = 0, r = matrix[0].length - 1;
        int idx = 0;
        while (true) {
            for (int i = l; i <= r; i++) {
                res[idx++] = matrix[u][i];
            }
            if (++u > d) {
                break;
            }
            for (int i = u; i <= d; i++) {
                res[idx++] = matrix[i][r];
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res[idx++] = matrix[d][i];
            }
            if (--d < u) {
                break;
            }
            for (int i = d; i >= u; i--) {
                res[idx++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }

    /**
     * 按圈来处理
     * 先处理外圈, 然后往里缩一圈. 直到中心点
     * */
    private static int[] spiralOrder1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] res = new int[rows * columns];
        int index = 0;
        int left = 0;
        int right = columns - 1;
        int top = 0;
        int bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                res[index++] = matrix[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                res[index++] = matrix[row][right];
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    res[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    res[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
