package archive.solution_old.solution_0144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    /**
     * 给定一个二叉树，返回它的 前序 遍历。
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
        System.out.println(preorderTraversal(treeNode));
        System.out.println(preorderTraversal2(treeNode));
        System.out.println(preorderTraversal3(treeNode));
    }

    /**
     * 前序遍历。 根左右形式
     * 放入根， 之后递归左根， 然后递归右根
     * */
    private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    private static void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }

    /**
     * 迭代。依赖栈来处理
     * 先放入根节点val
     * 然后按照右节点，左节点入栈。 因为左节点要先出栈， 所以后入栈
     * 弹出左节点后如果还有子节点。 那么继续将子节点放入栈中
     * 当左节点都处理完后， 弹出右节点处理
     *
     * */
    private static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            // 保存根节点的值
            res.add(treeNode.val);
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
        return res;
    }

    /**
     * 莫里斯遍历
     * 当有左节点时。找到最右子节点。并指回当前节点
     * */
    private static List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                res.add(node.val);
                node = node.right;
            } else {
                TreeNode predecessor = node.left;
                // 找到最右节点
                while (predecessor.right != null && predecessor.right != node) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    res.add(node.val);
                    predecessor.right = node;
                    node = node.left;
                } else {
                    predecessor.right = null;
                    node = node.right;
                }
            }
        }
        return res;
    }
}
