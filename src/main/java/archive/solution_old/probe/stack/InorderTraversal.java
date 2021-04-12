package archive.solution_old.probe.stack;

import entity.TreeNode;

import java.util.*;

/**
 * @author shuai.yang
 */
public class InorderTraversal {
    /**
     * 给定一个二叉树，返回它的中序 遍历。
     * */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        System.out.println(inorderTraversal(treeNode));
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
}
