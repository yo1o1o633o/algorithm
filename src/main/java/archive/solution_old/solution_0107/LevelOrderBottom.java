package archive.solution_old.solution_0107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom {
    /**
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
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
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.left.left = new TreeNode(40);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(levelOrderBottom(treeNode));
    }

    /**
     * DFS类型题
     * 深度优先遍历
     * 误区： 一直想不明白怎么处理同级数组。 即按之前做题放入队列的是左右都有的情况。
     * 维持队列内容只包含当前一级。 即第一横行入队处理。 之后把其左右入队
     * 再出队两个。处理完入队其下四个
     * 再循环出队四个。 入队8个
     * 即一直保持队列为空时再写入下一级的节点
     * */
    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode q = queue.poll();
                if (q != null) {
                    temp.add(q.val);
                    queue.add(q.left);
                    queue.add(q.right);
                }
            }
            if (temp.size() > 0) {
                res.add(0, temp);
            }
        }
        return res;
    }
}
