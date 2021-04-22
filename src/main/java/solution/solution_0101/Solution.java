package solution.solution_0101;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 * */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(isSymmetricWithFor(root));
    }

    /**
     * 递归. 都为null返回true, 一个位null返回false. 值相同返回true
     * 每次递归比较左的右节点和右的左节点
     * */
    private static boolean isSymmetric(TreeNode root) {
        return recursion(root, root);
    }
    private static boolean recursion(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        boolean a = recursion(left.right, right.left);
        boolean b = recursion(right.left, left.right);
        return left.val == right.val && a && b;
    }

    /**
     * 迭代. 放入两次根节点
     * 使用队列
     * 每次取出队列前两个进行判断.
     * 如果相同, 则取左的左, 右的右, 左的右, 右的左进行入队
     * 此时每次取出的两个只要不同就不是对称的
     * */
    private static boolean isSymmetricWithFor(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode last = queue.poll();
            if (first == null && last == null) {
                continue;
            }
            if (first == null || last == null) {
                return false;
            }
            if (first.val != last.val) {
                return false;
            }
            queue.add(first.left);
            queue.add(last.right);
            queue.add(first.right);
            queue.add(last.left);
        }
        return true;
    }
}
