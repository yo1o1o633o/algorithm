package solution.solution_0207;

import java.util.*;

public class CanFinish {
    public static void main(String[] args) {
        int numCourses = 7;
        int[][] prerequisites = {
                {1, 0},
                {0, 3},
                {0, 2},
                {3, 2},
                {2, 5},
                {4, 5},
                {5, 6},
                {2, 4}
        };
        System.out.println(canFinish(numCourses, prerequisites));
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        TreeMap<Integer, List<Integer>> maps = new TreeMap<>();
        for (int[] prerequisite : prerequisites) {
            List<Integer> classes = maps.getOrDefault(prerequisite[0], new ArrayList<>());
            classes.add(prerequisite[1]);
            maps.put(prerequisite[0], classes);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(maps.firstKey());
        Set<Integer> set = new HashSet<>();
        Set<Integer> co = new HashSet<>();
        co.add(maps.firstKey());
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer point = queue.remove();
                List<Integer> list = maps.getOrDefault(point, new ArrayList<>());
                for (Integer l : list) {
                    if (set.contains(l) || l > numCourses) {
                        return false;
                    }
                    if (!co.contains(l)) {
                        queue.add(l);
                        co.add(l);
                    }
                }
                set.add(point);
            }
        }
        return true;
    }
}
