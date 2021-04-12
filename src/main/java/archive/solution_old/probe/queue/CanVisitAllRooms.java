package archive.solution_old.probe.queue;

import java.util.*;

/**
 * @author shuai.yang
 */
public class CanVisitAllRooms {
    /**
     * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
     *
     * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
     *
     * 最初，除 0 号房间外的其余所有房间都被锁住。
     *
     * 你可以自由地在房间之间来回走动。
     *
     * 如果能进入每个房间返回 true，否则返回 false。
     * */
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(0);
        b.add(1);
        List<Integer> c = new ArrayList<>();
        c.add(3);
        List<Integer> d = new ArrayList<>();
        c.add(0);
        rooms.add(a);
        rooms.add(b);
        rooms.add(c);
        rooms.add(d);
        System.out.println(canVisitAllRooms(rooms));
    }

    /**
     * 搞个标记数组, 对已经开过的房间标记. 最后如果标记种有未开过的就返回false
     * */
    private static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] sign = new int[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        sign[0] = 1;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<Integer> point = rooms.get(poll);
            for (Integer p : point) {
                if (p < 0 || p > rooms.size() || p > sign.length) {
                    continue;
                }
                if (sign[p] == 0) {
                    queue.add(p);
                }
                sign[p] = 1;
            }
        }
        for (int value : sign) {
            if (value == 0) {
                return false;
            }
        }
        return true;
    }
}
