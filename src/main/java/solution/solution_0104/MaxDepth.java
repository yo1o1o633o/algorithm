package solution.solution_0104;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shuai.yang
 */
public class MaxDepth {
    /**
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     * */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(3);
        System.out.println(maxDepth(treeNode));
        System.out.println(maxDepth2(treeNode));
    }

    /**
     * 递归
     * 递归处理左右两个节点. 每次递归对值+1.
     * 递归的节点是左右节点.其中一个节点为null时回归
     * */
    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

    /**
     * 迭代
     * Pair 便捷key-value类. 用于保存key-value格式数据
     * 定义一个队列
     * 先将父节点放进对列.深度为1
     * 循环内取出队列中的元素, 如果不为null 那么就将左右节点放入队列中. 同时左右节点深度+1
     * 最后取出最大的深度值
     * */
    private static int maxDepth2(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        if (root != null) {
            queue.add(new Pair<>(root, 1));
        }
        int depth = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            root = pair.getKey();
            int rootDepth = pair.getValue();
            if (root != null) {
                depth = Math.max(rootDepth, depth);
                queue.add(new Pair<>(root.left, rootDepth + 1));
                queue.add(new Pair<>(root.right, rootDepth + 1));
            }
        }
        return depth;
    }
}
