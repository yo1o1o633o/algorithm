package archive.solution_old.solution_0785;

import java.util.*;

public class IsBipartite {
    /**
     * 给定一个无向图graph，当这个图为二分图时返回true。
     *
     * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
     *
     * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
     * */
    public static void main(String[] args) {
        int[][] graph = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };
        System.out.println(isBipartite(graph));
    }

    /**
     * 广度搜索
     * 定义邻接表
     * 每一层填充一种颜色， 如果下一次颜色不是和当前相反颜色，则不合法
     * 即当前是红色， 那么下次是绿色， 如果下次不是空颜色同时非绿色。 那么返回false
     * */
    private static boolean isBipartite(int[][] graph) {
        int unColor = 0;
        int red = 1;
        int green = 2;
        int[] color = new int[graph.length];
        // 默认填充空颜色
        Arrays.fill(color, unColor);
        for (int i = 0; i < graph.length; i++) {
            // 选取每个未填充过颜色的节点
            if (color[i] == unColor) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                while (!queue.isEmpty()) {
                    int poll = queue.poll();
                    // 定义当前颜色的相反颜色
                    int c = color[poll] == red ? green : red;
                    for (int g : graph[poll]) {
                        // 如果当前节点的相邻节点是未填充颜色，就放入队列， 同时给填上相反颜色
                        if (color[g] == unColor) {
                            queue.add(g);
                            color[g] = c;
                        }
                        // 如果当前节点的相邻节点和当前节点颜色相同， 那么返回false
                        else if (color[g] != c) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
