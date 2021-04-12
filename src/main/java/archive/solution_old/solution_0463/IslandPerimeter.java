package archive.solution_old.solution_0463;

/**
 * @author shuai.yang
 */
public class IslandPerimeter {
    /**
     * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
     *
     * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
     *
     * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
     * */
    public static void main(String[] args) {
        int[][] n = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter(n));
        System.out.println(islandPerimeter1(n));
    }

    /**
     * 先取出总共有多少个块. 每个块4个边
     * 然后上下相接的 -2
     * 左右相接的 -2
     * 剩下的就是周长
     * */
    private static int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count += 4;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            if (i != grid.length - 1) {
                int[] a = grid[i];
                int[] b = grid[i + 1];
                for (int j = 0; j < a.length; j++) {
                    if (a[j] == 1 && b[j] == 1) {
                        count -= 2;
                    }
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            int[] a = grid[i];
            for (int j = 0; j < a.length; j++) {
                if (j != a.length - 1) {
                    if (a[j] == 1 && a[j + 1] == 1) {
                        count -= 2;
                    }
                }
            }
        }
        return count;
    }

    private static int islandPerimeter1(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }
    /**
     * 找到第一个岛屿. 开始递归.DFS算法
     *
     * 从岛屿触发, 每次要向4个方向前进.
     * 首先判断岛屿是否是合法的.
     * 然后用2记录已经走过的格子
     * 每当从岛屿走到非岛屿的时候, 周长+1. 非岛屿要么是水 要么是边界.
     * */
    private static int dfs(int[][] grid, int r, int c) {
        if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
            return 1;
        }
        if (grid[r][c] == 0) {
            return 1;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        return dfs(grid, r - 1, c) + dfs(grid, r + 1, c) + dfs(grid, r, c - 1) + dfs(grid, r, c + 1);
    }
}
