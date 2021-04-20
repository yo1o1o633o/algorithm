package solution.solution_0226;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. 翻转二叉树
 *
 * 翻转一棵二叉树。
 * */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        invertTreeWithFor(root);
    }

    /**
     * 没想象中的难。
     * 从上向下翻转。 每次只要翻转当前层的左右节点就可以
     * 第二层翻转完， 第三层的两对儿左右节点已经交换一次了。只交换自己的左右节点就行
     * */
    private static void invertTreeWithRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTreeWithRecursion(root.left);
        invertTreeWithRecursion(root.right);
    }


    /**
     * 迭代
     * */
    private static void invertTreeWithFor(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                TreeNode left = poll.left;
                poll.left = poll.right;
                poll.right = left;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
    }
}
