package solution.solution_0094;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    /**
     * 给定一个二叉树，返回它的中序 遍历。
     * 左根右结构
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
        System.out.println(inorderTraversal(treeNode));
        System.out.println(inorderTraversal2(treeNode));
        System.out.println(inorderTraversal3(treeNode));
    }

    /**
     * 递归。
     * 中序遍历
     * 左根右模式。递归中也是递归左节点。 放入根， 递归右节点
     * */
    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    private static void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    /**
     * 用栈来实现
     * 先将所有的左节点放入站内。再出栈堆每个节点操作
     * */
    private static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }


    /**
     * 莫里斯遍历
     * */
    private static List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode per;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                per = curr.left;
                while (per.right != null) {
                    per = per.right;
                }
                per.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        return res;
    }
}
