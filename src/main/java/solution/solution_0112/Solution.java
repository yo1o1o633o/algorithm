package solution.solution_0112;

import entity.TreeNode;

import java.util.*;

/**
 * 112. 路径总和
 *
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(hasPathSum(root, 22));
    }

    /**
     * 深度搜索。使用另一个队列来记录每次节点计算的和
     * */
    private static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> stack = new LinkedList<>();
        Queue<Integer> path = new LinkedList<>();
        stack.add(root);
        path.add(root.val);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.poll();
            Integer p = path.poll();
            if (p == null) {
                continue;
            }
            if (pop.left == null && pop.right == null) {
                if (p == targetSum) {
                    return true;
                }
                continue;
            }
            if (pop.left != null) {
                stack.offer(pop.left);
                path.offer(pop.left.val + p);
            }
            if (pop.right != null) {
                stack.offer(pop.right);
                path.offer(pop.right.val + p);
            }
        }
        return false;
    }

    /**
     * 递归的向下减
     * 目标值一直减去节点的值，左右任一返回true
     * 当左右节点都为null 即到最后一个节点，判断剩下的值和节点的值是否相等， 相等表示正好被减没
     * */
    private static boolean hasPathSumWithRecursion(TreeNode root, int targetSum) {
         if (root == null) {
             return false;
         }
         if (root.left == null && root.right == null) {
             return root.val == targetSum;
         }
         return hasPathSumWithRecursion(root.left, targetSum - root.val) || hasPathSumWithRecursion(root.right, targetSum - root.val);
    }
}
