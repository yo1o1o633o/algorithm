package probe.queue;

import java.util.*;

/**
 * @author shuai.yang
 */
public class FloodFill {
    /**
     * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
     *
     * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
     *
     * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
     *
     * 最后返回经过上色渲染后的图像。
     * */
    public static void main(String[] args) {
        int[][] image = {{0, 0, 0}, {0, 1, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 1;
        System.out.println(Arrays.deepToString(floodFill(image, sr, sc, newColor)));
    }
    private static int[][] dis = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    /**
     * 广度搜索
     * 用set进行重复判断, 已经处理过的节点跳过
     * image表示一个表格. 每个表格里一个值0或1
     * 根据给定的坐标sr,sc  如果对应表格内是1 就把相邻的所有1都涂成newColor. 不能跨越非相邻节点
     * */
    private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int sign = image[sr][sc];
        int row = image[0].length;
        int col = image.length;
        Set<String> set = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = newColor;
        set.add(sr + "-" + sc);
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int[] d : dis) {
                int x1 = d[0] + x;
                int y1 = d[1] + y;
                if (x1 < 0 || y1 < 0 || x1 >= col || y1 >= row || image[x1][y1] != sign) {
                    continue;
                }
                if (image[x1][y1] == sign) {
                    image[x1][y1] = newColor;
                    if (!set.contains(x1 + "-" + y1)) {
                        queue.add(new int[]{x1, y1});
                        set.add(x1 + "-" + y1);
                    }
                }
            }
        }
        return image;
    }
}
