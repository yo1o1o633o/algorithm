package solution_0101;

/**
 * @author shuai.yang
 */
public class IsSymmetric {
    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
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
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(3);
        System.out.println(isSymmetric(treeNode));
    }

    /**
     * 递归.
     * 左的左等于右的右
     * */
    private static boolean isSymmetric(TreeNode root) {
        return checkout(root.left, root.right);
    }
    private static boolean checkout(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && checkout(left.left, right.right) && checkout(left.right, right.left);
    }
}
