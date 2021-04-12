package archive.solution_old.probe.queue;

import java.util.*;

public class UpdateMatrix {
    /**
     * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
     *
     * 两个相邻元素间的距离为 1 。
     * */
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(updateMatrix(matrix)));
    }

    private static int[][] dis = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int[][] updateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = helper(matrix, i, j);
                }
            }
        }
        return matrix;
    }

    private static int helper(int[][] matrix, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int step = -1;
        while (!queue.isEmpty()) {
            step = step + 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                if (point != null) {
                    int x1 = point[0];
                    int y1 = point[1];
                    if (matrix[x1][y1] == 0) {
                        return step;
                    }
                    for (int[] d : dis) {
                        int x2 = x1 + d[0];
                        int y2 = y1 + d[1];
                        if (x2 < 0 || y2 < 0 || x2 >= matrix.length || y2 >= matrix[0].length) {
                            continue;
                        }
                        queue.add(new int[]{x2, y2});
                    }
                }
            }
        }
        return 0;
    }
}
