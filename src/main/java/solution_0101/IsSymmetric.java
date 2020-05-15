package solution_0101;

import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * 迭代
     * 每次将左的左和右的右放入队列. 左的右和右的左再放入队列
     * 每次取出两个进行迭代判断
     * 其实这里的先遍历了树的左的左的左的左...  右的右的右的右
     * 当上边的满足后
     * 再遍历左的右 右的左. 即中间的
     * */
    private static boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }
}
