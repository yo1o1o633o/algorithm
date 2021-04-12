package archive.solution_old.probe.stack;

import java.util.Arrays;

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

    private static int numIslands(char[][] grid) {
        int step = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    step++;
                    helper(grid, i, j);
                    System.out.println(Arrays.deepToString(grid));
                }
            }
        }
        return step;
    }
    private static void helper(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int[] d : dis) {
            int x = i + d[0];
            int y = j + d[1];
            helper(grid, x, y);
        }
    }
}
