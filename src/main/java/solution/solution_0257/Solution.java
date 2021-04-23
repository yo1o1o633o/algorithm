package solution.solution_0257;

import entity.TreeNode;

import java.util.*;

/**
 * 257. 二叉树的所有路径
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径
 * */
public class Solution {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(5);

        System.out.println(binaryTreePathsWithBf(node));
    }

    /**
     * 递归的进行组装. 左右节点任一不为null就向下递归, 碰到左右节点都为null, 则放入返回列表中
     * */
    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        recursion(root, "", res);
        return res;
    }
    private static void recursion(TreeNode root, String val, List<String> res) {
        if (root == null) {
            return;
        }
        val = val.equals("") ? String.valueOf(root.val) : val + "->" + root.val;
        if (root.left != null) {
            recursion(root.left, val, res);
        }
        if (root.right != null) {
            recursion(root.right, val, res);
        }
        if (root.left == null && root.right == null) {
            res.add(val);
        }
    }

    /**
     * 使用两个队列. 一个装返回值字符串
     * 每次组装后取出, 直至没有左右节点就放入结果集
     * */
    private static List<String> binaryTreePathsWithBf(TreeNode root) {
        List<String> res = new ArrayList<>();
        Queue<TreeNode> stack = new LinkedList<>();
        Queue<String> content = new LinkedList<>();
        stack.add(root);
        content.add(String.valueOf(root.val));
        while (!stack.isEmpty()) {
            TreeNode peek = stack.poll();
            String con = content.poll();
            if (peek == null) {
                continue;
            }
            if (peek.left == null && peek.right == null) {
                res.add(con);
            } else {
                if (peek.left != null) {
                    stack.add(peek.left);
                    content.add(con + "->" + peek.left.val);
                }
                if (peek.right != null) {
                    stack.add(peek.right);
                    content.add(con + "->" + peek.right.val);
                }
            }
        }
        return res;
    }
}
