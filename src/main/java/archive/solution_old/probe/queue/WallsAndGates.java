package archive.solution_old.probe.queue;

import javafx.util.Pair;

import java.util.*;

/**
 * @author shuai.yang
 */
public class WallsAndGates {
    /**
     * 墙与门
     * 你被给定一个 m × n 的二维网格，网格中有以下三种可能的初始化值：
     *
     * -1 表示墙或是障碍物
     * 0 表示一扇门
     * INF 无限表示一个空的房间。然后，我们用 231 - 1 = 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 的。
     * 你要给每个空房间位上填上该房间到 最近 门的距离，如果无法到达门，则填 INF 即可。
     * */
    public static void main(String[] args) {
        int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1}};
        wallsAndGates1(rooms);
    }

    private static int[][] dis = {{-1, 0},{1, 0},{0, -1},{0, 1}};

    /**
     * 循环找到每个房间. 对每个房间进行广度优先搜索
     * */
    private static void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 2147483647) {
                    rooms[i][j] = helper(rooms, i, j);
                }
            }
        }
        System.out.println(Arrays.deepToString(rooms));
    }
    private static Integer helper(int[][] rooms, int x, int y) {
        int height = rooms.length;
        int width = rooms[0].length;
        int[][] distance = new int[height][width];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(x, y));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> point = queue.poll();
            if (point != null) {
                int x1 = point.getKey();
                int y1 = point.getValue();
                for (int[] d : dis) {
                    int x2 = x1 + d[0];
                    int y2 = y1 + d[1];
                    if (x2 < 0 || y2 < 0 || x2 >= height || y2 >= width || rooms[x2][y2] == -1 || distance[x2][y2] != 0) {
                        continue;
                    }
                    distance[x2][y2] = distance[x1][y1] + 1;
                    if (rooms[x2][y2] == 0) {
                        return distance[x2][y2];
                    }
                    queue.add(new Pair<>(x2, y2));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 尝试找到每个门, 对门进行广度优先搜索. 找房间.
     * 每个门就是0. 那么找到的第一级就是1. 往后每向后搜索一层就加1
     * */
    private static void wallsAndGates1(int[][] rooms) {
        int height = rooms.length;
        if (height == 0) {
            return;
        }
        int width = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int[] d : dis) {
                int x1 = x + d[0];
                int y1 = y + d[1];
                if (x1 < 0 || y1 < 0 || x1 >= height || y1 >= width || rooms[x1][y1] != 2147483647) {
                    continue;
                }
                rooms[x1][y1] = rooms[x][y] + 1;
                queue.add(new int[]{x1, y1});
            }
        }
        System.out.println(Arrays.deepToString(rooms));
    }
}
