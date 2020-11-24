package solution_old.probe.queue;

import java.util.*;

/**
 * @author shuai.yang
 */
public class OpenLock {
    /**
     * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
     *
     * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
     *
     * 列表 deadEnds 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
     *
     * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
     * */
    public static void main(String[] args) {
        String[] deadEnds = {"0000"};
        String target = "8888";
        System.out.println(openLock(deadEnds, target));
    }

    private static int[][] dis = {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1},
            {-1, 0, 0, 0},
            {0, -1, 0, 0},
            {0, 0, -1, 0},
            {0, 0, 0, -1},
    };

    /**
     * 每次前进8个可能性. 0001  0010  0100 1000  0009  0090  0900 9000
     * */
    private static int openLock(String[] deadEnds, String target) {
        Set<String> dead = new HashSet<>();
        Collections.addAll(dead, deadEnds);
        if (dead.contains("0000")) {
            return -1;
        }

        Set<String> used = new HashSet<>();
        used.add("0000");

        Queue<int[]> queue = new LinkedList<>();
        int step = -1;
        queue.add(new int[]{0,0,0,0});
        while (!queue.isEmpty()) {
            step = step + 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                if (point == null) {
                    continue;
                }
                int a = point[0];
                int b = point[1];
                int c = point[2];
                int d = point[3];
                if (target.equals("" + a + b + c + d)) {
                    return step;
                }
                for (int[] di : dis) {
                    StringBuilder str = new StringBuilder();
                    int a1 = getInt(a, di[0]);
                    int b1 = getInt(b, di[1]);
                    int c1 = getInt(c, di[2]);
                    int d1 = getInt(d, di[3]);
                    str.append(a1);
                    str.append(b1);
                    str.append(c1);
                    str.append(d1);
                    String s = str.toString();
                    if (dead.contains(s) || used.contains(s)) {
                        continue;
                    }
                    used.add(s);
                    queue.add(new int[]{a1, b1, c1, d1});
                }
            }
        }
        return -1;
    }
    private static int getInt(int i, int j) {
        if (i == 9 && j == 1) {
            return 0;
        }
        if (i == 0 && j == -1) {
           return 9;
        }
        return i + j;
    }
}
