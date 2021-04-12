package archive.solution_old.solution_0429;

import entity.MultiTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    /**
     * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
     * */
    public static void main(String[] args) {
        MultiTreeNode multiTreeNode1 = new MultiTreeNode(5);
        MultiTreeNode multiTreeNode2 = new MultiTreeNode(6);
        List<MultiTreeNode> list = new ArrayList<>();
        list.add(multiTreeNode1);
        list.add(multiTreeNode2);

        MultiTreeNode multiTreeNode3 = new MultiTreeNode(3);
        MultiTreeNode multiTreeNode4 = new MultiTreeNode(2);
        MultiTreeNode multiTreeNode5 = new MultiTreeNode(4);
        multiTreeNode3.children = list;
        List<MultiTreeNode> list1 = new ArrayList<>();
        list1.add(multiTreeNode3);
        list1.add(multiTreeNode4);
        list1.add(multiTreeNode5);

        MultiTreeNode multiTreeNode = new MultiTreeNode(1);
        multiTreeNode.children = list1;
        System.out.println(levelOrder(multiTreeNode));
    }

    /**
     * 广度搜索
     * */
    private static List<List<Integer>> levelOrder(MultiTreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<MultiTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                MultiTreeNode poll = queue.poll();
                if (poll != null) {
                    // 将每层的节点值放入列表内
                    nums.add(poll.val);
                    if (poll.children != null && poll.children.size() > 0) {
                        queue.addAll(poll.children);
                    }
                }
            }
            res.add(nums);
        }
        return res;
    }
}
