package solution_old.probe.queue;

import java.util.*;

/**
 * @author shuai.yang
 */
public class NumIslands {
    /**
     * 岛屿数量
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     * */
    public static void main(String[] args) {
        String s = "11000,11000,00100,00011";
        String[] c = s.split(",");
        char[][] grid = new char[4][5];
        for (int i = 0; i < c.length; i++) {
            char[] n = c[i].toCharArray();
            grid[i] = n;
        }
        System.out.println(numIslands(grid));
    }

    private static int[][] dis = {{-1, 0},{1, 0},{0, -1},{0, 1}};
    /**
     * 循环将每一块岛设置成海. +1
     * 直到没有陆地
     * */
    private static int numIslands(char[][] grid) {
        int step = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    helper(grid, i, j);
                    step++;
                }
            }
        }
        return step;
    }
    private static void helper(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int[] d : dis) {
                int x1 = x + d[0];
                int y1 = y + d[1];
                int[] r = {x1, y1};
                if (x1 < 0 || y1 < 0 || x1 >= grid.length || y1 >= grid[0].length || grid[x1][y1] == '0') {
                    continue;
                }
                grid[x1][y1] = '0';
                queue.add(r);
            }
        }
    }
}
