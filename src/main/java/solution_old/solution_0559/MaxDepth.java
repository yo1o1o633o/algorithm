package solution_old.solution_0559;

import entity.MultiTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shuai.yang
 */
public class MaxDepth {
    /**
     * 给定一个 N 叉树，找到其最大深度。
     *
     * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
     * */
    public static void main(String[] args) {
        MultiTreeNode multiTreeNode1 = new MultiTreeNode(5);
        MultiTreeNode multiTreeNode2 = new MultiTreeNode(6);
        List<MultiTreeNode> list = new ArrayList<>();
        list.add(multiTreeNode1);
        list.add(multiTreeNode2);
        MultiTreeNode multiTreeNode01 = new MultiTreeNode(3, list);
        MultiTreeNode multiTreeNode02 = new MultiTreeNode(2);
        MultiTreeNode multiTreeNode03 = new MultiTreeNode(4);
        List<MultiTreeNode> list01 = new ArrayList<>();
        list01.add(multiTreeNode01);
        list01.add(multiTreeNode02);
        list01.add(multiTreeNode03);
        MultiTreeNode multiTreeNode = new MultiTreeNode(1, list01);
        System.out.println(maxDepth(multiTreeNode));
    }

    /**
     * 将children列表放入队列. 广度搜索
     * */
    private static int maxDepth(MultiTreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<MultiTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                MultiTreeNode poll = queue.poll();
                if (poll != null) {
                    if (poll.children != null) {
                        queue.addAll(poll.children);
                    }
                }
            }
        }
        return step;
    }
}
