package solution.solution_0102;

import entity.TreeNode;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(levelOrderWithRecursion(root));
    }

    /**
     * 迭代。 使用队列， 先进先出。 如果使用栈 会导致顺序错乱， 不是不能用， 但是取出后要处理顺序问题
     */
    private static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> t = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.poll();
                if (pop == null) {
                    continue;
                }
                t.add(pop.val);
                if (pop.left != null) {
                    queue.add(pop.left);
                }
                if (pop.right != null) {
                    queue.add(pop.right);
                }
            }
            res.add(t);
        }
        return res;
    }

    /**
     * 递归
     * 用index记录二叉树的层。
     * 取出对应的值后按照index记录的层数放入数据
     * 递归时， index的值只会在当前逻辑内变化
     * <p>
     * 如index=1
     * if (root.left != null) {
     *      这里传到下一次递归的是2
     *      recursion(index + 1, root.left, res);
     * }
     * if (root.right != null) {
     *      这里传到下一次递归的也是2
     *      recursion(index  + 1, root.right, res);
     * }
     * index表示一层
     *
     * 入参的测试用例有null
     */
    private static List<List<Integer>> levelOrderWithRecursion(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        recursion(1, root, res);
        return res;
    }

    private static void recursion(Integer index, TreeNode root, List<List<Integer>> res) {
        // 创建一个空的列表, 用来保存数据
        if (res.size() < index) {
            res.add(new ArrayList<>());
        }
        res.get(index - 1).add(root.val);
        if (root.left != null) {
            recursion(index + 1, root.left, res);
        }
        if (root.right != null) {
            recursion(index + 1, root.right, res);
        }
    }
}
