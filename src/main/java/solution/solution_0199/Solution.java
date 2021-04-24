package solution.solution_0199;

import entity.TreeNode;

import java.util.*;

/**
 * 199. 二叉树的右视图
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(rightSideViewWithRecursion(root));
    }

    /**
     * 广度优先， 获取每一层的最后一个节点的值
     * */
    private static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int n = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                n = poll.val;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            res.add(n);
        }

        return res;
    }

    /**
     * 记录层数
     * 每层放入一次节点数据
     * 先放右节点
     * */
    private static List<Integer> rightSideViewWithRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root, 1, list);
        return list;
    }
    private static void recursion(TreeNode root, int d, List<Integer> res) {
        if (root != null) {
            // 每层只会执行一次
            if (res.size() < d) {
                res.add(root.val);
            }
            recursion(root.right, d + 1, res);
            recursion(root.left, d + 1, res);
        }
    }
}
