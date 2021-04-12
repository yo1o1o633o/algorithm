package archive.solution_old.solution_0997;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindJudge {
    /**
     * 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
     *
     * 如果小镇的法官真的存在，那么：
     *
     * 小镇的法官不相信任何人。
     * 每个人（除了小镇法官外）都信任小镇的法官。
     * 只有一个人同时满足属性 1 和属性 2 。
     * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
     *
     * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
     * */
    public static void main(String[] args) {
        int[][] trust = {};
        int N = 1;
        System.out.println(findJudge(N, trust));
        System.out.println(findJudge1(N, trust));
    }

    /**
     * 法官不信任任何人， 那么法官的节点没有出度
     * 所有人都信任法官， 那么法官有N-1个入度
     * 所有数组的第二个元素是被信任， 即要出现N-1次
     * 同时这个没出现在第一个元素。
     * */
    private static int findJudge(int N, int[][] trust) {
        if (trust.length == 0) {
            if (N == 1) {
                return N;
            }
            return N - 1;
        }
        int people = N - 1;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> maps = new HashMap<>();
        for (int[] ints : trust) {
            maps.put(ints[1], maps.getOrDefault(ints[1], 0) + 1);
            set.add(ints[0]);
        }
        for (Map.Entry<Integer, Integer> map : maps.entrySet()) {
            if (map.getValue() == people && !set.contains(map.getKey())) {
                return map.getKey();
            }
        }
        return -1;
    }

    /**
     * 使用数组来记录出度和入度。
     * */
    private static int findJudge1(int N, int[][] trust) {
        int[] in = new int[N + 1];
        int[] out = new int[N + 1];
        for (int[] p : trust) {
            int left = p[0];
            int right = p[1];
            in[right]++;
            out[left]++;
        }
        for (int i = 1; i <= N; i++) {
            if (in[i] == N - 1 && out[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
