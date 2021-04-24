package solution.solution_0103;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(zigzagLevelOrderRecursion(root));
    }

    /**
     * 使用队列。增加一个标记，每层完成后切换标记
     */
    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);

        List<List<Integer>> res = new ArrayList<>();
        boolean b = false;
        while (!list.isEmpty()) {
            int size = list.size();
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (!b) {
                    TreeNode node = list.removeFirst();
                    arr.add(node.val);
                    if (node.left != null) {
                        list.add(node.left);
                    }
                    if (node.right != null) {
                        list.add(node.right);
                    }
                } else {
                    TreeNode node = list.removeLast();
                    arr.add(node.val);
                    if (node.right != null) {
                        list.add(0, node.right);
                    }
                    if (node.left != null) {
                        list.add(0, node.left);
                    }
                }
            }
            b = !b;
            res.add(arr);
        }
        return res;
    }

    /**
     * 层序遍历， 增加判断层数是偶数就反着保存数据
     * */
    private static List<List<Integer>> zigzagLevelOrderRecursion(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(root, 1, res);
        return res;
    }

    private static void recursion(TreeNode root, int d, List<List<Integer>> res) {
        if (root != null) {
            if (res.size() < d) {
                res.add(new ArrayList<>());
            }
            if (d % 2 == 0) {
                res.get(d - 1).add(0, root.val);
            } else {
                res.get(d - 1).add(root.val);
            }
            recursion(root.left, d + 1, res);
            recursion(root.right, d + 1, res);
        }
    }
}
