package solution.solution_0543;

import entity.TreeNode;

/**
 * 543. 二叉树的直径
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * */
public class Solution {
    private static int ans;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(4);

        System.out.println(diameterOfBinaryTree(root));
    }

    /**
     * 从下向上进行统计长度
     * 记录左右路径的最大长度同时更新左右路径的和
     * */
    private static int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        recursion(root);
        return ans - 1;
    }
    private static int recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = recursion(root.left);
        int r = recursion(root.right);
        // 更新上层的深度
        ans = Math.max(ans, l + r + 1);
        // 给上一层返回左右分支的最大深度
        return Math.max(l, r) + 1;
    }
}
