package archive.solution_old.solution_0207;

import java.util.*;

public class CanFinish {
    /**
     * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
     *
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
     *
     * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
     * */
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {
                {1, 0},
                {0, 1}
//                {0, 3},
//                {0, 2},
//                {3, 2},
//                {2, 5},
//                {4, 5},
//                {5, 6},
//                {2, 4}
        };
        System.out.println(canFinish(numCourses, prerequisites));
    }

    /**
     * 有向图， 每个元素都有一个入度和出度值， 即指向当前元素的为入度，每有一个累计加1. 出度也是一样。
     *
     * */
    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        // 找出所有的课程对应关系,保存为Map
        Map<Integer, List<Integer>> maps = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            List<Integer> integers = maps.getOrDefault(prerequisite[1], new ArrayList<>());
            integers.add(prerequisite[0]);
            maps.put(prerequisite[1], integers);
        }
        // 保存所有的入度信息,课程号为索引,元素值为入度值
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            inDegree[pre[0]]++;
        }
        // 避免重复入队
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        // 将所有入度为0的索引入队
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                set.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer point = queue.remove();
                // 从Map中获取该课程号的指向元素
                List<Integer> list = maps.get(point);
                if (list == null) {
                    continue;
                }
                // 将对应的入度减一
                for (Integer l : list) {
                    inDegree[l]--;
                }
                // 将最新的入度值为0的入队
                for (int j = 0; j < inDegree.length; j++) {
                    if (inDegree[j] == 0 && !set.contains(j)) {
                        queue.add(j);
                        set.add(j);
                    }
                }
            }
        }
        // 还有入度值不为0的即有的课没上
        for (int in : inDegree) {
            if (in > 0) {
                return false;
            }
        }
        return true;
    }
}
