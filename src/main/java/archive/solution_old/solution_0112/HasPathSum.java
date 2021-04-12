package archive.solution_old.solution_0112;

import entity.TreeNode;

import java.util.Stack;

public class HasPathSum {
    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     * */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.left.left = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        treeNode.right = new TreeNode(8);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.right = new TreeNode(1);
        int sum = 22;
        System.out.println(hasPathSum(treeNode, sum));
    }

    /**
     * 深度遍历。 每次将左右子节点加入到栈的时候，求得和父节点的和赋值给子节点。带入下一次计算
     * */
    private static boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (treeNode != null) {
                int val = treeNode.val;
                if (treeNode.left == null && treeNode.right == null) {
                    if (val == sum) {
                        return true;
                    }
                }
                if (treeNode.left != null) {
                    treeNode.left.val = treeNode.left.val + val;
                    stack.push(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNode.right.val = treeNode.right.val + val;
                    stack.push(treeNode.right);
                }
            }
        }
        return false;
    }
}
