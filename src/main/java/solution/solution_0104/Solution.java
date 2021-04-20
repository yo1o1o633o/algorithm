package solution.solution_0104;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * */
public class Solution {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        node.left.left.left = new TreeNode(8);
        node.left.left.right = new TreeNode(9);
        node.left.right.left = new TreeNode(10);
        node.left.right.right = new TreeNode(11);
        node.right.left.left = new TreeNode(12);
        node.right.left.right = new TreeNode(13);
        node.right.right.left = new TreeNode(14);
        node.right.right.right = new TreeNode(15);

        System.out.println(maxDepthWithRecursion(node));
    }

    /**
     * 用队列进行处理. 如果使用栈, 会再取出当前层的时候取出下一层的数据, 因为是取出一个节点将下一层的放入栈, 此时当前层未取完会被压到栈底去.
     * 因为栈是后进先出的. 换成队列后今后出就没问题了
     *
     * 深度优先搜索
     * */
    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.poll();
                if (pop == null) {
                    continue;
                }
                if (pop.left != null) {
                    queue.add(pop.left);
                }
                if (pop.right != null) {
                    queue.add(pop.right);
                }
            }
        }
        return res;
    }

    /**
     * 递归
     * 计算每个递归到最后节点到顶点的最大值
     *
     * */
    private static int maxDepthWithRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepthWithRecursion(root.left);
        int r = maxDepthWithRecursion(root.right);
        return 1 + Math.max(l, r);
    }
}
