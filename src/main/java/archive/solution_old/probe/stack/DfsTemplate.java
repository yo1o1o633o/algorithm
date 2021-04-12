package archive.solution_old.probe.stack;

import entity.TreeNode;

import java.util.*;

/**
 * @author shuai.yang
 */
public class DfsTemplate {
    public static void main(String[] args) {

    }

    private static boolean dfs(TreeNode node, Integer target, Set<TreeNode> visited) {
        if (node.val == target) {
            return true;
        }
        if (!visited.contains(node.left)) {
            visited.add(node.left);
            return dfs(node.left, target, visited);
        }
        if (!visited.contains(node.right)) {
            visited.add(node.right);
            return dfs(node.right, target, visited);
        }
        return false;
    }

    private static boolean dfs2(TreeNode node, Integer target) {
        Set<TreeNode> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);
        set.add(node);
        while (!stack.isEmpty()) {
            TreeNode poll = stack.peek();
            if (poll.val == target) {
                return true;
            }
            if (!set.contains(poll.left)) {
                stack.add(poll.left);
            }
            if (!set.contains(poll.right)) {
                stack.add(poll.right);
            }
            stack.pop();
        }
        return false;
    }
}
