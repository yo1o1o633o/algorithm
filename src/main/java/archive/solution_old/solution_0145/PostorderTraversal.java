package archive.solution_old.solution_0145;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    /**
     * 给定一个二叉树，返回它的 后序 遍历。
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
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        System.out.println(postorderTraversal(treeNode));
    }

    /**
     * 递归
     * 最后放入根节点
     * 左右根
     * */
    private static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    private static void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }
}
